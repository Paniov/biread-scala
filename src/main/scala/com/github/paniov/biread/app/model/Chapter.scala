package com.github.paniov.biread.app.model

import io.circe.generic.JsonCodec
import monocle.macros.Lenses

@JsonCodec
//@Lenses
case class Chapter
(
  chapter:  Int,
  verses:   Int,
  parts:    Seq[Int],
  summary:  String
)
