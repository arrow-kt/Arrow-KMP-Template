@file:Suppress("RedundantSuspendModifier")

import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import arrow.core.raise.either
import arrow.optics.optics

object Lettuce
object Knife
object Salad

@optics
data class Ingredient(val name: String) {
  companion object
}

@optics
sealed class CookingException {
  data object LettuceIsRotten : CookingException()
  data object KnifeNeedsSharpening : CookingException()
  data class InsufficientAmount(val quantityInGrams: Int) : CookingException()

  companion object
}

typealias NastyLettuce = CookingException.LettuceIsRotten
typealias KnifeIsDull = CookingException.KnifeNeedsSharpening
typealias InsufficientAmountOfLettuce = CookingException.InsufficientAmount

fun takeFoodFromRefrigerator(): Either<NastyLettuce, Lettuce> =
  Right(Lettuce)

suspend fun getKnife(): Either<KnifeIsDull, Knife> =
  Right(Knife)

fun prepare(tool: Knife, ingredient: Lettuce): Either<InsufficientAmountOfLettuce, Salad> =
  Left(InsufficientAmountOfLettuce(5))

suspend fun prepareLunch(): Either<CookingException, Salad> =
  either {
    val lettuce = takeFoodFromRefrigerator().bind()
    val knife = getKnife().bind()
    val lunch = prepare(knife, lettuce).bind()
    lunch
  }
