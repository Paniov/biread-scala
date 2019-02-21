package com.github.paniov.biread.app.components

import com.github.nechaevv.isomorphic.vdom.tags.{div, h3}
import com.github.nechaevv.isomorphic.vdom.{Component, ElementVNode, classes}
import com.github.paniov.biread.app.model.BireadAppState

object ContactsComponent extends Component[BireadAppState, ElementVNode] {

  override def apply(state: BireadAppState): ElementVNode = div(classes += "contacts",
    h3("Contacts"),
    div(classes += "grid grid-pad")
  )
}
