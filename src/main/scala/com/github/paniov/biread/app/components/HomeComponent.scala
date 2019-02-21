package com.github.paniov.biread.app.components

import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{NavigateBack}
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._

object HomeComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = div(classes += "home",
    h3("BiRead app"),
    div(classes += "content",
      p("It is a Home page of BiRead app")),
    button(DOMEventTypes.Click → backEventHandler, "go back"),
  )

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)

}