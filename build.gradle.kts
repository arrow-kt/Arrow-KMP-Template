plugins {
  kotlin("multiplatform") version "1.6.10" apply true
  id("io.kotest.multiplatform") version "5.1.0" apply true
}

group "org.example"
version "1.0"

repositories {
  mavenCentral()
}

kotlin {
  jvm()

  js(IR) {
    browser()
    nodejs()
  }

  linuxX64()

  mingwX64()

  iosArm32()
  iosArm64()
  iosSimulatorArm64()
  // iosX64()
  macosArm64()
  // macosX64()
  tvosArm64()
  tvosSimulatorArm64()
  tvosX64()
  watchosArm32()
  watchosArm64()
  watchosSimulatorArm64()
  watchosX64()
  watchosX86()

  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation("io.arrow-kt:arrow-core:1.0.1")
        implementation("io.arrow-kt:arrow-optics:1.0.1")
        implementation("io.arrow-kt:arrow-fx-coroutines:1.0.1")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
      }
    }
    commonTest {
      dependencies {
        implementation("io.kotest:kotest-property:5.1.0")
        implementation("io.kotest:kotest-framework-engine:5.1.0")
        implementation("io.kotest:kotest-assertions-core:5.1.0")
        implementation("io.kotest.extensions:kotest-assertions-arrow:1.2.2")
      }
    }
  }
}
