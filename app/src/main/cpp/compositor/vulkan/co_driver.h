#pragma once

#include <jni.h>
#include <android/log.h>
#include <android/native_window_jni.h>
#include <vulkan/vulkan.h>
#include <vulkan/vulkan_android.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/un.h>
#include <unistd.h>
#include <cstring>
#include <dlfcn.h>
#include <iostream>

#include <adrenotools/driver.h>

/** 
 * Get funcs from vulkan driver 
 */ 
namespace VulkanDriver {
    typedef struct driver_module_t {
        public:
        
        struct dispatch_table {
            PFN_vkCreateInstance pCreateInstance;
        }
        
        void *libvulkan;
        
        /**
         * the proper way
         */
        void openSystemLib(const std::vector<std::string> &modules = {"libvulkan.so", "libvulkan.so.1"}) {
            for (const auto& module : modules) {
                libvulkan = dlopen(module.c_str(), RTLD_NOW | RTLD_LOCAL);
                
                if (libvulkan) {
                    handle(libvulkan); 
                    break;
                } else {
                    __android_log_print(ANDROID_LOG_ERROR, "VulkanDriver", "Failed to load %s: %s", module.c_str(), dlerror());
                }
            }
            
            if (!libvulkan) {}
        }
        
        /** 
         * Driver injection
         */
        void replaceDriver(
            const std::string &path // Custom Driver dir
            , const char *hooksDir // Native Lib Dir 
            , const char *driverName // Name of Custom Driver
        )
        
        /** 
         * Populate dispatch table
         */
        void handle(void *libvulkan) {
            pCreateInstance = get_instance_proc_addr<PFN_vkCreateInstance>("vkCreateInstance");
        }
        
        template <typename T>
        T get_instance_proc_addr(const char *name) {
            T func = reinterpret_cast<T>(dlsym( libvulkan, name));
            if (func == nullptr) {
                // not found handle some error
            }
            
            return func;
        }
        
        /** 
         * destructor
         */
        ~driver_module_t() {
            if (libvulkan) {
                dlclose(libvulkan);
            }
        }
        
    } driver_module_t;
}    
