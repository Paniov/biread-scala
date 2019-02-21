package com.github.paniov.biread.app

import scala.util.matching.Regex

object AppRoutes {
  val homeRoute: Regex = "^/home$".r
  val howtoRoute: Regex = "^/howto$".r
  val contactsRoute: Regex = "^/contacts$".r
//  val detailRoute: Regex = "^/detail/([0-9]+)$".r
}