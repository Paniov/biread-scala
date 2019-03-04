package com.github.paniov.biread.test

import scala.language.postfixOps
import org.scalatest._

abstract class UnitSpec extends FlatSpec with Matchers with
  OptionValues with Inside with Inspectors
