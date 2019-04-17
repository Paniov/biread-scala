package com.github.paniov.biread.app.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Quote
(
  title: String,
  chapter: Int, //TODO change to Seq
  verses: Option[Verses]
) {

  override def toString = {
    s"$title $chapter${if (Some(verses).get == null) "" else s":${verses.get.start}-${verses.get.end}"}"
  }

}


object Quote {

  //TODO Add other cases e.g. when books or chapters are different
  def composeQuotes(quoteA: Quote, quoteB: Quote): Quote = Quote(
    if (quoteA.title == quoteB.title) quoteA.title else s"${quoteA.title} - ${quoteB.title}",
    if (quoteA.chapter == quoteB.chapter) quoteA.chapter else quoteB.chapter,
    Some(Verses(quoteA.verses.get.start, quoteB.verses.get.end))
  )

}