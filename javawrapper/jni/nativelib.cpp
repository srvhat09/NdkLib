#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_javawrapper_nativecall_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    char hello[20] = "Hello from C++";
    return env->NewStringUTF(hello);
}