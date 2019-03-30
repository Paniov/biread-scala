package com.github.paniov.biread.app.model

import monocle.macros.Lenses
import io.circe.generic.JsonCodec

//@Lenses
@JsonCodec
case class Book
(
  title: String,
  group: String,
  testament: String,
  chapters: Seq[Chapter],
  orders: Map[String, Int]
)

//{
//
//  def getOrder(x: String): Int = this.orders(x)
//
//}
