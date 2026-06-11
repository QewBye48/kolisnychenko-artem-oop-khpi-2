#include "ua_khpi_oop_lab16_NativeNormalizer.h"

JNIEXPORT jdoubleArray JNICALL
Java_ua_khpi_oop_lab16_NativeNormalizer_normalize(
        JNIEnv *env,
        jobject obj,
        jdoubleArray inputArray) {

    if (inputArray == nullptr) {
        return nullptr;
    }

    jsize length = env->GetArrayLength(inputArray);

    jdoubleArray resultArray = env->NewDoubleArray(length);

    if (length == 0) {
        return resultArray;
    }

    jdouble *values = env->GetDoubleArrayElements(inputArray, nullptr);

    double min = values[0];
    double max = values[0];

    for (int i = 0; i < length; i++) {
        if (values[i] < min) {
            min = values[i];
        }
        if (values[i] > max) {
            max = values[i];
        }
    }

    double *result = new double[length];

    if (max == min) {
        for (int i = 0; i < length; i++) {
            result[i] = 0.0;
        }
    } else {
        for (int i = 0; i < length; i++) {
            result[i] = (values[i] - min) / (max - min);
        }
    }

    env->SetDoubleArrayRegion(resultArray, 0, length, result);

    delete[] result;

    env->ReleaseDoubleArrayElements(inputArray, values, JNI_ABORT);

    return resultArray;
}