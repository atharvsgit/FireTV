plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.firetv"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.firetv"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core Android & Compose dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3) // Using the mobile material3 is fine for some basic components

    // CRUCIAL TV LIBRARIES
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)

    // Image Loading Library
    implementation(libs.coil.compose)

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.androidx.recyclerview)
    implementation("io.coil-kt:coil:2.6.0")
// ↓↓↓ ADD THIS LINE IF IT'S MISSING ↓↓↓
    implementation(libs.androidx.appcompat)
    implementation("androidx.leanback:leanback:1.0.0")

    // Standard Testing Libraries
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


}