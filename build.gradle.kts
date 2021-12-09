plugins {
  id("com.google.devtools.ksp") version "1.6.0-1.0.1"
  kotlin("multiplatform") version "1.6.0" apply true
}

group "org.example"
version "1.0"

repositories {
  mavenLocal()
  gradlePluginPortal()
  mavenCentral()
  maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
  commonMainImplementation("io.arrow-kt:arrow-optics:1.0.1")
  commonTestImplementation("io.arrow-kt:arrow-optics:1.0.1")
  ksp("io.arrow-kt:arrow-optics-ksp:2.0-SNAPSHOT")
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
      }
    }
  }
}
