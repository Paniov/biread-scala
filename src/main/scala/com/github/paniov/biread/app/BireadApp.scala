package com.github.paniov.biread.app

import com.github.nechaevv.isomorphic.{AutonomousCustomElement, ActionStream, combineEffects, combineReducers}
import com.github.paniov.biread.app.components.AppComponent
import com.github.paniov.biread.app.model.{BireadAppState}
import com.github.nechaevv.isomorphic.router.{Router, RouterSupport}
import com.github.nechaevv.isomorphic.webcomponent.{DomReconcilerRender, StatefulHostComponent, StatefulHostElementDelegate}
import org.scalajs.dom.raw.HTMLElement

object BireadApp extends StatefulHostComponent with AutonomousCustomElement with DomReconcilerRender {

  override type State = BireadAppState

  override def elementName: String = "app-biread"

  override def rootComponent: AppComponent.type = AppComponent

  override def initialState(properties: Iterable[(String, String)]): State = BireadAppState(
    route = Router.currentRoute,
//    heroes = Nil,
//    detail = None,
//    search = HeroSearchState("", Nil),
//    newHeroName = "",
//    messages = Nil
  )

  override def customElementDelegate(componentHost: HTMLElement): StatefulHostElementDelegate = {
    new StatefulHostElementDelegate(this, componentHost) with RouterSupport
  }

  override val reducer: Any ⇒ BireadAppState ⇒ BireadAppState = combineReducers(AppReducers.reducer)

  override def effect: Any ⇒ BireadAppState ⇒ ActionStream = combineEffects(AppEffects.effect)

}