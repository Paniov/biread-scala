package com.github.paniov.biread.app

import java.time.LocalDate

//import com.github.nechaevv.isomorphic.example.model.Hero

//case class HeroesLoadEvent(heroes: Seq[Hero])
//
//case class NavigateToHeroDetail(heroId: Int)
//
//case class NewHeroNameChange(name: String)
//
//case object SaveNewHero
//
//case class DeleteHero(heroId: Int)

case object NavigateToHome

case object NavigateToHowto

case object NavigateToContacts

//case class HeroDetailLoadEvent(heroDetail: Hero)
//
//case object NavigateToHeroes

case object NavigateBack

case object CurrentDate

case object PrevDate

case object NextDate

case class PrevDateEvent(date: LocalDate)

case class CurrentDateEvent(date: LocalDate)

case class NextDateEvent(date: LocalDate)

//case class SearchHeroes(search: String)
//
//case class HeroesSearchResult(result: Seq[Hero])
//
//case class HeroDetailNameChange(name: String)
//
//case object HeroDetailSave
//
//case class AddMessage(message: String)
//
//case object ClearMessages