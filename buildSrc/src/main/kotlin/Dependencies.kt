object Arrow {
  val fxCoroutines: String = arrow("fx-coroutines")
  val optics: String = arrow("optics")
  val core: String = arrow("core")
}

fun arrow(simpleModuleName: String, version: String = "1.0.0"): String =
  "io.arrow-kt:arrow-$simpleModuleName:$version"

object KotlinX {
 val coroutinesCore: String = kotlinX("coroutines-core")
}

fun kotlinX(simpleModuleName: String, version: String = "1.5.2"): String =
  "org.jetbrains.kotlinx:kotlinx-$simpleModuleName:$version"

object Kotest {
  val property: String = kotest("property")
  val frameworkEngine: String = kotest("framework-engine")
  val assertionsCore: String = kotest("assertions-core")
}

fun kotest(simpleModuleName: String, version: String = "5.0.0.M1"): String =
  "io.kotest:kotest-$simpleModuleName:$version"
