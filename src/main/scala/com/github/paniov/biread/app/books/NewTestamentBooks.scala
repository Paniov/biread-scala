package com.github.paniov.biread.app.books

import com.github.paniov.biread.app._
import com.github.paniov.biread.app.model.{Book, Chapter}

object NewTestamentBooks {

  //25,23,17,25,48,34,29,34,38,42,30,50,58,36,39,28,27,35,30,34,46,46,39,51,46,75,66,20
  val ntMatthew = Book(Matthew, Gospel, New,
    Seq(
      Chapter(1, 25, Seq(), ""),
      Chapter(2, 23, Seq(), ""),
      Chapter(3, 17, Seq(), ""),
      Chapter(4, 25, Seq(), ""),
      Chapter(5, 48, Seq(27), ""),
      Chapter(6, 34, Seq(19), ""),
      Chapter(7, 29, Seq(), ""),
      Chapter(8, 34, Seq(18), ""),
      Chapter(9, 38, Seq(18), ""),
      Chapter(10, 42, Seq(21), ""),
      Chapter(11, 30, Seq(), ""),
      Chapter(12, 50, Seq(24), ""),
      Chapter(13, 58, Seq(31), ""),
      Chapter(14, 36, Seq(22), ""),
      Chapter(15, 39, Seq(21), ""),
      Chapter(16, 28, Seq(), ""),
      Chapter(17, 27, Seq(), ""),
      Chapter(18, 35, Seq(21), ""),
      Chapter(19, 30, Seq(), ""),
      Chapter(20, 34, Seq(17), ""),
      Chapter(21, 46, Seq(23), ""),
      Chapter(22, 46, Seq(23), ""),
      Chapter(23, 39, Seq(23), ""),
      Chapter(24, 51, Seq(29), ""),
      Chapter(25, 46, Seq(31), ""),
      Chapter(26, 75, Seq(26, 51), ""),
      Chapter(27, 66, Seq(27, 51), ""),
      Chapter(28, 20, Seq(), "")
    )
  )

  //45,28,35,41,43,56,37,38,50,52,33,44,37,72,47,20
  val ntMark = Book(Mark, Gospel, New,
    Seq(
      Chapter(1, 45, Seq(23), ""),
      Chapter(2, 28, Seq(), ""),
      Chapter(3, 35, Seq(20), ""),
      Chapter(4, 41, Seq(21), ""),
      Chapter(5, 43, Seq(21), ""),
      Chapter(6, 56, Seq(30), ""),
      Chapter(7, 37, Seq(), ""),
      Chapter(8, 38, Seq(22), ""),
      Chapter(9, 50, Seq(30), ""),
      Chapter(10, 52, Seq(32), ""),
      Chapter(11, 33, Seq(19), ""),
      Chapter(12, 44, Seq(28), ""),
      Chapter(13, 37, Seq(21), ""),
      Chapter(14, 72, Seq(27, 54), ""),
      Chapter(15, 47, Seq(26), ""),
      Chapter(16, 20, Seq(), "") //TODO check it
    )
  )

  //80,52,38,44,39,49,50,56,62,42,54,59,35,35,32,31,37,43,48,47,38,71,56,53
  val ntLuke = Book(Luke, Gospel, New,
    Seq(
      Chapter(1, 80, Seq(), ""),
      Chapter(2, 52, Seq(), ""),
      Chapter(3, 38, Seq(), ""),
      Chapter(4, 44, Seq(), ""),
      Chapter(5, 39, Seq(), ""),
      Chapter(6, 49, Seq(), ""),
      Chapter(7, 50, Seq(), ""),
      Chapter(8, 56, Seq(), ""),
      Chapter(9, 62, Seq(), ""),
      Chapter(10, 42, Seq(), ""),
      Chapter(11, 54, Seq(), ""),
      Chapter(12, 59, Seq(), ""),
      Chapter(13, 35, Seq(), ""),
      Chapter(14, 35, Seq(), ""),
      Chapter(15, 32, Seq(), ""),
      Chapter(16, 31, Seq(), ""),
      Chapter(17, 37, Seq(), ""),
      Chapter(18, 43, Seq(), ""),
      Chapter(19, 48, Seq(), ""),
      Chapter(20, 47, Seq(), ""),
      Chapter(21, 38, Seq(), ""),
      Chapter(22, 71, Seq(), ""),
      Chapter(23, 56, Seq(), ""),
      Chapter(24, 53, Seq(), "")
    )
  )

