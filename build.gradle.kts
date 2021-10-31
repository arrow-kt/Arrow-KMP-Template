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

  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation("io.arrow-kt:arrow-core:1.0.0")
        implementation("io.arrow-kt:arrow-optics:1.0.1")
        implementation("io.arrow-kt:arrow-fx-coroutines:1.0.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
      }
    }
    commonTest {
      dependencies {
        implementation("io.kotest:kotest-property:5.0.0.M2")
        implementation("io.kotest:kotest-framework-engine:5.0.0.M1")
        implementation("io.kotest:kotest-assertions-core:5.0.0.M3")
      }
    }
  }
}
