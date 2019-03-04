package com.github.paniov.biread.test

import com.github.paniov.biread.app.books.NewTestamentBooks._
import com.github.paniov.biread.app.model.Chapter

import scala.collection.{SortedMap, SortedSet, breakOut, mutable}
import scala.language.postfixOps

class BooksSpec extends UnitSpec {

  val matthewMap = ntMatthewBook.chapters.map(x => (x.chapter -> x.verses)).toMap

  "A Matthew book" should "have 28 chapters" in {
    assert(matthewMap.size === 28)
  }

  it should "have a consecutive chapter order from 1 to 28" in {
    assert((SortedSet[Int]() ++ matthewMap.keys).toList === (1 to 28 toList))
  }

  it should "have 25 verses in Chapter 1" in {
    assert(matthewMap.get(1) === 25)
  }

  it should "have 20 verses in Chapter 28" in {
    assert(matthewMap.get(28).get === 20)
  }

}

