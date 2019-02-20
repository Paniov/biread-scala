package com.github.paniov.bireadscala.app.model

import com.github.nechaevv.isomorphic.router.Route
import monocle.macros.Lenses

@Lenses
case class BireadAppState
(
  route: Route,
//  heroes: Seq[Hero],
//  detail: Option[HeroDetailState],
//  search: HeroSearchState,
//  newHeroName: String,
//  messages: Seq[String]
)