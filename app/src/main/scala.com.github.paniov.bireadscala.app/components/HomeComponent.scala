package com.github.paniov.bireadscala.app.components

import com.github.paniov.bireadscala.app.model.HeroesAppState
import com.github.nechaevv.isomorphic.vdom._
import browser._
import tags._


object DashboardComponent extends Component[BireadAppState, ElementVNode] {
  override def apply(state: BireadAppState): ElementVNode = div(classes += "home",
    h3("Biread app"),
    div(classes += "grid grid-pad")//(
//      for (hero ← state.heroes.take(4)) yield a.withKey(hero.id.toString)('href := "#", classes += "col-1-4", DOMEventTypes.Click → NavigateToDetailEventHandler(hero.id),
//        div(classes += "module hero",
//          h4(hero.name)
//        )
//      )
//    )
  )
}