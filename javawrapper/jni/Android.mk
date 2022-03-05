LOCAL_PATH := $(call my-dir)

#LOCAL_CFLAGS += -pie -fPIE
#LOCAL_LDFLAGS += -pie -fPIE

include $(CLEAR_VARS)

LOCAL_MODULE    := hello_jni
LOCAL_SRC_FILES := nativelib.cpp

# LOCAL_STATIC_LIBRARIES := libgetifaddr
LOCAL_LDLIBS    := -llog

APP_ALLOW_MISSING_DEPS=true

include $(BUILD_SHARED_LIBRARY)
