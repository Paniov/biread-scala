package com.github.paniov.biread.app.components

import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._
import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{CurrentDate, NavigateBack, NextDate, PrevDate, bibleJSON}
import com.github.paniov.biread.app.utils.Utils._

object HomeComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = {
    div(classes += "home d-flex flex-column",
      div(classes += "d-flex justify-content-center page-title", p("Read The New Testament In a Year")),
      div(classes += "d-flex justify-content-center quote-string", h2(getQuoteString(state.currentDate))),

      div(classes += "d-flex flex-column date-container",
        div(classes += "d-flex justify-content-center", p(getDateString(state.currentDate))),
        div(classes += "d-flex justify-content-center ",
          button(classes += "btn btn-secondary btn-xs square", DOMEventTypes.Click → prevDateEventHandler, "-"),
          button(classes += "btn btn-secondary btn-xs read-today", DOMEventTypes.Click → currentDateEventHandler, "Reading today"),
          button(classes += "btn btn-secondary btn-xs square", DOMEventTypes.Click → nextDateEventHandler, "+"),
        )
      )

//      div(classes += "d-block",
//        button(DOMEventTypes.Click → backEventHandler, "go back")
//      )
    )
  }


  val prevDateEventHandler: EventHandler = e ⇒ fs2.Stream(PrevDate)
  val currentDateEventHandler: EventHandler = e ⇒ fs2.Stream(CurrentDate)
  val nextDateEventHandler: EventHandler = e ⇒ fs2.Stream(NextDate)

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)

}