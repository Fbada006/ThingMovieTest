plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
    id(BuildPlugins.kotlinParcelizePlugin)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.jacocoAndroid)
    id(BuildPlugins.daggerHilt)
    id(BuildPlugins.safeArgs)
}

jacoco {
    toolVersion = Versions.jacoco
}

android {

    compileSdk = AndroidSdk.compileSdkVersion
    android.buildFeatures.dataBinding = true
    android.buildFeatures.viewBinding = true

    defaultConfig {
        applicationId = "com.thingthing.thatthing"
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dependencies {
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        implementation(Libraries.kotlinStandardLibrary)
        implementation(Libraries.appCompat)
        implementation(Libraries.ktxCore)
        implementation(Libraries.constraintLayout)
        implementation(Libraries.materialComponents)
        implementation(Libraries.activityKtx)
        implementation(Libraries.fragmentKtx)

        // Retrofit
        implementation(Libraries.retrofit)
        implementation(Libraries.retrofitGsonConverter)
        implementation(Libraries.okhttp3)
        implementation(Libraries.retrofitCoroutineAdapter)

        // Viewmodel and lifecycle
        implementation(Libraries.lifecycleExtensions)
        implementation(Libraries.lifecycleLiveDataKtx)
        implementation(Libraries.lifecycleRuntimeKtx)
        implementation(Libraries.lifecycleViewModelKtx)

        // Coroutines
        implementation(Libraries.coroutinesAndroid)
        implementation(Libraries.coroutinesCore)

        // Room
        implementation(Libraries.roomKtx)
        implementation(Libraries.roomRuntime)
        kapt(Libraries.roomCompiler)

        // Paging 3 lib
        implementation(Libraries.paging3ktx)

        // Timber
        implementation(Libraries.timber)

        // Hilt
        implementation(Libraries.daggerHilt)
        kapt(Libraries.daggerHiltCompiler)

        //Navigation
        implementation(Libraries.navigationFragment)
        kapt(Libraries.navigationKtx)

        androidTestImplementation(TestLibraries.testRunner)
        androidTestImplementation(TestLibraries.espresso)
        androidTestImplementation(TestLibraries.annotation)

        testImplementation(TestLibraries.junit4)
    }
}
kapt {
    correctErrorTypes = true
}