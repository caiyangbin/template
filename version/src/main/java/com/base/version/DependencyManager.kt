package com.base.version


object BuildVersion {
    const val compileSdkVersion = 32
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.egreat.music"
}

object AndroidX {

    private const val coreKtxVersion = "1.7.0"
    private const val appcompatVersion = "1.5.1"
    private const val materialVersion = "1.6.1"
    private const val constraintlayoutVersion = "2.1.4"
    private const val viewModelVersion = "2.4.0"
    private const val roomVersion = "2.4.0"
    private const val navigationVersion = "2.3.5"
    private const val activityKtxVersion = "1.5.1"
    private const val fragmentVersion = "1.5.4"
    private const val hiltVersion = "2.44"
    private const val lifeCycleServiceVersion = "2.4.1"

    // core
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
    const val material = "com.google.android.material:material:$materialVersion"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"
    const val lifeCycleService = "androidx.lifecycle:lifecycle-service:$lifeCycleServiceVersion"

    // viewModel
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$viewModelVersion"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$viewModelVersion"

    // room
    const val room = "androidx.room:room-runtime:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"

    // navigation
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$navigationVersion"

    // di
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"

    // ktx
    const val activityKtx = "androidx.activity:activity-ktx:$activityKtxVersion"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentVersion"

    // 分包
    const val multidex = "androidx.multidex:multidex:2.0.1"
}

object Testing {

    private const val junitVersion = "4.13.2"
    private const val extJunitVersion = "1.1.3"
    private const val espressoCoreVersion = "3.4.0"

    const val junit = "junit:junit:$junitVersion"
    const val extJunit = "androidx.test.ext:junit:$extJunitVersion"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVersion"

}

object ThirdDependency {

    private const val glideVersion = "4.14.2"
    private const val retrofitVersion = "2.9.0"
    private const val rxjava3Version = "3.0.0"


    // 爱奇艺应用崩溃日志统计
    const val xcrash = "com.iqiyi.xcrash:xcrash-android-lib:3.0.0"

    // 图片加载
    const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
    const val glideOkhttp3Integration = "com.github.bumptech.glide:okhttp3-integration:$glideVersion"

    // 网络请求
    const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.1"
    const val gson = "com.google.code.gson:gson:2.8.9"

    // 组件通信
    const val liveEventBus = "io.github.jeremyliao:live-event-bus-x:1.8.0"

    // rx
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:$rxjava3Version"
    const val rxJava = "io.reactivex.rxjava3:rxjava:$rxjava3Version"

    //圆角ImageView
    const val roundedImageView = "com.makeramen:roundedimageview:2.3.0"

    // qrcode
    const val zxingLite = "com.github.jenly1314:zxing-lite:2.2.1"

    // permission
    const val permission = "com.yanzhenjie:permission:2.0.3"

}
