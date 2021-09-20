plugins {
  kotlin("multiplatform") version "1.5.30" apply true
  id("io.kotest.multiplatform") version "5.0.0.5" apply true
  id("org.jlleitschuh.gradle.ktlint") version "10.2.0" apply true
}

group = groupId
version = versionName

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

  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation(Arrow.core)
        implementation(Arrow.fxCoroutines)
        implementation(Arrow.optics)
        implementation(KotlinX.coroutinesCore)
      }
    }
    commonTest {
      dependencies {
        implementation(Kotest.property)
        implementation(Kotest.frameworkEngine)
        implementation(Kotest.assertionsCore)
      }
    }
  }
}
