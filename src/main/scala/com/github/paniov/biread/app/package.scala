package com.github.paniov.biread

import io.circe.Json
import io.circe.syntax._
import io.circe.generic.auto._
import com.github.paniov.biread.app.model.{Bible, Book, Chapter, Testament}

package object app {

  val New = "new"
  val Old = "old"

  val Pentateuch = "Pentateuch"
  val Historical = "Historical"
  val Poetical = "Poetical"
  val MajorProphets = "Major Prophets"
  val MinorProphets = "Minor Prophets"
  val Gospel = "Gospel"
  val EpistlesOfPaul = "Epistles of Paul"
  val Epistles = "Epistles"
  val Prophetical = "Prophetical"

  val Genesis = "Genesis"
  val Exodus = "Exodus"
  val Leviticus = "Leviticus"
  val Numbers = "Numbers"
  val Deuteronomy = "Deuteronomy"
  val Joshua = "Joshua"
  val Judges = "Judges"
  val Ruth = "Ruth"
  val Samuel1 = "1 Samuel"
  val Samuel2 = "2 Samuel"
  val Kings1 = "1 Kings"
  val Kings2 = "2 Kings"
  val Chronicles1 = "1 Chronicles"
  val Chronicles2 = "2 Chronicles"
  val Ezra = "Ezra"
  val Nehemiah = "Nehemiah"
  val Esther = "Esther"
  val Job = "Job"
  val Psalms = "Psalms"
  val Proverbs = "Proverbs"
  val Ecclesiastes = "Ecclesiastes"
  val SongOfSolomon = "Song of Solomon"
  val Isaiah = "Isaiah"
  val Jeremiah = "Jeremiah"
  val Lamentations = "Lamentations"
  val Ezekiel = "Ezekiel"
  val Daniel = "Daniel"
  val Hosea = "Hosea"
  val Joel = "Joel"
  val Amos = "Amos"
  val Obadiah = "Obadiah"
  val Jonah = "Jonah"
  val Micah = "Micah"
  val Nahum = "Nahum"
  val Habakkuk = "Habakkuk"
  val Zephaniah = "Zephaniah"
  val Haggai = "Haggai"
  val Zechariah = "Zechariah"
  val Malachi = "Malachi"

  val Matthew = "Matthew"
  val Mark = "Mark"
  val Luke = "Luke"
  val John = "John"
  val Acts = "Acts"
  val Romans = "Romans"
  val Corinthians1 = "1 Corinthians"
  val Corinthians2 = "2 Corinthians"
  val Galatians = "Galatians"
  val Ephesians = "Ephesians"
  val Philippians = "Philippians"
  val Colossians = "Colossians"
  val Thessalonians1 = "1 Thessalonians"
  val Thessalonians2 = "2 Thessalonians"
  val Timothy1 = "1 Timothy"
  val Timothy2 = "2 Timothy "
  val Titus = "Titus"
  val Philemon = "Philemon"
  val Hebrews = "Hebrews"
  val James = "James"
  val Peter1 = "1 Peter"
  val Peter2 = "2 Peter"
  val John1 = "1 John"
  val John2 = "2 John"
  val John3 = "3 John"
  val Jude = "Jude"
  val Revelation = "Revelation"

  val genesisChapters: Seq[Chapter] = Seq(
    Chapter(1, 31, Seq(1, 6, 9, 14, 20, 24, 26), "The Creation"),
    Chapter(2, 25, Seq(1, 4, 10, 15, 18), "The Creation of Man and Woman")
  )

  val genesisBook = Book(Genesis, Pentateuch, Old, genesisChapters)

  val oldTestamentBooks: Seq[Book] = Seq(
    genesisBook
  )


  val bible: Bible = Bible(Testament(Old, oldTestamentBooks), Testament(New, oldTestamentBooks))

  val bibleJSON = bible.asJson

  val assetsPath = "./"

  //  val w: Writer = new FileWriter(assetsPath + "bibleEn" + ".json")
  //  w.close()
  //  try {
  //    w.write(bibleJSON.toString)
  //    w.close
  //  } catch {
  //    case e: IOException => e.printStackTrace
  //  }

  //  println(s"bibleJSON=$bibleJSON")

}


