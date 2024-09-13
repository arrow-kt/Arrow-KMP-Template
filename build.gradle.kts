plugins {
  kotlin("multiplatform") version "1.9.25" apply true
  id("io.kotest.multiplatform") version "5.9.1" apply true
  id("com.google.devtools.ksp") version "1.9.25-1.0.20"
}

group "org.example"
version "1.0"

repositories {
  mavenCentral()
  maven {
    url = uri("https://oss.sonatype.org/content/repositories/snapshots")
  }
}

// release candidate avoids a null pointer exception during optics generation
val arrowVersion = "1.2.4"
dependencies {
  add("kspCommonMainMetadata", "io.arrow-kt:arrow-optics-ksp-plugin:$arrowVersion")
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
        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        implementation(kotlin("stdlib-common"))
        implementation("io.arrow-kt:arrow-core:$arrowVersion")
        implementation("io.arrow-kt:arrow-optics:$arrowVersion")
        implementation("io.arrow-kt:arrow-fx-coroutines:$arrowVersion")
        implementation("io.arrow-kt:arrow-optics:$arrowVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
      }
    }

    val kotestVersion = "5.9.1"
    val kotestArrowVersion = "1.4.0"
    commonTest {
      dependencies {
        implementation("io.kotest:kotest-property:$kotestVersion")
        implementation("io.kotest:kotest-framework-engine:$kotestVersion")
        implementation("io.kotest:kotest-assertions-core:$kotestVersion")
        implementation("io.kotest.extensions:kotest-assertions-arrow:$kotestArrowVersion")
        implementation("io.kotest.extensions:kotest-property-arrow:$kotestArrowVersion") // optional
        implementation("io.kotest.extensions:kotest-property-arrow-optics:$kotestArrowVersion") // optional
      }
    }

    val jvmTest by getting {
      dependencies {
        implementation("io.kotest:kotest-runner-junit5-jvm:5.9.1")
      }
    }

    val jvmMain by getting
  }
}
