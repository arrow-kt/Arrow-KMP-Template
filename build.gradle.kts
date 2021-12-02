plugins {
  kotlin("multiplatform") version "1.6.0" apply true
}

group "org.example"
version "1.0"

repositories {
  mavenCentral()
  maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

buildscript {
  repositories {
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
  }
  dependencies {
    classpath("io.arrow-kt.optics:io.arrow-kt.optics.gradle.plugin:2.0-SNAPSHOT")
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
      }
    }
  }
}
