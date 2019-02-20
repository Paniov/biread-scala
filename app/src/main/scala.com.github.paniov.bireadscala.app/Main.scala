package com.github.paniov.bireadscala.app

import com.github.nechaevv.isomorphic.webcomponent.CustomElements

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

object Main {
  @JSExportTopLevel("boot")
  def boot(): Unit = {
    CustomElements.define(BireadApp, js.constructorOf[TasksAppStatefulHostCustomElement])
  }
}