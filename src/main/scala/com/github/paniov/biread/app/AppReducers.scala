package com.github.paniov.biread.app

import monocle.function.Possible.optionPossible
import com.github.nechaevv.isomorphic.Reducer
import com.github.paniov.biread.app.model.BireadAppState
//import com.github.nechaevv.isomorphic.example.model.{Hero, HeroDetailState, HeroSearchState, HeroesAppState}
import com.github.nechaevv.isomorphic.router.RouteChangeEvent

object AppReducers {
//  private val detailLens = HeroesAppState.detail composeOptional optionPossible.possible

  val reducer: Reducer[BireadAppState] = {
    case RouteChangeEvent(route) ⇒ BireadAppState.route.set(route)
//    case HeroesLoadEvent(heroes) ⇒ HeroesAppState.heroes.set(heroes)
//    case NavigateToHeroDetail(_) ⇒ HeroesAppState.detail.set(None)
//    case NewHeroNameChange(name) ⇒ HeroesAppState.newHeroName.set(name)
//    case HeroDetailLoadEvent(hero) ⇒ HeroesAppState.detail.set(Some(HeroDetailState(hero, hero.name)))
//    case HeroDetailNameChange(name) ⇒ detailLens.composeLens(HeroDetailState.heroName).set(name)
//    case HeroesSearchResult(searchResult) ⇒ (HeroesAppState.search composeLens HeroSearchState.searchResults).set(searchResult)
//    case AddMessage(message) ⇒ HeroesAppState.messages.modify(messages ⇒ message +: messages)
//    case ClearMessages ⇒ HeroesAppState.messages.set(Nil)
  }

}