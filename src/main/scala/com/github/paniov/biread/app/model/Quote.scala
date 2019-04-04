package com.github.paniov.biread.app.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Quote
(
  title: String,
  chapter: Int,
  verses: Option[Verses]
) {

  override def toString = {
    s"$title $chapter ${if (verses.isEmpty) "" else s": ${verses.get.start}-${verses.get.end}"}"
  }

}


