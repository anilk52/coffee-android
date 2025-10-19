plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.coffee"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coffee"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
}
