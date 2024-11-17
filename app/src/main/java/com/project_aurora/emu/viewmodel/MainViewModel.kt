package com.project_aurora.emu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LifecycleOwner
import android.content.Intent
import android.content.Context
import java.io.File
import android.view.View
import com.google.android.material.navigation.NavigationBarView
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController

import com.project_aurora.emu.databinding.ActivityMainBinding
import com.project_aurora.emu.coreutils.ZipFileExtractor
import com.project_aurora.emu.coreutils.AsyncTask
import com.project_aurora.emu.coreutils.DispatchersType


interface IPath {
    /** Root Files Extract Location */
    var zipPath: String
}

class MainViewModel : ViewModel() {
    private val asyncTasker = AsyncTask()
    
    companion object Path {
        public val appRootDir = "/data/data/com.project_aurora.emu/files"
        public val usrDir = File("$appRootDir/usr").apply { mkdirs() }
        public val homeDir = File("$appRootDir/home").apply { mkdirs() }
        public val tmpDir = File("$usrDir/tmp").apply { mkdirs() }
        public val xkbRootDir = File("$usrDir/share/X11/xkb")
    }

    fun <T> gotoActivity(owner: Context, clazz: Class<T>) {
         owner.startActivity(Intent(owner, clazz))
    }
    
    fun <T> extractResources(owner: T, binding: ActivityMainBinding) { 
        asyncTasker.newCoroutine("res", {
            if(!usrDir.exists()) {
                 ZipFileExtractor().extractZip(
                    object : IPath {
                        override var zipPath: String = "NULL"
                    }.zipPath,
                    appRootDir,
                    binding.progressExtractBar,
                    binding.updateExtractProgress,
                    owner
                )
            }
        
            asyncTasker.newCoroutine("RunOnUiThread", {
            binding.progressExtractBar.visibility = View.GONE
            binding.updateExtractProgress.visibility = View.GONE
            }, DispatchersType.MAIN)
            
            asyncTasker.executeCoroutine("RunOnUiThread") 
        }, DispatchersType.DEFAULT)
        
        asyncTasker.executeCoroutine("res") 
    }
    
    fun setUpNavigation(navController: NavController, binding: ActivityMainBinding) {
        (binding.bottomNavigation as NavigationBarView).setupWithNavController(navController)
    }
}
