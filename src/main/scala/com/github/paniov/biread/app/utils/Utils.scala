package com.github.paniov.biread.app.utils

import java.time.LocalDate
import java.time.format.{DateTimeFormatter, FormatStyle}

import com.github.paniov.biread.app.model.Quote.composeQuotes
import com.github.paniov.biread.app.model.{Book, Quote, Verses}

import scala.collection.SortedSet

object Utils {

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

  def expandRange(last: Int): Seq[Int] ⇒ Seq[Int] = 1 :: _.foldRight(List(last)) { (i, acc) ⇒ (i - 1) :: i :: acc }

  def groupByPair: Seq[Int] ⇒ Seq[(Int, Int)] = _.grouped(2).map(p => (p.head, p.last)).toList

  def expandAndGroup(last: Int): Seq[Int] ⇒ Seq[(Int, Int)] = (groupByPair compose expandRange(last)) (_)

  def splitQuotes: List[Quote] => Int => (List[Quote], List[Quote]) = _.splitAt

  def glueShearQuotes: Tuple2[List[Quote], List[Quote]] => List[Quote] = (t) => t._1.init ::: (composeQuotes(t._1.last, t._2.head) :: t._2.tail)

  def joinQuotesAt(index: Int)(list: List[Quote]): List[Quote] = (glueShearQuotes compose splitQuotes(list)) (index)


  def getQuote(book: Book): Seq[Quote] = {
    book.chapters.foldLeft(Seq.empty[Quote]) {
      (acc, chapter) ⇒ {
        if (chapter.parts.size == 0) {
          acc :+ Quote(book.title, chapter.chapter, null)
        } else {
          acc ++ (expandAndGroup(chapter.verses)(chapter.parts)).map(x ⇒ Quote(book.title, chapter.chapter, Option(Verses(x._1, x._2))))
        }
      }
    }
  }


  /* Quote API */
  def getLeapYearQuotes: Seq[Book] ⇒ List[Quote] = _.map(x ⇒ getQuote(x)).flatten.toList

  def quoteString: Quote ⇒ String = _.toString

  def getQuoteStrings: List[Quote] ⇒ List[String] = _.map(quoteString)

  def swapQuoteTuple: ((String, Int)) ⇒ (Int, String) = x ⇒ x.swap

  def increaseQuoteMapIndex: ((String, Int)) ⇒ (String, Int) = x ⇒ (x._1, addOne(x._2)) //TODO refactor it with generic types

  def alterZipIndex = swapQuoteTuple compose increaseQuoteMapIndex

  def zipWithIndexQuoteStrings: List[String] ⇒ Map[Int, String] = _.view.zipWithIndex.map(alterZipIndex).toMap

  def getQuoteStringsMap: List[Quote] ⇒ Map[Int, String] = zipWithIndexQuoteStrings compose getQuoteStrings

  def getLeapYearQuoteStringMap: Seq[Book] ⇒ Map[Int, String] = getQuoteStringsMap compose getLeapYearQuotes

  def getNormalYearQuoteStringMap: Seq[Book] ⇒ Map[Int, String] = getQuoteStringsMap compose joinQuotesAt(60) compose getLeapYearQuotes


  /* Date API */
  def getCurrentDate: LocalDate = LocalDate.now()

  def getNextDate: LocalDate ⇒ LocalDate = _.plusDays(1)

  def getPrevDate: LocalDate ⇒ LocalDate = _.minusDays(1)

  val DATE_W_M_D_Y = FormatStyle.FULL
  val DATE_M_D_Y = FormatStyle.LONG

  def getDateString: LocalDate ⇒ String = _.format(DateTimeFormatter.ofLocalizedDate(DATE_W_M_D_Y))
}
