package com.github.paniov.biread.app

import scala.util.matching.Regex

object AppRoutes {
  val homeRoute: Regex = "^/read$".r
  val howtoRoute: Regex = "^/learn$".r
  val contactsRoute: Regex = "^/info$".r
}