import arrow.optics.plugin.arrowOpticsCommon

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.arrow.optics)
}

group = "org.example"
version = "1.0"

repositories {
  mavenCentral()
}

kotlin {
  jvm()

  js {
    browser()
    nodejs()
  }

  linuxX64()
  mingwX64()
  iosArm64()
  iosSimulatorArm64()
  iosX64()
  macosArm64()
  macosX64()

  applyDefaultHierarchyTemplate()

  sourceSets {
    commonMain {
      dependencies {
        implementation(libs.coroutines.core)
        implementation(libs.arrow.core)
        implementation(libs.arrow.fxCoroutines)
        implementation(libs.arrow.resilience)
        implementation(libs.arrow.optics)
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.bundles.testing)
      }
    }

    val jvmMain by getting
  }

  arrowOpticsCommon()
}
