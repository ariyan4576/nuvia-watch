import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

// Secrets are never committed. They come from GitHub Secrets (CI)
// or from local.properties (local builds). Missing values become "".
val localProps = Properties().apply {
    val f = rootProject.file("local.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}

fun config(name: String): String =
    providers.environmentVariable(name).orNull ?: localProps.getProperty(name) ?: ""

android {
    namespace = "com.nuvia.watch"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.nuvia.watch"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"

        buildConfigField("String", "SUPABASE_URL", "\"${config("SUPABASE_URL")}\"")
        buildConfigField("String", "SUPABASE_ANON_KEY", "\"${config("SUPABASE_ANON_KEY")}\"")
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    buildTypes {
        debug {
            versionNameSuffix = "-debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    lint {
        // Reports are still generated. We will make this strict once the app is stable.
        abortOnError = false
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.wear.compose.foundation)
    implementation(libs.wear.compose.material3)

    debugImplementation(libs.wear.compose.ui.tooling)

    testImplementation(libs.junit)
}
