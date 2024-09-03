#pragma once

#include <jni.h>
#include <android/native_window_jni.h>
#include <vulkan/vulkan.h>
#include <vulkan/vulkan_android.h>
#include <android/hardware_buffer.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <unistd.h>
#include <cstring>
#include <iostream>

class ExternalMemoryAndroid {
    public:
    
    struct image_ahb_t {
        int sock_fd = -1;
        AHardwareBuffer* ahb = nullptr;
        AHardwareBuffer_Desc description = {};
        
        bool allocateBuffer() {
            int retval = AHardwareBuffer_allocate(&description, &ahb);
            return retval != 0 ? false : true;
        }
        
        void releaseBuffer() {
            AHardwareBuffer_release(ahb);
        }
    };
    
    bool send_buffer(AHardwareBuffer* ahb, int sock_fd) {
        int retval = AHardwareBuffer_sendHandleToUnixSocket(ahb, sock_fd);
        return retval != 0 ? false : true;
    }
    
    static bool receive_buffer(AHardwareBuffer_Desc* out_description, AHardwareBuffer** out_ahb, int sock_fd) {
        AHardwareBuffer* recv_ahb = nullptr;
        AHardwareBuffer_Desc recv_desc = {};
        
        
        int retval = AHardwareBuffer_recvHandleFromUnixSocket(sock_fd, &recv_ahb);
        
        
        AHardwareBuffer_describe(recv_ahb, &recv_desc);
        
        if (retval != 0 || recv_ahb == nullptr) {
            throw std::runtime_error("Failed to recv ahb`s android.");
        }
        
        *out_ahb = recv_ahb;
        *out_description = recv_desc;
        
        return retval != 0 || recv_ahb == nullptr ? false : true;
    }
};

class VulkanCompositor {
public:
    VkInstance _instance;
	VkDevice _device;
    VkSurfaceKHR _surface;
    
	bool _isInitialized{ false };
	int _frameNumber {0};
	bool stop_rendering{ false };
    
	struct ANativeWindow *window;
    
	static VulkanCompositor& Get();
    
	void init(JNIEnv *env, jobject surface);

	void cleanup();

	void draw();

	void run();
    
    void stopRendering() {
        stop_rendering = true;
    }
    
    VkSurfaceKHR createVulkanAndroidSurface(ANativeWindow* window) {
        
        VkAndroidSurfaceCreateInfoKHR surfaceCreateInfo = {};
        surfaceCreateInfo.sType = VK_STRUCTURE_TYPE_ANDROID_SURFACE_CREATE_INFO_KHR;
        surfaceCreateInfo.window = window;

        if (vkCreateAndroidSurfaceKHR(_instance, &surfaceCreateInfo, nullptr, &_surface) != VK_SUCCESS) {
            throw std::runtime_error("Failed to create Vulkan Android Surface.");
        }

        return _surface;
    }
    
    static int createSocket(std::string sock_path = "/tmp/socket") {
        int sock_fd = socket(AF_UNIX, SOCK_STREAM, 0);
        if (sock_fd < 0) { return -1; }

        struct sockaddr_un addr;
        std::memset(&addr, 0, sizeof(addr));
        addr.sun_family = AF_UNIX;
        std::strncpy(addr.sun_path, sock_path.c_str(), sizeof(addr.sun_path) - 1);

        unlink(sock_path.c_str());

        if (bind(sock_fd, (struct sockaddr*)&addr, sizeof(addr)) < 0) {
            close(sock_fd);
            return -1;
        }
        
        if (listen(sock_fd, 5) < 0) {
            close(sock_fd);
            return -1;
        }
        
        return sock_fd;
    }
    
    void closeSocket(int sock_fd, std::string sock_path = "/tmp/socket") {
        if (sock_fd >= 0) {
            close(sock_fd);
            unlink(sock_path.c_str());  // Remove the socket file from the filesystem
        }
    }
};