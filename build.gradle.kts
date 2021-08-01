plugins {
    kotlin("multiplatform") version "1.5.21"
}

group "org.example"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

kotlin {
    /* Targets configuration omitted.
     *  To find out how to configure the targets, please follow the link:
     *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets
     */

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("io.arrow-kt:arrow-core:1.0.0-SNAPSHOT")
                implementation("io.arrow-kt:arrow-optics:1.0.0-SNAPSHOT")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
                implementation("io.arrow-kt:arrow-fx-coroutines:1.0.0-SNAPSHOT")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}