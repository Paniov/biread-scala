package com.github.paniov.biread.app.components

import io.circe.Json
import io.circe.syntax._
import io.circe.generic.auto._

//import com.github.paniov.biread.app.bibleJSON
import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{NavigateBack, bibleJSON}
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.write

//import scala.scalajs.js.JSON

object HomeComponent extends Component[BireadAppState, ElementVNode] {

  //  val foo = bibleJSON.toString
  //  implicit val formats = DefaultFormats
  //
  //  val bibleJSON = write(bible)
  //  println(bible)
  //  val bibleJson = bible.asJson
  //  println(bibleJson)

  //  val b: String = bibleJSON.toString()

  override def apply(state: BireadAppState): ElementVNode = div(classes += "home",
    h3("BiRead app"),
    div(classes += "content",
      //      p("It is a Home page of BiRead app"),
      p(bibleJSON.toString)
    ),
    button(DOMEventTypes.Click → backEventHandler, "go back"),
  )

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)

}