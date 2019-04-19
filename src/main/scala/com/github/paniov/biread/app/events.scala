package com.github.paniov.biread.app

import java.time.LocalDate

case object NavigateToHome

case object NavigateToHowto

case object NavigateToContacts

case object NavigateBack

case object CurrentDate

case object PrevDate

case object NextDate

case class PrevDateEvent(date: LocalDate)

case class CurrentDateEvent(date: LocalDate)

case class NextDateEvent(date: LocalDate)