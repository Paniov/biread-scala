package com.github.paniov.biread.app.model

import java.time.LocalDate

import com.github.nechaevv.isomorphic.router.Route
import monocle.macros.Lenses

@Lenses
case class BireadAppState
(
  route: Route,
  currentDate: LocalDate
  //  heroes: Seq[Hero],
  //  detail: Option[HeroDetailState],
  //  search: HeroSearchState,
  //  newHeroName: String,
  //  messages: Seq[String]
)