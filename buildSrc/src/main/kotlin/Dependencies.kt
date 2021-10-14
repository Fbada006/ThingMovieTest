object Versions {

    //Version codes for all the libraries
    const val kotlin = "1.5.21"
    const val appCompat = "1.4.0-alpha03"
    const val constraintLayout = "2.1.0"
    const val ktx = "1.7.0-alpha01"
    const val material = "1.5.0-alpha02"

    // Retrofit
    const val retrofit = "2.9.0"
    const val okhttp3loggingInterceptor = "4.8.1"

    // Paging
    const val paging3Library = "3.1.0-beta01"

    //ViewModel and LifeCycle
    const val viewmodelLifecycle = "2.2.0"

    //Coroutines
    const val coroutines = "1.3.9"

    //Room
    const val room = "2.3.0"

    // Hilt
    const val daggerHilt = "2.38.1"

    // Timber
    const val timber = "5.0.1"

    //Version codes for all the test libraries
    const val junit4 = "4.13.2"
    const val testRunner = "1.4.0"
    const val espresso = "3.4.0"
    const val annotation = "1.3.0-alpha01"

    // Gradle Plugins
    const val ktlint = "10.1.0"
    const val detekt = "1.18.0"
    const val spotless = "5.14.2"
    const val dokka = "1.5.0"
    const val gradleVersionsPlugin = "0.39.0"
    const val jacoco = "0.8.7"
}

object BuildPlugins {
    //All the build plugins are added here
    const val androidLibrary = "com.android.library"
    const val ktlintPlugin = "org.jlleitschuh.gradle.ktlint"
    const val detektPlugin = "io.gitlab.arturbosch.detekt"
    const val spotlessPlugin = "com.diffplug.spotless"
    const val dokkaPlugin = "org.jetbrains.dokka"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinParcelizePlugin = "org.jetbrains.kotlin.plugin.parcelize"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val jacocoAndroid = "com.hiya.jacoco-android"
    const val kapt = "kotlin-kapt"
    const val daggerHilt = "dagger.hilt.android.plugin"
}

object Libraries {
    //Any Library is added here
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
    const val retrofit = "com.squareup.retrofit2:retrofit${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3loggingInterceptor}"
    const val paging3ktx = "androidx.paging:paging-runtime-ktx:${Versions.paging3Library}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewmodelLifecycle}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelLifecycle}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewmodelLifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.viewmodelLifecycle}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object TestLibraries {
    //any test library is added here
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
}


object AndroidSdk {
    const val minSdkVersion = 21
    const val compileSdkVersion = 30
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
}