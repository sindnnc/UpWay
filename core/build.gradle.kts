plugins {
    id(IdPlugin.android)
    id(IdPlugin.library)
    id(IdPlugin.serialization)
    kotlin(IdPlugin.kapt)
    id(IdPlugin.hilt)
}

android {
    compileSdk = Config.targetSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
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
}

kapt {
    correctErrorTypes = true
}


dependencies {

    //STORAGE
    implementation(Dependencies.dataStore)
    implementation(Dependencies.encryptedPreference)


    //CORE
    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.googleMaterial)

    //HILT
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltAndroid)

    //JETBRAINS
    implementation(Dependencies.jetBrainsKotlin)

    //KTOR
    implementation(Dependencies.ktorCio)
    implementation(Dependencies.ktorCore)
    implementation(Dependencies.ktorSerialization)
    implementation(Dependencies.jetBrainSerialization)

    //TEST
    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.espresso)


}
