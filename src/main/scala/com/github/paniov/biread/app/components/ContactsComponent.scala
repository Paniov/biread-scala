package com.github.paniov.biread.app.components

import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.{NavigateBack}
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags.{a, _}
import com.github.nechaevv.isomorphic.vdom._

object ContactsComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = {

    div(classes += "info",
      div(classes += "page-title", "About this resource and me"),

      div(classes += "d-flex justify-content-center card app-card ",
        div(classes += "card-body",
          h4(classes += "card-title", "About this resource"),
          p(classes += "card-text",
            a('href := "https://github.com/Paniov/biread-scala", 'target := "_blank", "This webapp "),
            "is made on Scala with ",
            a('href := "https://github.com/nechaevv/isomorphic", 'target := "_blank", "Isomorphic framework. ")
          ),
          p(classes += "card-text", "Initially I was planning to implement the app in Haskell, PureScript or Elm as my " +
            "small functional exercise, " +
            "but I couldn't resist the temptation to give it a shot with a new Scala Webapp Framework made by my co-worker.")
        ),
      ),

      div(classes += "d-flex justify-content-center card app-card ",
        div(classes += "card-body",
          h4(classes += "card-title", "About me"),
          p(classes += "card-text", "My name is ",
            a('href := "https://www.linkedin.com/in/paniov/", 'target := "_blank", "Andriy. "),
            "I did this app in my spare time and I did it for two reasons: "),

          p("I want to help Christians to develop the habit of daily Bible reading. " +
              "I was taught how to do it by ",

            a('href := "http://www.wol.org/", 'target := "_blank", "Word of Life"),
            " 25 years ago and now I am happy to do the same for others. "
          ),
          p("I did this webapp because its efficiency is bigger than any other printed alternative and... " +
            "I need it for my daily use. ;)"
          )
        )
      )

    )

  }

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)

}
