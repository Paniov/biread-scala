package com.github.paniov.biread.app.components

import com.github.paniov.biread.app.model.BireadAppState
import com.github.paniov.biread.app.NavigateBack
import com.github.nechaevv.isomorphic.vdom._
import com.github.nechaevv.isomorphic.vdom.browser._
import com.github.nechaevv.isomorphic.vdom.tags._
import com.github.paniov.biread.app.utils.Utils.{getDateString, getQuoteString}

object HowtoComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = {
    div(classes += "howto",
      div(classes += "page-title", p("Learn To Read the Bible Daily")),
      div(classes += "",
        p(classes += "slogan cite", "Watch your life and doctrine closely. " +
          "Persevere in them, because if you do, you will save both yourself and your hearers. ",
          span(classes += "cite-ref", "1 Timothy 4:16")
        )
//        button(DOMEventTypes.Click → backEventHandler, "go back")
      ),

      div(classes += "d-flex justify-content-center card app-card ",
        div(classes += "card-body",
          h4(classes += "card-title", "1. Read"),
          p(classes += "card-text",
            "The daily reading of the Bible should be your habit! " +
              "It is your spiritual workout that you do no matter what. " +
              "The consistency is more important than the size of the text you read. " +
              "20 verses of the New Testament each day is a good start. " +
              "Here are the tips:"),
        ),
        ul(classes += "list-group list-group-flush",
          li(classes += "list-group-item", "Find 10-15 minutes in your daily routine for the reading."),
          li(classes += "list-group-item", "The best time is the morning."),
          li(classes += "list-group-item", "It can be during your breakfast or commuting."),
          li(classes += "list-group-item", "If you cannot read, than listen. But do it!"),
          li(classes += "list-group-item", "Even a weak reading is better, than nothing.")
        )
      ),

      div(classes += "d-flex justify-content-center card app-card ",
        div(classes += "card-body",
          h4(classes += "card-title", "2. Think"),
          p(classes += "card-text",
            "Think well of how the text you have read is applicable to YOUR life today and now. " +
              "If you cannot remember what you just have read, than 'Welcome to the Club!'. " +
              "It happens to everyone, so just go back and read it again. " +
              "Even the one truth that you captured from the text is a good catch for you today. " +
              "Remember that the text of the Bible has only one meaning, but many applications. "+
              "Questions below could direct you to these applications: "),
        ),
        ul(classes += "list-group list-group-flush",
          li(classes += "list-group-item", "Does the text helps me to know God better, so I can love Him even more?"),
          li(classes += "list-group-item", "Does the text points to the sin I have to confess? "),
          li(classes += "list-group-item", "Is there something I can use in my prayer? "),
          li(classes += "list-group-item", "Is there some challenges for my obedience to God? "),
          li(classes += "list-group-item", "How this truth may positively change my attitude and behaviour? "),
          li(classes += "list-group-item", "What do I say if someone ask me about the application of this text to my life? "),
        )
      ),

      div(classes += "d-flex justify-content-center card app-card ",
        div(classes += "card-body",
          h4(classes += "card-title", "3. Write"),
          p(classes += "card-text",
            "The writing will set your thoughts in order. " +
              "With the time you will learn to express yourself clearly. " +
              "You will collect a 'short & sweet' records for yourself and improve your skill of communication with others. " +
              "Do not try to write much. " +
              "Start from just one sentence of how you apply the text to yourself. " +
              "Here is the list of the feeble excuses for not to write: "),
        ),
        ul(classes += "list-group list-group-flush",
          li(classes += "list-group-item", "The people will laugh at me. "),
          li(classes += "list-group-item", "I did try once, but couldn't write even a sentence. "),
          li(classes += "list-group-item", "I am not a person of communication. "),
          li(classes += "list-group-item", "Everything I wrote looks very simple and not impressive. "),
        )
      ),

      div(classes += "d-flex justify-content-center card app-card ",
        div(classes += "card-body",
          h4(classes += "card-title", "4. Share"),
          p(classes += "card-text",
            "Share what you have learned with others. " +
              "Be ready to give either short or full overview. " +
              "Don't hesitate. Although you may be wrong or sound silly, " +
              "you will have a chance to correct and improve your view with the time. " +
              "Some ways of sharing: "),
        ),
        ul(classes += "list-group list-group-flush",
          li(classes += "list-group-item", "Share it with your spouse e.g. when you drive in the car. "),
          li(classes += "list-group-item", "Have a conversation with your kids e.g. during the hiking. "),
          li(classes += "list-group-item", "Talk to your friend e.g. during the lunch. "),
          li(classes += "list-group-item", "Share it in a small group e.g. in church or conference. "),
        )
      )
    )

//    1. Read the small portion of the Bible each day.
//    2. Think well of how it is aplicable to YOUR life today and now.
//    3. Discipline your mind in the way that you wiil be able to express clearly your application in one Twitt.
//    4. Pray to Jesus with what you've learned.
//    5. Don't give up


  }

  val backEventHandler: EventHandler = e ⇒ fs2.Stream(NavigateBack)
}