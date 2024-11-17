import com.android.build.api.dsl.Packaging

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.project_aurora.emu"
    compileSdk = 34
    buildToolsVersion = "34.0.4"
    ndkVersion = "26.1.10909125"
    
    defaultConfig {
        applicationId = "com.project_aurora.emu"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
        
        ndk {
            abiFilters.addAll(listOf("arm64-v8a"))
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    signingConfigs {
        create("release") {
            keyAlias = "Alias"
            keyPassword = "123456"
            storeFile = file("my-release-key.keystore")
            storePassword = "123456"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }
    
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
        
        // Adrenotools see docs
        dex {
            useLegacyPackaging = true
        }
        
        jniLibs {
            useLegacyPackaging = true
        }
    }
    
    buildFeatures {
        aidl = true
        buildConfig = true
    }
    
    externalNativeBuild {
        cmake {
            version = "3.22.1"
            path = file("src/main/cpp/CMakeLists.txt") // CMakeLists.txt path for compilation
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}


project.tasks.register("buildMesaWrapper") {
    doLast {
        var shellWrapper = arrayOf<String>()
        var path = "src/main/cpp/mesa"
        if (System.getProperty("os.name") == "Linux") {
            shellWrapper = arrayOf("/system/bin/sh", "-c")
        } else {
            throw RuntimeException("Unsupported operating system")
        }
        if (!project.file(path).exists())
            throw RuntimeException("path does not exist: $path")
        val buildDir = project.file("$path/build")
        if (!buildDir.exists()) buildDir.mkdirs()
        
        val mesonProcess = ProcessBuilder().command(*shellWrapper, """CPPFLAGS="-DUSE_GNU -U__ANDROID__ -I/include_ndk" LDFLAGS="-L/data/data/com.itsaky.androidide/files/usr/opt/bionic-host/lib64 -landroid-shmem -llog -lcutils" meson setup build-wrapper-android --cross-file=android-arm64 -Dcpp_rtti=false -Dgbm=disabled -Dopengl=false -Dllvm=disabled -Dshared-llvm=disabled -Dplatforms=x11 -Dgallium-drivers= -Dxmlconfig=disabled -Dvulkan-drivers=wrapper --prefix=${buildDir.absolutePath}""")
            .directory(project.file(path))
            .start()
            
        mesonProcess.inputStream.bufferedReader().lines().forEach { println(it) }
        mesonProcess.errorStream.bufferedReader().lines().forEach { println(it) }
        
        if (mesonProcess.waitFor() != 0)
            throw RuntimeException("meson failed: ${mesonProcess.exitValue()}\nSTDOUT:\n${mesonProcess.inputStream.reader().readText().trim()}\nSTDERR:\n${mesonProcess.errorStream.reader().readText().trim()}")
            
        val ninjaProcess = ProcessBuilder().command(*shellWrapper, "cd build-wrapper-android && ninja -j8 install")
            .directory(project.file(path))
            .start()
            
        ninjaProcess.inputStream.bufferedReader().lines().forEach { println(it) }
        ninjaProcess.errorStream.bufferedReader().lines().forEach { println(it) }    
        if (ninjaProcess.waitFor() != 0)
            throw RuntimeException("ninja failed: ${ninjaProcess.exitValue()}\nSTDOUT:\n${ninjaProcess.inputStream.reader().readText().trim()}\nSTDERR:\n${ninjaProcess.errorStream.reader().readText().trim()}")
    }
    outputs.upToDateWhen { false } // Always run this task
}

project.tasks.whenTaskAdded (fun(t: Task) {
    if (t.name == "generateDebugAssets" || t.name == "generateReleaseAssets")
        t.dependsOn("buildMesaWrapper")
    }
)

dependencies {
    // AndroidX dependencies
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.documentfile:documentfile:1.0.1")
    implementation("androidx.slidingpanelayout:slidingpanelayout:1.2.0")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.work:work-runtime:2.9.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("androidx.preference:preference:1.2.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Other dependencies
    implementation("org.ini4j:ini4j:0.5.4")
    implementation("info.debatty:java-string-similarity:2.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("io.coil-kt:coil:2.5.0")
    implementation("com.google.android.material:material:1.9.0")
    implementation("net.lingala.zip4j:zip4j:2.11.5")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.24")
    
}
