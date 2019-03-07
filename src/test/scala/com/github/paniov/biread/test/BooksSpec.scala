package com.github.paniov.biread.test

import com.github.paniov.biread.app.books.NewTestamentBooks._
import com.github.paniov.biread.app.model.{Book}

import scala.collection.SortedSet
import scala.language.postfixOps

class BooksSpec extends UnitSpec {

  type BookMap = Map[Int, Any]
  type TupleInt = (Int, Int)


  def addOne: Int ⇒ Int = (1 + _)

  def increaseIndex: ((Int, Int)) ⇒ (Int, Int) = (x: (Int, Int)) ⇒ (x._1, addOne(x._2))

  def swapTuple: ((Int, Int)) ⇒ (Int, Int) = (x: (Int, Int)) ⇒ x.swap

  def mapExpectedVerses: Seq[Int] ⇒ Map[Int, Int] = (x: Seq[Int]) ⇒ x.view.zipWithIndex.map(increaseIndex andThen swapTuple).toMap

  def mapActualVerses: Book ⇒ Map[Int, Int] = _.chapters.map(x ⇒ (x.chapter → x.verses)).toMap

  def mapsEq(x: BookMap, y: BookMap): Boolean = (x.toSet diff y.toSet).toMap.isEmpty

  def mapKeysToSortedList: BookMap ⇒ List[Int] = SortedSet.empty[Int] ++ _.keys toList

  val versesMatt = Seq(25, 23, 17, 25, 48, 34, 29, 34, 38, 42, 30, 50, 58, 36, 39, 28, 27, 35, 30, 34, 46, 46, 39, 51, 46, 75, 66, 20)
  val expectedMatt = mapExpectedVerses(versesMatt)
  val actualMatt = mapActualVerses(ntMatthew)
  //  val actualPartsMatt =
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

  //  it should "have a correct set of parts" in {
  //    assert(mapsEq(partsMatt, partsMatt))
  //  }

  val versesMark = Seq(45, 28, 35, 41, 43, 56, 37, 38, 50, 52, 33, 44, 37, 72, 47, 20)
  val expectedMark = mapExpectedVerses(versesMark)
  val actualMark = mapActualVerses(ntMark)
  //  val partsMark = Map(
  //
  //  )

  "Mark" should "have 16 chapters" in {
    assert(actualMark.size == 16)
  }

  it should "have a consecutive ascending order of chapters from 1 to 16" in {
    assert(mapKeysToSortedList(actualMark) === (1 to 16 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedMark, actualMark))
  }


  val versesLuke = Seq(80, 52, 38, 44, 39, 49, 50, 56, 62, 42, 54, 59, 35, 35, 32, 31, 37, 43, 48, 47, 38, 71, 56, 53)
  val expectedLuke = mapExpectedVerses(versesLuke)
  val actualLuke = mapActualVerses(ntLuke)

  "Luke" should "have 24 chapters" in {
    assert(actualLuke.size == 24)
  }

  it should "have a consecutive ascending order of chapters from 1 to 24" in {
    assert(mapKeysToSortedList(actualLuke) === (1 to 24 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedLuke, actualLuke))
  }


  val versesJohn = Seq(51, 25, 36, 54, 47, 71, 53, 59, 41, 42, 57, 50, 38, 31, 27, 33, 26, 40, 42, 31, 25)
  val expectedJohn = mapExpectedVerses(versesJohn)
  val actualJohn = mapActualVerses(ntJohn)

  "John" should "have 21 chapters" in {
    assert(actualJohn.size == 21)
  }

  it should "have a consecutive ascending order of chapters from 1 to 21" in {
    assert(mapKeysToSortedList(actualJohn) === (1 to 21 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn, actualJohn))
  }


  val versesActs = Seq(26, 47, 26, 37, 42, 15, 60, 40, 43, 48, 30, 25, 52, 28, 41, 40, 34, 28, 40, 38, 40, 30, 35, 27, 27, 32, 44, 31)
  val expectedActs = mapExpectedVerses(versesActs)
  val actualActs = mapActualVerses(ntActs)

  "Acts" should "have 28 chapters" in {
    assert(actualActs.size == 28)
  }

  it should "have a consecutive ascending order of chapters from 1 to 28" in {
    assert(mapKeysToSortedList(actualActs) === (1 to 28 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedActs, actualActs))
  }


  val versesRomans = Seq(32, 29, 31, 25, 21, 23, 25, 39, 33, 21, 36, 21, 14, 23, 33, 27)
  val expectedRomans = mapExpectedVerses(versesRomans)
  val actualRomans = mapActualVerses(ntRomans)

  "Romans" should "have 16 chapters" in {
    assert(actualRomans.size == 16)
  }

  it should "have a consecutive ascending order of chapters from 1 to 16" in {
    assert(mapKeysToSortedList(actualRomans) === (1 to 16 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedRomans, actualRomans))
  }


