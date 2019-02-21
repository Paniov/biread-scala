package com.github.paniov.biread.app.components

import com.github.paniov.biread.app._
import com.github.paniov.biread.app.model.BireadAppState
import com.github.nechaevv.isomorphic.router.Route
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._

import AppRoutes._

object AppComponent extends Component[BireadAppState, FragmentVNode] {
  override def apply(state: BireadAppState): FragmentVNode = fragment(
    nav(
      a('href := "#", DOMEventTypes.Click → goHomeEventHandler, "Home"),
      a('href := "#", DOMEventTypes.Click → goHowtoEventHandler, "How To"),
      a('href := "#", DOMEventTypes.Click → goContactsEventHandler, "Contacts"),
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