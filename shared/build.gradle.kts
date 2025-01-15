import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.buildConfig)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            api(libs.koin.android)
            implementation(libs.ktor.android)
            api(libs.androidx.datastore.preferences)
        }

        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.core)
            implementation(libs.ktor.content.negotiation)
            api(libs.ktor.serialization.json)
            api(libs.koin.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.androidx.datastore.preferences.core)
        }

        iosMain.dependencies {
            implementation(libs.ktor.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "uz.otamurod.socialmediakmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

private fun getProperties(fileName: String): Properties {
    val properties = Properties()
    file(fileName).inputStream().use { input ->
        properties.load(input)
    }
    return properties
}

// Load the properties
private val configProperties = getProperties("../keystore.properties")

buildConfig {
    packageName("uz.otamurod.socialmediakmp")

    buildConfigField("string", "BASE_URL", "\"${configProperties["BASE_URL"]}\"")
}