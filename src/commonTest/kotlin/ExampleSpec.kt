import arrow.core.Either
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExampleSpec : StringSpec({
  "true shouldBe true" {
    true shouldBe true
  }

  "exception should fail" {
//    throw RuntimeException("Boom2!")
  }

  "smart cast Either.Right with kotest" {
    Either.Right("HI").shouldBeRight()
  }
})
