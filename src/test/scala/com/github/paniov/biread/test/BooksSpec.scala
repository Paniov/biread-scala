package com.github.paniov.biread.test

import com.github.paniov.biread.app.books.NewTestamentBooks._
import com.github.paniov.biread.app.model.Chapter

import scala.collection.{SortedMap, SortedSet, breakOut, mutable}
import scala.language.postfixOps

class BooksSpec extends UnitSpec {

  def addOne: Int => Int = (_+1)
  def increaseIndex = (x: (Int, Int)) => (x._1, addOne(x._2))
  def swapTuple[A](x: (A, A)): (A, A) = x.swap
  def mapsEq[A](x: Map[A,A], y: Map[A,A]): Boolean = (x.toSet diff y.toSet).toMap.isEmpty

  val mattVerses = Seq(25,23,17,25,48,34,29,34,38,42,30,50,58,36,39,28,27,35,30,34,46,46,39,51,46,75,66,20)

  val expectedMatt = mattVerses.view.zipWithIndex.map(increaseIndex andThen swapTuple).toMap
  val actualMatt = ntMatthewBook.chapters.map(x => (x.chapter -> x.verses)).toMap

  "A Matthew book" should "have 28 chapters" in {
    assert(actualMatt.size === 28)
  }

  it should "have a consecutive ascending order of chapters from 1 to 28" in {
    assert((SortedSet[Int]() ++ actualMatt.keys).toList === (1 to 28 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedMatt, actualMatt))
  }

}

