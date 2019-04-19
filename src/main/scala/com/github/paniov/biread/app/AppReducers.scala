package com.github.paniov.biread.app

import com.github.nechaevv.isomorphic.Reducer
import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.utils.Utils._
import com.github.nechaevv.isomorphic.router.RouteChangeEvent

object AppReducers {

  val reducer: Reducer[BireadAppState] = {
    case RouteChangeEvent(route) ⇒ BireadAppState.route.set(route)
    case PrevDateEvent(date) ⇒ BireadAppState.currentDate.set(getPrevDate(date))
    case CurrentDateEvent(date) ⇒ BireadAppState.currentDate.set(getCurrentDate)
    case NextDateEvent(date) ⇒ BireadAppState.currentDate.set(getNextDate(date))
  }

}