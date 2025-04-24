package org.example

import arrow.core.right
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import io.kotest.property.Arb
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ExampleSpec {
  @Test
  fun `true shouldBe true`() {
    true shouldBe true
  }

  @Test
  fun `exception should fail`() {
    shouldThrow<RuntimeException> {
      throw RuntimeException("Boom2!")
    }
  }

  @Test
  fun `kotest generator`() = runTest {
    checkAll(Arb.string()) { s ->
      s.right().shouldBeRight().shouldBeTypeOf<String>()
    }
  }
}
