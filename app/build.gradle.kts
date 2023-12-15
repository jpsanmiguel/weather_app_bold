import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Build.androidApplicationName)
    id(Build.kotlinJetbrainsName)
    id(Build.ksp)
    id(Dagger.hiltPlugin)
    id(AndroidX.safeArgsPlugin)
}

android {
    namespace = ProjectConfig.applicationId
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val key = gradleLocalProperties(rootDir).getProperty("API_KEY") ?: ""
        buildConfigField("String", "API_KEY","\"$key\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(AndroidX.splashscreen)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.legacySupport)
    implementation(AndroidX.lifecycleLiveData)
    implementation(AndroidX.lifecycleViewModel)
    implementation(AndroidX.navigationFragment)
    implementation(AndroidX.navigationUi)
    implementation(Dagger.hiltAndroid)
    implementation(Glide.glide)
    ksp(Dagger.hiltCompiler)
    implementation(Google.material)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.retrofitGsonConverter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)

    testImplementation(Testing.mockWebServer)
    testImplementation(Testing.truth)
    testImplementation(Testing.junit)
    androidTestImplementation(Testing.mockWebServer)
    androidTestImplementation(Testing.truth)
    androidTestImplementation(Testing.junitAndroidExtension)
    androidTestImplementation(Testing.espresso)
}