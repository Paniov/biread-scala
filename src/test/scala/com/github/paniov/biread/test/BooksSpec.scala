package com.github.paniov.biread.test

import com.github.paniov.biread.app.books.NewTestamentBooks._
import com.github.paniov.biread.app.model.{Book, Quote, Verses}

import scala.collection.SortedSet
import scala.language.postfixOps

class BooksSpec extends UnitSpec {

  type BookMap = Map[Int, Int]
  type TupleInt = (Int, Int)

  def addOne: Int ⇒ Int = (1 + _)

  def increaseIndex: ((Int, Int)) ⇒ (Int, Int) = x ⇒ (x._1, addOne(x._2))

  def swapTuple: ((Int, Int)) ⇒ (Int, Int) = x ⇒ x.swap

  def swapTupleSeq: ((Seq[Int], Int)) ⇒ (Int, Seq[Int]) = x ⇒ x.swap

  def mapExpectedVerses: Seq[Int] ⇒ Map[Int, Int] = _.view.zipWithIndex.map(increaseIndex andThen swapTuple).toMap

  def mapActualVerses: Book ⇒ Map[Int, Int] = _.chapters.map(x ⇒ (x.chapter → x.verses)).toMap

  def mapActualParts: Book ⇒ Map[Int, Seq[Int]] = _.chapters.map(x ⇒ (x.chapter → x.parts)).toMap

  def mapsEq(x: BookMap, y: BookMap): Boolean = (x.toSet diff y.toSet).toMap.isEmpty

  def rejectEmpty(x: Map[Int, Seq[Int]]): Map[Int, Seq[Int]] = x.filter(_._2.nonEmpty)

  def mapsDiff(x: Map[Int, Seq[Int]], y: Map[Int, Seq[Int]]): Boolean = (rejectEmpty(x).toSet diff rejectEmpty(y).toSet).toMap.isEmpty

  def mapsPartsEq(x: Map[Int, Seq[Int]], y: Map[Int, Seq[Int]]): Boolean = mapsDiff(x, y) && mapsDiff(y, x)

  def mapKeysToSortedList: BookMap ⇒ List[Int] = SortedSet.empty[Int] ++ _.keys toList

  def expandRange(last: Int, xs: List[Int]): List[Int] = 1 :: xs.foldRight(List(last)) { (i, acc) ⇒ (i-1) :: i :: acc }
////    acc
//  }
//  def addLast(last: Int): Seq[Int] ⇒

//  def getQuote(book: Book): Seq[Quote] = {
//    val quotes = book.chapters.foldLeft(Seq.empty[Quote]) {
//      (acc, chapter) ⇒ {
//
//        if (chapter.parts.size == 0) {
//          acc :+ Quote(book.title, chapter.chapter, null)
//        } else {
//          //          val allParts = List(1) ++ chapter.parts ++ List(chapter.verses)
//          //          val partsToPairs = allParts
//          val booksFromParts = chapter.parts.foldLeft(1) {
//            (partPrevious, partCurrent) ⇒ {
//              val start = partPrevious
//              val end = partCurrent - 1
//              acc :+ Quote(book.title, chapter.chapter, Option(Verses(start, end)))
//              partCurrent
//            }
//          }
//
//          return acc
//
//        }
//      }
//    }
//    return quotes
//  }


  val booksEN = ntBooks.sortBy(x ⇒ x.orders("en"))
  val booksRU = ntBooks.sortBy(x ⇒ x.orders("ru"))

  "Books of EN and RU versions" should "differ in its order" in {
    assert(booksEN !== booksRU)
  }

  "Books of EN version" should "be of size 27" in {
    val size = booksEN.size
    assert(size == 27, "Actual size of books was " + size + " instead of 27")
  }

  it should "have book of Romans on index 5" in {
    assert(booksEN.indexWhere(x ⇒ x.title == "Romans") == 5)
  }

  it should "have book of James on index 19" in {
    assert(booksEN.indexWhere(x ⇒ x.title == "James") == 19)
  }


  "Books of RU version" should "be of size 27" in {
    val size = booksRU.size
    assert(size == 27, "Actual size of books was " + size + " instead of 27")
  }

  it should "have book of Romans on index 12" in {
    assert(booksRU.indexWhere(x ⇒ x.title == "Romans") == 12)
  }

