package com.github.paniov.biread.app

import com.github.nechaevv.isomorphic.webcomponent.{CustomElements, DelegatedCustomElement}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

object Main {
  @JSExportTopLevel("boot")
  def boot(): Unit = {
    CustomElements.define(BireadApp, js.constructorOf[TasksAppStatefulHostCustomElement])
  }
}

class TasksAppStatefulHostCustomElement extends DelegatedCustomElement(BireadApp.customElementDelegate)
