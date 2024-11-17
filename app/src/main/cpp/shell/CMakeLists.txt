cmake_minimum_required(VERSION 3.10.2)

project(SHELL LANGUAGES CXX)

add_library(shell SHARED
            shell.c
            )

target_link_libraries(shell
    PRIVATE
    log
    android
    vulkan
)
