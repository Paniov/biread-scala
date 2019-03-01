package com.github.paniov.biread.app.model

import monocle.macros.Lenses
import io.circe.generic.JsonCodec

//@Lenses
@JsonCodec
case class Testament(name: String, books: Seq[Book])
