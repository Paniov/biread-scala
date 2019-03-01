package com.github.paniov.biread.app.model

import io.circe.generic.JsonCodec

@JsonCodec case class Bible(ot: Testament, nt: Testament)
