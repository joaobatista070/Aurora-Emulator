#include "co_driver.h"

void CustomDriver::replaceDriver(const std::string &path, const char *hooksDir, const char *driverName) {
    mkdir( ( path + "tmp" ).c_str(), S_IRWXU | S_IRWXG );

    void *libVulkan = adrenotools_open_libvulkan( RTLD_NOW | RTLD_LOCAL // dlopen mode
        , ADRENOTOOLS_DRIVER_CUSTOM // Feature flags
        , ( path + "tmp" ).c_str() // Tmp dir for if api < 29
        , hooksDir // Native lib dir
        , path.c_str() // Custom driver path
        , driverName // Custom driver name
        , nullptr // Redirect Dir
        , nullptr // Mapping handle
        );
                                                  
    if( !libVulkan ) {
        if( !libVulkan ) {
            __android_log_print( ANDROID_LOG_ERROR, "DriverReplacer", "Could not load vulkan library : %s!\n", dlerror() );
        }
    } else {
        __android_log_print( ANDROID_LOG_INFO, "DriverReplacer", "DRIVER REPLACEMENT LOADED" );
    }
}