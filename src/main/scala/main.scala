package de.dragonrex

import de.dragonrex.options.Options

import java.awt.Color
import java.awt.event.ActionEvent
@main
def main(): Unit = {
  val window = Window(
    Options()
      .add("title", "My Window")
      .add("width", 500)
      .add("height", 500)
      .add("icon", "data/one.png")
  )
  window.create()
  window.button(
    "Btn-One",
    Options()
    .add("x-pos", 150)
    .add("y-pos", 150)
    .add("width", 250)
    .add("height", 100)
    .add("tool-tip", "Next")
    .add("icon", "data/one.png"),
    button
  )
}

def button(btn_id: String, event: ActionEvent): Unit = {
  println(btn_id)
}