  //51,25,36,54,47,71,53*,59*,41,42,57,50,38,31,27,33,26,40,42,31,25
  val ntJohn = Book(John, Gospel, New,
    Seq(
      Chapter(1, 51, Seq(), ""),
      Chapter(2, 25, Seq(), ""),
      Chapter(3, 36, Seq(), ""),
      Chapter(4, 54, Seq(), ""),
      Chapter(5, 47, Seq(), ""),
      Chapter(6, 71, Seq(), ""),
      Chapter(7, 53, Seq(), ""), //TODO check it
      Chapter(8, 59, Seq(), ""), //TODO check it
      Chapter(9, 41, Seq(), ""),
      Chapter(10, 42, Seq(), ""),
      Chapter(11, 57, Seq(), ""),
      Chapter(12, 50, Seq(), ""),
      Chapter(13, 38, Seq(), ""),
      Chapter(14, 31, Seq(), ""),
      Chapter(15, 27, Seq(), ""),
      Chapter(16, 33, Seq(), ""),
      Chapter(17, 26, Seq(), ""),
      Chapter(18, 40, Seq(), ""),
      Chapter(19, 42, Seq(), ""),
      Chapter(20, 31, Seq(), ""),
      Chapter(21, 25, Seq(), "")
    )
  )

  //26,47,26,37,42,15,60,40,43,48,30,25,52,28,41,40,34,28,40*,38,40,30,35,27,27,32,44,31
  val ntActs = Book(Acts, Gospel, New,
    Seq(
      Chapter(1, 26, Seq(), ""),
      Chapter(2, 47, Seq(), ""),
      Chapter(3, 26, Seq(), ""),
      Chapter(4, 37, Seq(), ""),
      Chapter(5, 42, Seq(), ""),
      Chapter(6, 15, Seq(), ""),
      Chapter(7, 60, Seq(), ""),
      Chapter(8, 40, Seq(), ""),
      Chapter(9, 43, Seq(), ""),
      Chapter(10, 48, Seq(), ""),
      Chapter(11, 30, Seq(), ""),
      Chapter(12, 25, Seq(), ""),
      Chapter(13, 52, Seq(), ""),
      Chapter(14, 28, Seq(), ""),
      Chapter(15, 41, Seq(), ""),
      Chapter(16, 40, Seq(), ""),
      Chapter(17, 34, Seq(), ""),
      Chapter(18, 28, Seq(), ""),
      Chapter(19, 40, Seq(), ""), //TODO check it
      Chapter(20, 38, Seq(), ""),
      Chapter(21, 40, Seq(), ""),
      Chapter(22, 30, Seq(), ""),
      Chapter(23, 35, Seq(), ""),
      Chapter(24, 27, Seq(), ""),
      Chapter(25, 27, Seq(), ""),
      Chapter(26, 32, Seq(), ""),
      Chapter(27, 44, Seq(), ""),
      Chapter(28, 31, Seq(), "")
    )
  )

