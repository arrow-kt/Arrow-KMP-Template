plugins {
  kotlin("multiplatform") version "1.7.21" apply true
  id("io.kotest.multiplatform") version "5.5.4" apply true
}

group "org.example"
version "1.0"

repositories {
  mavenCentral()
  maven {
    url = uri("https://oss.sonatype.org/content/repositories/snapshots")
  }
  // for kotest snapshots
  maven {
    url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
  }
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
  iosX64()
  macosArm64()
  macosX64()
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
        implementation("io.arrow-kt:arrow-core:1.1.3")
        implementation("io.arrow-kt:arrow-optics:1.1.3")
        implementation("io.arrow-kt:arrow-fx-coroutines:1.1.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
      }
    }

    commonTest {
      dependencies {
        implementation("io.kotest:kotest-property:5.5.4")
        implementation("io.kotest:kotest-framework-engine:5.5.4")
        implementation("io.kotest:kotest-assertions-core:5.5.4")
        implementation("io.kotest.extensions:kotest-assertions-arrow:1.2.0.157-SNAPSHOT")
        implementation("io.kotest.extensions:kotest-property-arrow:1.2.0.157-SNAPSHOT") // optional
        implementation("io.kotest.extensions:kotest-property-arrow-optics:1.2.0.157-SNAPSHOT") // optional
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
      }
    }
  }
}

tasks.withType<Test>() {
  useJUnitPlatform()
}
