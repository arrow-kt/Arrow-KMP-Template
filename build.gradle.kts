import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.ksp)
}

group "org.example"
version "1.0"

repositories {
  mavenCentral()
}

kotlin {
  jvm()

  js {
    browser()
    nodejs()
  }

  linuxX64()
  mingwX64()
  iosArm64()
  iosSimulatorArm64()
  iosX64()
  macosArm64()
  macosX64()

  applyDefaultHierarchyTemplate()

  sourceSets {
    commonMain {
      dependencies {
        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        implementation(libs.coroutines.core)
        implementation(libs.arrow.core)
        implementation(libs.arrow.fxCoroutines)
        implementation(libs.arrow.resilience)
        implementation(libs.arrow.optics)
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.bundles.testing)
      }
    }

    val jvmMain by getting
  }
}

dependencies {
  add("kspCommonMainMetadata", libs.arrow.optics.ksp)
}

project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
  if(name != "kspCommonMainKotlinMetadata") {
    dependsOn("kspCommonMainKotlinMetadata")
  }
}
