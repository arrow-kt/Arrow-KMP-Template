import io.github.nomisrev.PublishTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExampleSpec : StringSpec({
  "true shouldBe true" {
    PublishTest.helloWorld() shouldBe "HelloWorld!"
  }
})