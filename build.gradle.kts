plugins {
  kotlin("multiplatform") version "1.5.31" apply true
  id("io.kotest.multiplatform") version "5.0.0.5" apply true
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
  macosX64()
  macosArm64()
  tvos()
  tvosSimulatorArm64()
  watchosArm32()
  watchosX86()
  watchosX64()
  watchosSimulatorArm64()
  iosX64()
  iosArm64()
  iosArm32()
  iosSimulatorArm64()

  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation("io.github.nomisrev:saga:0.0.1000")
      }
    }
    commonTest {
      dependencies {
        implementation("io.kotest:kotest-property:5.0.0.M1")
        implementation("io.kotest:kotest-framework-engine:5.0.0.M1")
        implementation("io.kotest:kotest-assertions-core:5.0.0.M1")
      }
    }
  }
}
