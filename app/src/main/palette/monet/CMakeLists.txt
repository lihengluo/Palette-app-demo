cmake_minimum_required(VERSION 3.16)

project(monet)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "-Werror")
set(CMAKE_EXPORT_COMPILE_COMMANDS ON)
set(EXECUTABLE_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/bin)
set(LIBRARY_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/lib)

#找到目录下所有.cc文件，放到SOURCES变量中
file(GLOB_RECURSE SOURCES "*.cc")
#file(GLOB_RECURSE HEADERS "*.h")

#添加头文件目录
include_directories(include)

#添加库
add_library(${PROJECT_NAME}  SHARED ${SOURCES})
