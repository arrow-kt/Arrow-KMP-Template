plugins {
  kotlin("multiplatform") version Versions.Plugin.kotlin apply true
  id("io.kotest.multiplatform") version Versions.Plugin.kotest apply true
  id("org.jlleitschuh.gradle.ktlint") version Versions.Plugin.ktlint apply true
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

  mingwX64()

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
