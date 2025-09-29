plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.elizabeth.contenidoeducativo.android"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.elizabeth.contenidoeducativo.android"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    //Testing dependencies
    androidTestImplementation (libs.androidx.compose.ui.ui.test.junit4)
    debugImplementation (libs.androidx.ui.test.manifest)
    //AndroidJUnitRunner and JUnit Rules
    androidTestImplementation (libs.androidx.runner.v170)
    androidTestImplementation (libs.androidx.rules.v170)
    //Assertions
    androidTestImplementation (libs.androidx.junit)
    // Optional -- UI testing with UI Automator
    androidTestImplementation (libs.androidx.uiautomator)
    // Optional -- UI testing with Espresso
    androidTestImplementation (libs.androidx.espresso.core)

}

