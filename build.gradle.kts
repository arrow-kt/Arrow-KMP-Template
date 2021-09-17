plugins {
  kotlin("multiplatform") version "1.5.30"
}

group "org.example"
version "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

configurations.all { resolutionStrategy.cacheChangingModulesFor(0, "seconds") }

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    useIR = true
  }
}

kotlin {
//    jvm()

//  js(IR) {
//    browser()
//    nodejs()
//  }

  macosX64()
  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-common"))
        // Should be able to resolve to io.arrow-kt:arrow-core-macosx641.0.0-SNAPSHOT
        // with all its transitive dependencies
        implementation("io.arrow-kt:arrow-core:1.0.0-SNAPSHOT")
      }
    }
    commonTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(kotlin("test-annotations-common"))
      }
    }
    named("macosX64Main") {
      dependencies {
//  Manually defining all transitive dependencies works, but is incorrect
//  The POM should know which are the correct transitive dependencies.

//        implementation("io.arrow-kt:arrow-continuations-macosx64:1.0.0-SNAPSHOT")
//        implementation("io.arrow-kt:arrow-annotations-macosx64:1.0.0-SNAPSHOT")

        // If we manually define target dependency here, then it can find this one
        // But still not the transitive ones
//        implementation("io.arrow-kt:arrow-core-macosx64:1.0.0-SNAPSHOT")
      }
    }
//        jvmTest {
//            dependencies {
//                implementation(kotlin("test-junit"))
//            }
//        }
  }
}