@file:Suppress("UnstableApiUsage")

import com.base.version.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.base.version")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.egreat.template"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.egreat.template"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        ndk {
//            abiFilters.add("armeabi-v7a")
//            abiFilters.add("arm64-v8a")
//        }

        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    // base
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.material)
    implementation(AndroidX.constraintlayout)
    implementation(AndroidX.lifecycleRuntimeKtx)
    implementation(AndroidX.viewModelKtx)
    implementation(AndroidX.activityKtx)
    implementation(AndroidX.fragmentKtx)
    implementation(AndroidX.hilt)
    implementation(AndroidX.lifeCycleService)
    implementation(AndroidX.multidex)
    kapt(AndroidX.hiltCompiler)
    implementation(project(":baselibrary"))


    // test
    testImplementation(Testing.junit)
    androidTestImplementation(Testing.extJunit)
    androidTestImplementation(Testing.espressoCore)

}