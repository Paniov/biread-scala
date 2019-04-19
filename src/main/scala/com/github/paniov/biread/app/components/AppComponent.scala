package com.github.paniov.biread.app.components

import com.github.paniov.biread.app._
import com.github.paniov.biread.app.model.BireadAppState
import com.github.nechaevv.isomorphic.router.Route
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._

import AppRoutes._

object AppComponent extends Component[BireadAppState, FragmentVNode] {

  val READ = "read"
  val LEARN = "learn"
  val INFO = "info"

  def routePred(r:Route): String = r match {
    case Route(homeRoute(_*), _, _) ⇒ READ
    case Route(howtoRoute(_*), _, _) ⇒ LEARN
    case Route(contactsRoute(_*), _, _) ⇒ INFO
    case _ ⇒ ""
  }

  def classPred(a: String)(b: String): String = if (a == b) "active" else ""

  def getStyleClass(s: String)(r:Route): String = (classPred(s)_ compose routePred)(r)

  override def apply(state: BireadAppState): FragmentVNode = fragment(

    nav(classes += "d-flex justify-content-center",
      a(classes += getStyleClass(READ)(state.route), 'href := "#", DOMEventTypes.Click → goHomeEventHandler, "Read"),
      a(classes += getStyleClass(LEARN)(state.route), 'href := "#", DOMEventTypes.Click → goHowtoEventHandler, "Learn"),
      a(classes += getStyleClass(INFO)(state.route), 'href := "#", DOMEventTypes.Click → goContactsEventHandler, "Info"),
    ),
    state.route match {
      case Route(homeRoute(_*), _, _) ⇒ Some(HomeComponent << state)
      case Route(howtoRoute(_*), _, _) ⇒ Some(HowtoComponent << state)
      case Route(contactsRoute(_*), _, _) ⇒ Some(ContactsComponent << state)
      case _ ⇒ None
    }
  )

  val goHomeEventHandler: EventHandler = e ⇒ {
    e.preventDefault()
    fs2.Stream(NavigateToHome)
  }
  val goHowtoEventHandler: EventHandler = e ⇒ {
    e.preventDefault()
    fs2.Stream(NavigateToHowto)
  }
  val goContactsEventHandler: EventHandler = e ⇒ {
    e.preventDefault()
    fs2.Stream(NavigateToContacts)
  }
}