  //32,29,31,25,21,23,25,39,33,21,36,21,14,23,33,27
  val ntRomans = Book(Romans, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 32, Seq(), ""),
      Chapter(2, 29, Seq(), ""),
      Chapter(3, 31, Seq(), ""),
      Chapter(4, 25, Seq(), ""),
      Chapter(5, 21, Seq(), ""),
      Chapter(6, 23, Seq(), ""),
      Chapter(7, 25, Seq(), ""),
      Chapter(8, 39, Seq(), ""),
      Chapter(9, 33, Seq(), ""),
      Chapter(10, 21, Seq(), ""),
      Chapter(11, 36, Seq(), ""),
      Chapter(12, 21, Seq(), ""),
      Chapter(13, 14, Seq(), ""),
      Chapter(14, 23, Seq(), ""),
      Chapter(15, 33, Seq(), ""),
      Chapter(16, 27, Seq(), "")
    )
  )

  //31,16,23,21,13,20,40,13,27,33,34,31,13,40,58,24
  val ntCorinthians1 = Book(Corinthians1, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 31, Seq(), ""),
      Chapter(2, 16, Seq(), ""),
      Chapter(3, 23, Seq(), ""),
      Chapter(4, 21, Seq(), ""),
      Chapter(5, 13, Seq(), ""),
      Chapter(6, 20, Seq(), ""),
      Chapter(7, 40, Seq(), ""),
      Chapter(8, 13, Seq(), ""),
      Chapter(9, 27, Seq(), ""),
      Chapter(10, 33, Seq(), ""),
      Chapter(11, 34, Seq(), ""),
      Chapter(12, 31, Seq(), ""),
      Chapter(13, 13, Seq(), ""),
      Chapter(14, 40, Seq(), ""),
      Chapter(15, 58, Seq(), ""),
      Chapter(16, 24, Seq(), "")
    )
  )

  //24,17,18,18,21,18,16,24,15,18,33,21,13
  val ntCorinthians2 = Book(Corinthians2, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 24, Seq(), ""),
      Chapter(2, 17, Seq(), ""),
      Chapter(3, 18, Seq(), ""),
      Chapter(4, 18, Seq(), ""),
      Chapter(5, 21, Seq(), ""),
      Chapter(6, 18, Seq(), ""),
      Chapter(7, 16, Seq(), ""),
      Chapter(8, 24, Seq(), ""),
      Chapter(9, 15, Seq(), ""),
      Chapter(10, 18, Seq(), ""),
      Chapter(11, 33, Seq(), ""),
      Chapter(12, 21, Seq(), ""),
      Chapter(13, 13, Seq(), "")
    )
  )

  //24,21,29,31,26,18
  val ntGalatians = Book(Galatians, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 24, Seq(), ""),
      Chapter(2, 21, Seq(), ""),
      Chapter(3, 29, Seq(), ""),
      Chapter(4, 31, Seq(), ""),
      Chapter(5, 26, Seq(), ""),
      Chapter(6, 18, Seq(), "")
    )
  )

  //23,22,21,32,33,24
  val ntEphesians = Book(Ephesians, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 23, Seq(), ""),
      Chapter(2, 22, Seq(), ""),
      Chapter(3, 21, Seq(), ""),
      Chapter(4, 32, Seq(), ""),
      Chapter(5, 33, Seq(), ""),
      Chapter(6, 24, Seq(), "")
    )
  )

  //30,30,21,23
  val ntPhilippians = Book(Philippians, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 30, Seq(), ""),
      Chapter(2, 30, Seq(), ""),
      Chapter(3, 21, Seq(), ""),
      Chapter(4, 23, Seq(), "")
    )
  )

  //29,23,25,18
  val ntColossians = Book(Colossians, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 29, Seq(), ""),
      Chapter(2, 23, Seq(), ""),
      Chapter(3, 25, Seq(), ""),
      Chapter(4, 18, Seq(), "")
    )
  )

  //10,20,13,18,28
  val ntThessalonians1 = Book(Thessalonians1, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 10, Seq(), ""),
      Chapter(2, 20, Seq(), ""),
      Chapter(3, 13, Seq(), ""),
      Chapter(4, 18, Seq(), ""),
      Chapter(5, 28, Seq(), "")
    )
  )

  //12,17,18
  val ntThessalonians2 = Book(Thessalonians2, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 12, Seq(), ""),
      Chapter(2, 17, Seq(), ""),
      Chapter(3, 18, Seq(), "")
    )
  )

  //20,15,16,16,25,21
  val ntTimothy1 = Book(Timothy1, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 20, Seq(), ""),
      Chapter(2, 15, Seq(), ""),
      Chapter(3, 16, Seq(), ""),
      Chapter(4, 16, Seq(), ""),
      Chapter(5, 25, Seq(), ""),
      Chapter(6, 21, Seq(), "")
    )
  )

  //18,26,17,22
  val ntTimothy2 = Book(Timothy2, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 18, Seq(), ""),
      Chapter(2, 26, Seq(), ""),
      Chapter(3, 17, Seq(), ""),
      Chapter(4, 22, Seq(), "")
    )
  )

  //6,15,15
  val ntTitus = Book(Titus, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 6, Seq(), ""),
      Chapter(2, 15, Seq(), ""),
      Chapter(3, 15, Seq(), "")
    )
  )

  //25
  val ntPhilemon = Book(Philemon, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 25, Seq(), "")
    )
  )

  //14,18,19,16,14,20,28,13,28,39,40,29,25
  val ntHebrews = Book(Hebrews, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 14, Seq(), ""),
      Chapter(2, 18, Seq(), ""),
      Chapter(3, 19, Seq(), ""),
      Chapter(4, 16, Seq(), ""),
      Chapter(5, 14, Seq(), ""),
      Chapter(6, 20, Seq(), ""),
      Chapter(7, 28, Seq(), ""),
      Chapter(8, 13, Seq(), ""),
      Chapter(9, 28, Seq(), ""),
      Chapter(10, 39, Seq(), ""),
      Chapter(11, 40, Seq(), ""),
      Chapter(12, 29, Seq(), ""),
      Chapter(13, 25, Seq(), "")
    )
  )

  //27,26,18,17,20
  val ntJames = Book(James, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 27, Seq(), ""),
      Chapter(2, 26, Seq(), ""),
      Chapter(3, 18, Seq(), ""),
      Chapter(4, 17, Seq(), ""),
      Chapter(5, 20, Seq(), "")
    )
  )

  //25,25,22,19,14
  val ntPeter1 = Book(Peter1, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 25, Seq(), ""),
      Chapter(2, 25, Seq(), ""),
      Chapter(3, 22, Seq(), ""),
      Chapter(4, 19, Seq(), ""),
      Chapter(5, 14, Seq(), "")
    )
  )

  //21,22,18
  val ntPeter2 = Book(Peter2, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 21, Seq(), ""),
      Chapter(2, 22, Seq(), ""),
      Chapter(3, 18, Seq(), "")
    )
  )

  //10,29,24,21,21
  val ntJohn1 = Book(John1, EpistlesOfPaul, New,
    Seq(
      Chapter(1, 10, Seq(), ""),
      Chapter(2, 29, Seq(), ""),
      Chapter(3, 24, Seq(), ""),
      Chapter(4, 21, Seq(), ""),
      Chapter(5, 21, Seq(), "")
    )
  )

  //13
  val ntJohn2 = Book(John2, EpistlesOfPaul, New, Seq(Chapter(1, 13, Seq(), "")))

  //15
  val ntJohn3 = Book(John3, EpistlesOfPaul, New, Seq(Chapter(1, 15, Seq(), "")))

  //25
  val ntJude = Book(Jude, EpistlesOfPaul, New, Seq(Chapter(1, 25, Seq(), "")))

  //20,29,22,11,14,17,17,13,21,11,19,17,18,20,8,21,18,24,21,15,27,21
  val ntRevelation = Book(Revelation, Gospel, New,
    Seq(
      Chapter(1, 20, Seq(), ""),
      Chapter(2, 29, Seq(), ""),
      Chapter(3, 22, Seq(), ""),
      Chapter(4, 11, Seq(), ""),
      Chapter(5, 14, Seq(), ""),
      Chapter(6, 17, Seq(), ""),
      Chapter(7, 17, Seq(), ""),
      Chapter(8, 13, Seq(), ""),
      Chapter(9, 21, Seq(), ""),
      Chapter(10, 11, Seq(), ""),
      Chapter(11, 19, Seq(), ""),
      Chapter(12, 17, Seq(), ""),
      Chapter(13, 18, Seq(), ""),
      Chapter(14, 20, Seq(), ""),
      Chapter(15, 8, Seq(), ""),
      Chapter(16, 21, Seq(), ""),
      Chapter(17, 18, Seq(), ""),
      Chapter(18, 24, Seq(), ""),
      Chapter(19, 21, Seq(), ""),
      Chapter(20, 15, Seq(), ""),
      Chapter(21, 27, Seq(), ""),
      Chapter(22, 21, Seq(), "")
    )
  )

}