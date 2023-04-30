cmake_minimum_required(VERSION 3.16)
project("palette")

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "-Werror")
set(CMAKE_EXPORT_COMPILE_COMMANDS ON)
#设置输出路径
set(EXECUTABLE_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/bin)
set(LIBRARY_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/lib)

#添加头文件目录
include_directories("${PROJECT_SOURCE_DIR}/monet")
#添加子目录（含有CMakeLists.txt）
add_subdirectory(monet)
#添加库
add_library(${PROJECT_NAME} SHARED palette.cpp )
#添加链接库
#find_library(log-lib log)

target_link_libraries(${PROJECT_NAME} monet )
#输出信息