  val versesCorinthians1 = Seq(31, 16, 23, 21, 13, 20, 40, 13, 27, 33, 34, 31, 13, 40, 58, 24)
  val expectedCorinthians1 = mapExpectedVerses(versesCorinthians1)
  val actualCorinthians1 = mapActualVerses(ntCorinthians1)

  "1 Corinthians" should "have 16 chapters" in {
    assert(actualCorinthians1.size == 16)
  }

  it should "have a consecutive ascending order of chapters from 1 to 16" in {
    assert(mapKeysToSortedList(actualCorinthians1) === (1 to 16 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedCorinthians1, actualCorinthians1))
  }


  val versesCorinthians2 = Seq(24, 17, 18, 18, 21, 18, 16, 24, 15, 18, 33, 21, 13)
  val expectedCorinthians2 = mapExpectedVerses(versesCorinthians2)
  val actualCorinthians2 = mapActualVerses(ntCorinthians2)

  "2 Corinthians" should "have 13 chapters" in {
    assert(actualCorinthians2.size == 13)
  }

  it should "have a consecutive ascending order of chapters from 1 to 13" in {
    assert(mapKeysToSortedList(actualCorinthians2) === (1 to 13 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedCorinthians2, actualCorinthians2))
  }


  val versesGalatians = Seq(24, 21, 29, 31, 26, 18)
  val expectedGalatians = mapExpectedVerses(versesGalatians)
  val actualGalatians = mapActualVerses(ntGalatians)

  "Galatians" should "have 6 chapters" in {
    assert(actualGalatians.size == 6)
  }

  it should "have a consecutive ascending order of chapters from 1 to 6" in {
    assert(mapKeysToSortedList(actualGalatians) === (1 to 6 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedGalatians, actualGalatians))
  }


  val versesEphesians = Seq(23, 22, 21, 32, 33, 24)
  val expectedEphesians = mapExpectedVerses(versesEphesians)
  val actualEphesians = mapActualVerses(ntEphesians)

  "Ephesians" should "have 6 chapters" in {
    assert(actualEphesians.size == 6)
  }

  it should "have a consecutive ascending order of chapters from 1 to 6" in {
    assert(mapKeysToSortedList(actualEphesians) === (1 to 6 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedEphesians, actualEphesians))
  }


  val versesPhilippians = Seq(30, 30, 21, 23)
  val expectedPhilippians = mapExpectedVerses(versesPhilippians)
  val actualPhilippians = mapActualVerses(ntPhilippians)

  "Philippians" should "have 4 chapters" in {
    assert(actualPhilippians.size == 4)
  }

  it should "have a consecutive ascending order of chapters from 1 to 4" in {
    assert(mapKeysToSortedList(actualPhilippians) === (1 to 4 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPhilippians, actualPhilippians))
  }


  val versesColossians = Seq(29, 23, 25, 18)
  val expectedColossians = mapExpectedVerses(versesColossians)
  val actualColossians = mapActualVerses(ntColossians)

  "Colossians" should "have 4 chapters" in {
    assert(actualColossians.size == 4)
  }

  it should "have a consecutive ascending order of chapters from 1 to 4" in {
    assert(mapKeysToSortedList(actualColossians) === (1 to 4 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedColossians, actualColossians))
  }


  val versesThessalonians1 = Seq(10, 20, 13, 18, 28)
  val expectedThessalonians1 = mapExpectedVerses(versesThessalonians1)
  val actualThessalonians1 = mapActualVerses(ntThessalonians1)

