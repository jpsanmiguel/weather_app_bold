import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Build.androidApplicationName)
    id(Build.kotlinJetbrainsName)
    id(Build.ksp)
    id(Dagger.hiltPlugin)
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
    implementation(AndroidX.navigationFragment)
    implementation(AndroidX.navigationUi)
    implementation(Dagger.hiltAndroid)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    ksp(Dagger.hiltCompiler)
    implementation(Google.material)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.retrofitGsonConverter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)
    testImplementation(Testing.junit)
    androidTestImplementation(Testing.junitAndroidExtension)
    androidTestImplementation(Testing.espresso)
}