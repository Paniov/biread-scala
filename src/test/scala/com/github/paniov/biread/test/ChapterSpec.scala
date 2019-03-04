package com.github.paniov.biread.test

import com.github.paniov.biread.app.books.NewTestamentBooks._

class ChapterSpec extends UnitSpec {

  "A Matthew chapter 1" should "have 25 verses" in {
    val matt = ntMatthewBook
    assert(matt.chapters(0).verses === 25)
  }

}
