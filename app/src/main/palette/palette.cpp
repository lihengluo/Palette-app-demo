#include "jni.h"
#include <string>
#include "monet/include//blend/blend.cc"
#include "monet/include/cam/hct.cc"
#include "monet/include/cam/hct.h"
#include "monet/include/utils/utils.h"

using namespace std;
using namespace material_color_utilities;

extern "C" JNIEXPORT jstring  JNICALL
Java_com_example_composetuturial_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jfloat JNICALL
Java_com_example_composetuturial_MainActivity_Red2HCT(
        JNIEnv* env,jobject jobj, jfloat hue, jfloat chroma, jfloat tone) {
    Argb argb = Hct(hue,chroma, tone).ToInt();
    int red = RedFromInt(argb);
    int green = GreenFromInt(argb);
    int blue = BlueFromInt(argb);
    return red;
}

extern "C" JNIEXPORT jfloat JNICALL
Java_com_example_composetuturial_MainActivity_Green2HCT(
        JNIEnv* env,jobject jobj, jfloat hue, jfloat chroma, jfloat tone) {
    Argb argb = Hct(hue,chroma, tone).ToInt();
    int red = RedFromInt(argb);
    int green = GreenFromInt(argb);
    int blue = BlueFromInt(argb);
    return green;
}

extern "C" JNIEXPORT jfloat JNICALL
Java_com_example_composetuturial_MainActivity_Blue2HCT(
        JNIEnv* env,jobject jobj, jfloat hue, jfloat chroma, jfloat tone) {
    Argb argb = Hct(hue,chroma, tone).ToInt();
    int red = RedFromInt(argb);
    int green = GreenFromInt(argb);
    int blue = BlueFromInt(argb);
    return blue;
}