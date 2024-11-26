plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.appdynamics)
}

android {
    compileSdk = 35

    namespace = "com.test.appd.withbuildconf"

    defaultConfig {
        applicationId = "com.test.appd.withbuildconf"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.2.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

adeum {
    // disable appdynamics if we build locally
    disabledForBuildTypes = listOf("debug")
    //Excludes all the classes in the android.support.multidex and okio packages.
    excludeClasses = listOf("android.support.multidex.*", "okio.**")
}
dependencies {

    implementation(libs.appDynamics.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.okhttp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":feature1"))
}