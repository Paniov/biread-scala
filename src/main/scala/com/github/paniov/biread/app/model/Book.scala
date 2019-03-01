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
  chapters: Seq[Chapter]
)