  it should "have book of James on index 5" in {
    assert(booksRU.indexWhere(x ⇒ x.title == "James") == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 28" in {
    assert(mapKeysToSortedList(actualMatt) === (1 to 28 toList))
  }

  val versesMatt = Seq(25, 23, 17, 25, 48, 34, 29, 34, 38, 42, 30, 50, 58, 36, 39, 28, 27, 35, 30, 34, 46, 46, 39, 51, 46, 75, 66, 20)
  val actualMatt = mapActualVerses(ntMatthew)
  val expectedMatt = mapExpectedVerses(versesMatt)

  val actualPartsMatt = mapActualParts(ntMatthew)
  val expectedPartsMatt = Map(
    5 → Seq(27),
    6 → Seq(19),
    8 → Seq(18),
    9 → Seq(18),
    10 → Seq(21),
    12 → Seq(24),
    13 → Seq(31),
    14 → Seq(22),
    15 → Seq(21),
    18 → Seq(21),
    20 → Seq(17),
    21 → Seq(23),
    22 → Seq(23),
    23 → Seq(23),
    24 → Seq(29),
    25 → Seq(31),
    26 → Seq(26, 51),
    27 → Seq(27, 51)
  )

  "Matthew" should "have 28 chapters" in {
    assert(actualMatt.size == 28)
  }

  it should "have a consecutive ascending order of chapters from 1 to 28" in {
    assert(mapKeysToSortedList(actualMatt) === (1 to 28 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedMatt, actualMatt))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsMatt, actualPartsMatt))
  }

  it should "be divided by 20 daily quotes" in {
    val quotes = getQuote(ntMatthew)
    assert(quotes.size == 20)
  }


  val versesMark = Seq(45, 28, 35, 41, 43, 56, 37, 38, 50, 52, 33, 44, 37, 72, 47, 20)
  val expectedMark = mapExpectedVerses(versesMark)
  val actualMark = mapActualVerses(ntMark)

  val actualPartsMark = mapActualParts(ntMark)
  val expectedPartsMark = Map(
    1 → Seq(23),
    3 → Seq(20),
    4 → Seq(21),
    5 → Seq(21),
    6 → Seq(30),
    8 → Seq(22),
    9 → Seq(30),
    10 → Seq(32),
    11 → Seq(19),
    12 → Seq(28),
    13 → Seq(21),
    14 → Seq(27, 54),
    15 → Seq(26)
  )

  "Mark" should "have 16 chapters" in {
    assert(actualMark.size == 16)
  }

  it should "have a consecutive ascending order of chapters from 1 to 16" in {
    assert(mapKeysToSortedList(actualMark) === (1 to 16 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedMark, actualMark))
  }

  it should "have a corrects set of parts" in {
    assert(mapsPartsEq(expectedPartsMark, actualPartsMark))
  }


  val versesLuke = Seq(80, 52, 38, 44, 39, 49, 50, 56, 62, 42, 54, 59, 35, 35, 32, 31, 37, 43, 48, 47, 38, 71, 56, 53)
  val expectedLuke = mapExpectedVerses(versesLuke)
  val actualLuke = mapActualVerses(ntLuke)

  val actualPartsLuke = mapActualParts(ntLuke)
  val expectedPartsLuke = Map(
    1 → Seq(21, 39, 57),
    2 → Seq(25),
    4 → Seq(31),
    5 → Seq(17),
    6 → Seq(27),
    7 → Seq(31),
    8 → Seq(26),
    9 → Seq(18, 37),
    10 → Seq(25),
    11 → Seq(29),
    12 → Seq(32),
    13 → Seq(23),
    14 → Seq(25),
    15 → Seq(11),
    17 → Seq(20),
    18 → Seq(24),
    19 → Seq(28),
    20 → Seq(27),
    21 → Seq(20),
    22 → Seq(21, 47),
    23 → Seq(26),
    24 → Seq(36)
  )

  "Luke" should "have 24 chapters" in {
    assert(actualLuke.size == 24)
  }

  it should "have a consecutive ascending order of chapters from 1 to 24" in {
    assert(mapKeysToSortedList(actualLuke) === (1 to 24 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedLuke, actualLuke))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsLuke, actualPartsLuke))
  }


  val versesJohn = Seq(51, 25, 36, 54, 47, 71, 53, 59, 41, 42, 57, 50, 38, 31, 27, 33, 26, 40, 42, 31, 25)
  val expectedJohn = mapExpectedVerses(versesJohn)
  val actualJohn = mapActualVerses(ntJohn)

  val actualPartsJohn = mapActualParts(ntJohn)
  val expectedPartsJohn = Map(
    1 → Seq(29),
    3 → Seq(19),
    4 → Seq(31),
    5 → Seq(25),
    6 → Seq(22, 45),
    7 → Seq(28),
    8 → Seq(28),
    9 → Seq(24),
    10 → Seq(24),
    11 → Seq(30),
    12 → Seq(27),
    13 → Seq(21),
    18 → Seq(19),
    19 → Seq(23),
  )

  "John" should "have 21 chapters" in {
    assert(actualJohn.size == 21)
  }

  it should "have a consecutive ascending order of chapters from 1 to 21" in {
    assert(mapKeysToSortedList(actualJohn) === (1 to 21 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn, actualJohn))
  }

  it should "hve a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsJohn, actualPartsJohn))
  }


  val versesActs = Seq(26, 47, 26, 37, 42, 15, 60, 40, 43, 48, 30, 25, 52, 28, 41, 40, 34, 28, 40, 38, 40, 30, 35, 27, 27, 32, 44, 31)
  val expectedActs = mapExpectedVerses(versesActs)
  val actualActs = mapActualVerses(ntActs)

  val actualPartsActs = mapActualParts(ntActs)
  val expectedPartsActs = Map(
    2 → Seq(22),
    4 → Seq(23),
    5 → Seq(22),
    7 → Seq(22, 44),
    8 → Seq(26),
    9 → Seq(22),
    10 → Seq(24),
    13 → Seq(26),
    15 → Seq(22),
    16 → Seq(22),
    17 → Seq(16),
    19 → Seq(21),
    20 → Seq(17),
    21 → Seq(18),
    23 → Seq(16),
    27 → Seq(27)
  )

  "Acts" should "have 28 chapters" in {
    assert(actualActs.size == 28)
  }

  it should "have a consecutive ascending order of chapters from 1 to 28" in {
    assert(mapKeysToSortedList(actualActs) === (1 to 28 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedActs, actualActs))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsActs, actualPartsActs))
  }


  val versesRomans = Seq(32, 29, 31, 25, 21, 23, 25, 39, 33, 21, 36, 21, 14, 23, 33, 27)
  val expectedRomans = mapExpectedVerses(versesRomans)
  val actualRomans = mapActualVerses(ntRomans)

  val actualPartsRomans = mapActualParts(ntRomans)
  val expectedPartsRomans = Map(
    8 → Seq(22),
    9 → Seq(16),
    11 → Seq(19),
    15 → Seq(14)
  )

  "Romans" should "have 16 chapters" in {
    assert(actualRomans.size == 16)
  }

  it should "have a consecutive ascending order of chapters from 1 to 16" in {
    assert(mapKeysToSortedList(actualRomans) === (1 to 16 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedRomans, actualRomans))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsRomans, actualPartsRomans))
  }


  val versesCorinthians1 = Seq(31, 16, 23, 21, 13, 20, 40, 13, 27, 33, 34, 31, 13, 40, 58, 24)
  val expectedCorinthians1 = mapExpectedVerses(versesCorinthians1)
  val actualCorinthians1 = mapActualVerses(ntCorinthians1)

  val actualPartsCorinthians1 = mapActualParts(ntCorinthians1)
  val expectedPartsCorinthians1 = Map(
    7 → Seq(20),
    10 → Seq(19),
    11 → Seq(17),
    14 → Seq(21),
    15 → Seq(29)
  )

  "1 Corinthians" should "have 16 chapters" in {
    assert(actualCorinthians1.size == 16)
  }

  it should "have a consecutive ascending order of chapters from 1 to 16" in {
    assert(mapKeysToSortedList(actualCorinthians1) === (1 to 16 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedCorinthians1, actualCorinthians1))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsCorinthians1, actualPartsCorinthians1))
  }


  val versesCorinthians2 = Seq(24, 17, 18, 18, 21, 18, 16, 24, 15, 18, 33, 21, 13)
  val expectedCorinthians2 = mapExpectedVerses(versesCorinthians2)
  val actualCorinthians2 = mapActualVerses(ntCorinthians2)

  val actualPartsCorinthians2 = mapActualParts(ntCorinthians2)
  val expectedPartsCorinthians2 = Map(
    11 → Seq(16)
  )

  "2 Corinthians" should "have 13 chapters" in {
    assert(actualCorinthians2.size == 13)
  }

  it should "have a consecutive ascending order of chapters from 1 to 13" in {
    assert(mapKeysToSortedList(actualCorinthians2) === (1 to 13 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedCorinthians2, actualCorinthians2))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsCorinthians2, actualPartsCorinthians2))
  }


  val versesGalatians = Seq(24, 21, 29, 31, 26, 18)
  val expectedGalatians = mapExpectedVerses(versesGalatians)
  val actualGalatians = mapActualVerses(ntGalatians)

  val actualPartsGalatians = mapActualParts(ntGalatians)
  val expectedPartsGalatians = Map[Int, Seq[Int]]().empty

  "Galatians" should "have 6 chapters" in {
    assert(actualGalatians.size == 6)
  }

  it should "have a consecutive ascending order of chapters from 1 to 6" in {
    assert(mapKeysToSortedList(actualGalatians) === (1 to 6 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedGalatians, actualGalatians))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsGalatians, actualPartsGalatians))
  }


  val versesEphesians = Seq(23, 22, 21, 32, 33, 24)
  val expectedEphesians = mapExpectedVerses(versesEphesians)
  val actualEphesians = mapActualVerses(ntEphesians)

  val actualPartsEphesians = mapActualParts(ntEphesians)
  val expectedPartsEphesians = Map(
    5 → Seq(17)
  )

  "Ephesians" should "have 6 chapters" in {
    assert(actualEphesians.size == 6)
  }

  it should "have a consecutive ascending order of chapters from 1 to 6" in {
    assert(mapKeysToSortedList(actualEphesians) === (1 to 6 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedEphesians, actualEphesians))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsEphesians, actualPartsEphesians))
  }


  val versesPhilippians = Seq(30, 30, 21, 23)
  val expectedPhilippians = mapExpectedVerses(versesPhilippians)
  val actualPhilippians = mapActualVerses(ntPhilippians)

  val actualPartsPhilippians = mapActualParts(ntPhilippians)
  val expectedPartsPhilippians = Map[Int, Seq[Int]]().empty

  "Philippians" should "have 4 chapters" in {
    assert(actualPhilippians.size == 4)
  }

  it should "have a consecutive ascending order of chapters from 1 to 4" in {
    assert(mapKeysToSortedList(actualPhilippians) === (1 to 4 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPhilippians, actualPhilippians))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsPhilippians, actualPartsPhilippians))
  }


  val versesColossians = Seq(29, 23, 25, 18)
  val expectedColossians = mapExpectedVerses(versesColossians)
  val actualColossians = mapActualVerses(ntColossians)

  val actualPartsColossians = mapActualParts(ntColossians)
  val expectedPartsColossians = Map[Int, Seq[Int]]().empty

  "Colossians" should "have 4 chapters" in {
    assert(actualColossians.size == 4)
  }

  it should "have a consecutive ascending order of chapters from 1 to 4" in {
    assert(mapKeysToSortedList(actualColossians) === (1 to 4 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedColossians, actualColossians))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsColossians, actualPartsColossians))
  }


  val versesThessalonians1 = Seq(10, 20, 13, 18, 28)
  val expectedThessalonians1 = mapExpectedVerses(versesThessalonians1)
  val actualThessalonians1 = mapActualVerses(ntThessalonians1)
  val actualPartsThessalonians1 = mapActualParts(ntThessalonians1)
  val expectedPartsThessalonians1 = Map[Int, Seq[Int]]().empty

  "1 Thessalonians" should "have 5 chapters" in {
    assert(actualThessalonians1.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualThessalonians1) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedThessalonians1, actualThessalonians1))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsThessalonians1, actualPartsThessalonians1))
  }


  val versesThessalonians2 = Seq(12, 17, 18)
  val expectedThessalonians2 = mapExpectedVerses(versesThessalonians2)
  val actualThessalonians2 = mapActualVerses(ntThessalonians2)
  val actualPartsThessalonians2 = mapActualParts(ntThessalonians2)
  val expectedPartsThessalonians2 = Map[Int, Seq[Int]]().empty

  "2 Thessalonians" should "have 3 chapters" in {
    assert(actualThessalonians2.size == 3)
  }

  it should "have a consecutive ascending order of chapters from 1 to 3" in {
    assert(mapKeysToSortedList(actualThessalonians2) === (1 to 3 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedThessalonians2, actualThessalonians2))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsThessalonians2, actualPartsThessalonians2))
  }


  val versesTimothy1 = Seq(20, 15, 16, 16, 25, 21)
  val expectedTimothy1 = mapExpectedVerses(versesTimothy1)
  val actualTimothy1 = mapActualVerses(ntTimothy1)
  val actualPartsTimothy1 = mapActualParts(ntTimothy1)
  val expectedPartsTimothy1 = Map[Int, Seq[Int]]().empty

  "1 Timothy" should "have 6 chapters" in {
    assert(actualTimothy1.size == 6)
  }

  it should "have a consecutive ascending order of chapters from 1 to 6" in {
    assert(mapKeysToSortedList(actualTimothy1) === (1 to 6 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedTimothy1, actualTimothy1))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsTimothy1, actualPartsTimothy1))
  }


  val versesTimothy2 = Seq(18, 26, 17, 22)
  val expectedTimothy2 = mapExpectedVerses(versesTimothy2)
  val actualTimothy2 = mapActualVerses(ntTimothy2)
  val actualPartsTimothy2 = mapActualParts(ntTimothy2)
  val expectedPartsTimothy2 = Map[Int, Seq[Int]]().empty

  "2 Timothy" should "have 4 chapters" in {
    assert(actualTimothy2.size == 4)
  }

  it should "have a consecutive ascending order of chapters from 1 to 4" in {
    assert(mapKeysToSortedList(actualTimothy2) === (1 to 4 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedTimothy2, actualTimothy2))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsTimothy2, actualPartsTimothy2))
  }


  val versesTitus = Seq(6, 15, 15)
  val expectedTitus = mapExpectedVerses(versesTitus)
  val actualTitus = mapActualVerses(ntTitus)
  val actualPartsTitus = mapActualParts(ntTitus)
  val expectedPartsTitus = Map[Int, Seq[Int]]().empty

  "Titus" should "have 3 chapters" in {
    assert(actualTitus.size == 3)
  }

  it should "have a consecutive ascending order of chapters from 1 to 3" in {
    assert(mapKeysToSortedList(actualTitus) === (1 to 3 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedTitus, actualTitus))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsTitus, actualPartsTitus))
  }


  val versesPhilemon = Seq(25)
  val expectedPhilemon = mapExpectedVerses(versesPhilemon)
  val actualPhilemon = mapActualVerses(ntPhilemon)
  val actualPartsPhilemon = mapActualParts(ntPhilemon)
  val expectedPartsPhilemon = Map[Int, Seq[Int]]().empty


  "Philemon" should "have 1 chapters" in {
    assert(actualPhilemon.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualPhilemon) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPhilemon, actualPhilemon))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsPhilemon, actualPartsPhilemon))
  }


  val versesHebrews = Seq(14, 18, 19, 16, 14, 20, 28, 13, 28, 39, 40, 29, 25)
  val expectedHebrews = mapExpectedVerses(versesHebrews)
  val actualHebrews = mapActualVerses(ntHebrews)
  val actualPartsHebrews = mapActualParts(ntHebrews)
  val expectedPartsHebrews = Map[Int, Seq[Int]]().empty

  "Hebrews" should "have 13 chapters" in {
    assert(actualHebrews.size == 13)
  }

  it should "have a consecutive ascending order of chapters from 1 to 13" in {
    assert(mapKeysToSortedList(actualHebrews) === (1 to 13 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedHebrews, actualHebrews))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsHebrews, actualPartsHebrews))
  }


  val versesJames = Seq(27, 26, 18, 17, 20)
  val expectedJames = mapExpectedVerses(versesJames)
  val actualJames = mapActualVerses(ntJames)
  val actualPartsJames = mapActualParts(ntJames)
  val expectedPartsJames = Map[Int, Seq[Int]]().empty

  "James" should "have 5 chapters" in {
    assert(actualJames.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualJames) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJames, actualJames))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsJames, actualPartsJames))
  }


  val versesPeter1 = Seq(25, 25, 22, 19, 14)
  val expectedPeter1 = mapExpectedVerses(versesPeter1)
  val actualPeter1 = mapActualVerses(ntPeter1)
  val actualPartsPeter1 = mapActualParts(ntPeter1)
  val expectedPartsPeter1 = Map[Int, Seq[Int]]().empty

  "1 Peter" should "have 5 chapters" in {
    assert(actualPeter1.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualPeter1) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPeter1, actualPeter1))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsPeter1, actualPartsPeter1))
  }


  val versesPeter2 = Seq(21, 22, 18)
  val expectedPeter2 = mapExpectedVerses(versesPeter2)
  val actualPeter2 = mapActualVerses(ntPeter2)
  val actualPartsPeter2 = mapActualParts(ntPeter2)
  val expectedPartsPeter2 = Map[Int, Seq[Int]]().empty

  "2 Peter" should "have 3 chapters" in {
    assert(actualPeter2.size == 3)
  }

  it should "have a consecutive ascending order of chapters from 1 to 3" in {
    assert(mapKeysToSortedList(actualPeter2) === (1 to 3 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPeter2, actualPeter2))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsPeter2, actualPartsPeter2))
  }

  val versesJohn1 = Seq(10, 29, 24, 21, 21)
  val expectedJohn1 = mapExpectedVerses(versesJohn1)
  val actualJohn1 = mapActualVerses(ntJohn1)
  val actualPartsJohn1 = mapActualParts(ntJohn1)
  val expectedPartsJohn1 = Map[Int, Seq[Int]]().empty

  "1 John" should "have 5 chapters" in {
    assert(actualJohn1.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualJohn1) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn1, actualJohn1))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsJohn1, actualPartsJohn1))
  }

  val versesJohn2 = Seq(13)
  val expectedJohn2 = mapExpectedVerses(versesJohn2)
  val actualJohn2 = mapActualVerses(ntJohn2)
  val actualPartsJohn2 = mapActualParts(ntJohn2)
  val expectedPartsJohn2 = Map[Int, Seq[Int]]().empty

  "2 John" should "have 1 chapters" in {
    assert(actualJohn2.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualJohn2) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn2, actualJohn2))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsJohn2, actualPartsJohn2))
  }


  val versesJohn3 = Seq(15)
  val expectedJohn3 = mapExpectedVerses(versesJohn3)
  val actualJohn3 = mapActualVerses(ntJohn3)
  val actualPartsJohn3 = mapActualParts(ntJohn3)
  val expectedPartsJohn3 = Map[Int, Seq[Int]]().empty

  "3 John" should "have 1 chapters" in {
    assert(actualJohn3.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualJohn3) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn3, actualJohn3))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsJohn3, actualPartsJohn3))
  }


  val versesJude = Seq(25)
  val expectedJude = mapExpectedVerses(versesJude)
  val actualJude = mapActualVerses(ntJude)
  val actualPartsJude = mapActualParts(ntJude)
  val expectedPartsJude = Map[Int, Seq[Int]]().empty

  "Jude" should "have 1 chapters" in {
    assert(actualJude.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualJude) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJude, actualJude))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsJude, actualPartsJude))
  }


  val versesRevelation = Seq(20, 29, 22, 11, 14, 17, 17, 13, 21, 11, 19, 17, 18, 20, 8, 21, 18, 24, 21, 15, 27, 21)
  val expectedRevelation = mapExpectedVerses(versesRevelation)
  val actualRevelation = mapActualVerses(ntRevelation)
  val actualPartsRevelation = mapActualParts(ntRevelation)
  val expectedPartsRevelation = Map[Int, Seq[Int]]().empty

  "Revelation" should "have 22 chapters" in {
    assert(actualRevelation.size == 22)
  }

  it should "have a consecutive ascending order of chapters from 1 to 22" in {
    assert(mapKeysToSortedList(actualRevelation) === (1 to 22 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedRevelation, actualRevelation))
  }

  it should "have a correct set of parts" in {
    assert(mapsPartsEq(expectedPartsRevelation, actualPartsRevelation))
  }

}

