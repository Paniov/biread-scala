package com.github.paniov.biread.app.components

import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._
import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{CurrentDate, NavigateBack, NextDate, PrevDate, bibleJSON}
import com.github.paniov.biread.app.utils.Utils._

object HomeComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = div(classes += "home",
    h3("BiRead app"),
    div(classes += "content",
      p("It is a Home page of BiRead app"),
      p(getDateString(state.currentDate)),
      p(getQuoteString(state.currentDate))
    ),

    div(
      button(DOMEventTypes.Click → prevDateEventHandler, "-"),
      button(DOMEventTypes.Click → currentDateEventHandler, "Reading today"),
      button(DOMEventTypes.Click → nextDateEventHandler, "+"),
    ),

    button(DOMEventTypes.Click → backEventHandler, "go back")
  )

  val prevDateEventHandler: EventHandler = e ⇒ fs2.Stream(PrevDate)
  val currentDateEventHandler: EventHandler = e ⇒ fs2.Stream(CurrentDate)
  val nextDateEventHandler: EventHandler = e ⇒ fs2.Stream(NextDate)

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)

}