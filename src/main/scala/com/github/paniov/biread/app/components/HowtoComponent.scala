package com.github.paniov.biread.app.components

import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{NavigateBack}
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._

object HowtoComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = div(classes += "howto",
    h3("How To"),
    div(classes += "content",
      p("It is a How To page of BiRead app")),
    button(DOMEventTypes.Click → backEventHandler, "go back"),
  )

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)
}