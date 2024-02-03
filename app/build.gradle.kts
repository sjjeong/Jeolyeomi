import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.dino.jeolyeomi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dino.jeolyeomi"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "KAKAO_API_KEY", gradleLocalProperties(rootDir).getProperty("KAKAO_API_KEY"))
        addManifestPlaceholders(
            mapOf(
                "KAKAO_REDIRECT_URI" to gradleLocalProperties(rootDir).getProperty("KAKAO_REDIRECT_URI")
            )
        )
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:signin"))
    implementation(project(":feature:splash"))
    implementation(project(":feature:main"))
    implementation(project(":feature:home"))
    implementation(project(":feature:history"))
    implementation(project(":feature:profile"))
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.kakao.sdk:v2-common:2.19.0")
    implementation("com.kakao.sdk:v2-auth:2.19.0")
    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")
}

kapt {
    correctErrorTypes = true
}