plugins {
  kotlin("multiplatform") version "1.6.0" apply true
  id("io.kotest.multiplatform") version "5.0.0.6" apply true
}

group "org.example"
version "1.0"

repositories {
  mavenCentral()
  maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

buildscript {
  repositories {
    mavenLocal()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
  }
  dependencies {
    classpath("io.arrow-kt.optics:io.arrow-kt.optics.gradle.plugin:2.1-SNAPSHOT")
  }
}

apply(plugin = "io.arrow-kt.optics")

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
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-RC")
      }
    }
    commonTest {
      dependencies {
        implementation("io.kotest:kotest-property:5.0.0")
        implementation("io.kotest:kotest-framework-engine:5.0.0")
        implementation("io.kotest:kotest-assertions-core:5.0.0")
      }
    }
  }
}
