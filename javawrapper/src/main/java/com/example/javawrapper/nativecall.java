package com.example.javawrapper;

public class nativecall {

    // Used to load the 'hello_cmake' library on application startup.
    static {
        System.loadLibrary("hello_jni");    // LOCAL_MODULE name in Android.mk
    }

    /**
     * A native method that is implemented by the native library in jni,
     * which is packaged with this library.
     */
    native String stringFromJNI();

    public String getdata() {
        return stringFromJNI();
    }
}
