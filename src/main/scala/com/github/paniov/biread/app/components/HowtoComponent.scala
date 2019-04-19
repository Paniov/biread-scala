package com.github.paniov.biread.app.components

import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{NavigateBack}
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._

object HowtoComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = div(classes += "howto",
    h3("Learn how to do your daily reading of the Bible"),
    div(classes += "content",
      p(classes += "slogan", "Watch your life and doctrine closely. " +
        "Persevere in them, because if you do, you will save both yourself and your hearers. " +
        "1 Timothy 4:16"),
      button(DOMEventTypes.Click → backEventHandler, "go back")
    )
  )

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)
}