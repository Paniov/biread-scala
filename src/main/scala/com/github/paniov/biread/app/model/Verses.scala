package com.github.paniov.biread.app.model

import io.circe.generic.JsonCodec

@JsonCodec
case class Verses(start: Int, end: Int)