plugins {
    id(IdPlugin.android)
    id(IdPlugin.application)
    kotlin(IdPlugin.kapt)
    id(IdPlugin.hilt)
}
android {
    compileSdk = Config.targetSdk

    defaultConfig {
        applicationId = Config.appId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

kapt {
    correctErrorTypes = true
}


dependencies {
    //MODULES
    implementation(project(Modules.component))
    implementation(project(Modules.core))
    implementation(project(Modules.features))

    //HILT
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    //CORE
    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.googleMaterial)

    //KTOR
    implementation(Dependencies.ktorCio)
    implementation(Dependencies.ktorCore)
    implementation(Dependencies.ktorSerialization)
    implementation(Dependencies.jetBrainSerialization)

    //COMPOSE
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.compose)

    //TEST
    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.espresso)
    androidTestImplementation(AndroidTestDependencies.compose)
    debugImplementation(DebugDependencies.compose)
}
