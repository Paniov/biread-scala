package com.github.paniov.biread.app.components

import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{NavigateBack}
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._
import org.scalajs.dom.raw.HTMLInputElement

object HowtoComponent extends Component[BireadAppState, ElementVNode] {
  override def apply(state: BireadAppState): ElementVNode = div(classes += "howto",
    h2("How To"),
//    div(span("id: "), state.hero.id.toString),
//    div(
//      label("name: ",
//        input('placeholder := "name", 'value := state.heroName, DOMEventTypes.Change → nameChangeEventHandler)
//      )
//    ),
    button(DOMEventTypes.Click → backEventHandler, "go back"),
//    button(DOMEventTypes.Click → saveEventHandler, "save"),
  )
//  val nameChangeEventHandler: EventHandler = e ⇒ fs2.Stream(HeroDetailNameChange(e.target.asInstanceOf[HTMLInputElement].value))
//  val saveEventHandler: EventHandler = e ⇒ fs2.Stream(HeroDetailSave)
  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)
}