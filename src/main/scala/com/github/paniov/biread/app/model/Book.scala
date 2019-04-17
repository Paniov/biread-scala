package com.github.paniov.biread.app.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Book
(
  title: String,
  group: String,
  testament: String,
  chapters: Seq[Chapter],
  orders: Map[String, Int]
)

object Book {

  val empty: Book = Book("", "", "", Seq[Chapter](), Map[String, Int]().empty )

}