  "1 Thessalonians" should "have 5 chapters" in {
    assert(actualThessalonians1.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualThessalonians1) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedThessalonians1, actualThessalonians1))
  }


  val versesThessalonians2 = Seq(12, 17, 18)
  val expectedThessalonians2 = mapExpectedVerses(versesThessalonians2)
  val actualThessalonians2 = mapActualVerses(ntThessalonians2)

  "2 Thessalonians" should "have 3 chapters" in {
    assert(actualThessalonians2.size == 3)
  }

  it should "have a consecutive ascending order of chapters from 1 to 3" in {
    assert(mapKeysToSortedList(actualThessalonians2) === (1 to 3 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedThessalonians2, actualThessalonians2))
  }


  val versesTimothy1 = Seq(20, 15, 16, 16, 25, 21)
  val expectedTimothy1 = mapExpectedVerses(versesTimothy1)
  val actualTimothy1 = mapActualVerses(ntTimothy1)

  "1 Timothy" should "have 6 chapters" in {
    assert(actualTimothy1.size == 6)
  }

  it should "have a consecutive ascending order of chapters from 1 to 6" in {
    assert(mapKeysToSortedList(actualTimothy1) === (1 to 6 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedTimothy1, actualTimothy1))
  }


  val versesTimothy2 = Seq(18, 26, 17, 22)
  val expectedTimothy2 = mapExpectedVerses(versesTimothy2)
  val actualTimothy2 = mapActualVerses(ntTimothy2)

  "2 Timothy" should "have 4 chapters" in {
    assert(actualTimothy2.size == 4)
  }

  it should "have a consecutive ascending order of chapters from 1 to 4" in {
    assert(mapKeysToSortedList(actualTimothy2) === (1 to 4 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedTimothy2, actualTimothy2))
  }


  val versesTitus = Seq(6, 15, 15)
  val expectedTitus = mapExpectedVerses(versesTitus)
  val actualTitus = mapActualVerses(ntTitus)

  "Titus" should "have 3 chapters" in {
    assert(actualTitus.size == 3)
  }

  it should "have a consecutive ascending order of chapters from 1 to 3" in {
    assert(mapKeysToSortedList(actualTitus) === (1 to 3 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedTitus, actualTitus))
  }


  val versesPhilemon = Seq(25)
  val expectedPhilemon = mapExpectedVerses(versesPhilemon)
  val actualPhilemon = mapActualVerses(ntPhilemon)

  "Philemon" should "have 1 chapters" in {
    assert(actualPhilemon.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualPhilemon) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPhilemon, actualPhilemon))
  }


  val versesHebrews = Seq(14, 18, 19, 16, 14, 20, 28, 13, 28, 39, 40, 29, 25)
  val expectedHebrews = mapExpectedVerses(versesHebrews)
  val actualHebrews = mapActualVerses(ntHebrews)

  "Hebrews" should "have 13 chapters" in {
    assert(actualHebrews.size == 13)
  }

  it should "have a consecutive ascending order of chapters from 1 to 13" in {
    assert(mapKeysToSortedList(actualHebrews) === (1 to 13 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedHebrews, actualHebrews))
  }


  val versesJames = Seq(27, 26, 18, 17, 20)
  val expectedJames = mapExpectedVerses(versesJames)
  val actualJames = mapActualVerses(ntJames)

  "James" should "have 5 chapters" in {
    assert(actualJames.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualJames) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJames, actualJames))
  }


  val versesPeter1 = Seq(25, 25, 22, 19, 14)
  val expectedPeter1 = mapExpectedVerses(versesPeter1)
  val actualPeter1 = mapActualVerses(ntPeter1)

  "1 Peter" should "have 5 chapters" in {
    assert(actualPeter1.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualPeter1) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPeter1, actualPeter1))
  }


  val versesPeter2 = Seq(21, 22, 18)
  val expectedPeter2 = mapExpectedVerses(versesPeter2)
  val actualPeter2 = mapActualVerses(ntPeter2)

  "2 Peter" should "have 3 chapters" in {
    assert(actualPeter2.size == 3)
  }

  it should "have a consecutive ascending order of chapters from 1 to 3" in {
    assert(mapKeysToSortedList(actualPeter2) === (1 to 3 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedPeter2, actualPeter2))
  }


  val versesJohn1 = Seq(10, 29, 24, 21, 21)
  val expectedJohn1 = mapExpectedVerses(versesJohn1)
  val actualJohn1 = mapActualVerses(ntJohn1)

  "1 John" should "have 5 chapters" in {
    assert(actualJohn1.size == 5)
  }

  it should "have a consecutive ascending order of chapters from 1 to 5" in {
    assert(mapKeysToSortedList(actualJohn1) === (1 to 5 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn1, actualJohn1))
  }


  val versesJohn2 = Seq(13)
  val expectedJohn2 = mapExpectedVerses(versesJohn2)
  val actualJohn2 = mapActualVerses(ntJohn2)

  "2 John" should "have 1 chapters" in {
    assert(actualJohn2.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualJohn2) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn2, actualJohn2))
  }


  val versesJohn3 = Seq(15)
  val expectedJohn3 = mapExpectedVerses(versesJohn3)
  val actualJohn3 = mapActualVerses(ntJohn3)

  "3 John" should "have 1 chapters" in {
    assert(actualJohn3.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualJohn3) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJohn3, actualJohn3))
  }


  val versesJude = Seq(25)
  val expectedJude = mapExpectedVerses(versesJude)
  val actualJude = mapActualVerses(ntJude)

  "Jude" should "have 1 chapters" in {
    assert(actualJude.size == 1)
  }

  it should "have a consecutive ascending order of chapters from 1 to 1" in {
    assert(mapKeysToSortedList(actualJude) === (1 to 1 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedJude, actualJude))
  }


  val versesRevelation = Seq(20, 29, 22, 11, 14, 17, 17, 13, 21, 11, 19, 17, 18, 20, 8, 21, 18, 24, 21, 15, 27, 21)
  val expectedRevelation = mapExpectedVerses(versesRevelation)
  val actualRevelation = mapActualVerses(ntRevelation)

  "Revelation" should "have 22 chapters" in {
    assert(actualRevelation.size == 22)
  }

  it should "have a consecutive ascending order of chapters from 1 to 22" in {
    assert(mapKeysToSortedList(actualRevelation) === (1 to 22 toList))
  }

  it should "have a correct set of verses" in {
    assert(mapsEq(expectedRevelation, actualRevelation))
  }


}

