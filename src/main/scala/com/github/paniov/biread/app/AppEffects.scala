package com.github.paniov.biread.app

import cats.effect.IO
import com.github.nechaevv.isomorphic.Effect
import com.github.paniov.biread.app.model.BireadAppState
import com.github.nechaevv.isomorphic.router.{Route, Router}
import com.github.nechaevv.isomorphic.webcomponent.ComponentConnectedEvent

import scala.language.implicitConversions

object AppEffects {
  implicit private def ioToStream[T](io: IO[T]): fs2.Stream[IO, T] = fs2.Stream.eval(io)

  val effect: Effect[BireadAppState] = {
    case ComponentConnectedEvent ⇒ s ⇒ {
      (
        if (s.route.path == "/")
          Router.navigate(Route("/read"))
        else
          Router.navigate(Route(s.route.path))
        )
    }

    case NavigateToHome ⇒ _ ⇒ Router.navigate(Route("/read"))
    case NavigateToHowto ⇒ _ ⇒ Router.navigate(Route("/learn"))
    case NavigateToContacts ⇒ _ ⇒ Router.navigate(Route("/info"))

    case NavigateBack ⇒ _ ⇒ Router.back()
    case PrevDate ⇒ s ⇒ fs2.Stream(PrevDateEvent(s.currentDate))
    case CurrentDate ⇒ s ⇒ fs2.Stream(CurrentDateEvent(s.currentDate))
    case NextDate ⇒ s ⇒ fs2.Stream(NextDateEvent(s.currentDate))

  }

}