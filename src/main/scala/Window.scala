package de.dragonrex

import de.dragonrex.options.Options

import java.awt.{Color, Component, Dimension}
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.*

class Window(opt: Options) extends JFrame() {

    // ########################################################   Window Component   ########################################################
    def create(): Unit = {
      if(opt.is("title"))
        setTitle(opt.get("title").asInstanceOf[String])
      if(opt.is("width") && opt.is("height"))
        setPreferredSize(Dimension(
          if (opt.get("width").asInstanceOf[Int] <= 0) 1200 else opt.get("width").asInstanceOf[Int],
          if (opt.get("height").asInstanceOf[Int] <= 0) 800 else opt.get("height").asInstanceOf[Int]
        ))
      if(opt.is("icon"))
        setIconImage(ImageIcon(opt.get("icon").asInstanceOf[String]).getImage)  
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
      pack()
      setLocationRelativeTo(null)
      setLayout(null)
      setVisible(true)
    }
    // ########################################################   Window Component End   ####################################################
    
    
    
    // ########################################################   Button Component   ########################################################
    def button(id: String, opt: Options, func: (btn_id: String, event: ActionEvent) => Unit): Pair[String, JButton] = {
      var button = JButton()
      button.addActionListener((e: ActionEvent) => func(id, e))
      button.setFocusPainted(false)
      if(opt.is("text")) {
        button.setText(opt.get("text").asInstanceOf[String])
      }
      if(opt.is("x-pos") && opt.is("y-pos") && opt.is("width") && opt.is("height")) {
        button.setBounds(
          opt.get("x-pos").asInstanceOf[Int], 
          opt.get("y-pos").asInstanceOf[Int], 
          opt.get("width").asInstanceOf[Int],
          opt.get("height").asInstanceOf[Int]
        )
      }
      if(opt.is("tool-tip")) {
        button.setToolTipText(opt.get("tool-tip").asInstanceOf[String])
      }
      if(opt.is("icon")) {
        button.setIcon(ImageIcon(opt.get("icon").asInstanceOf[String]))
      }
      if(opt.is("bg-color")) {
        button.setBackground(opt.get("bg-color").asInstanceOf[Color])
      }
      if(opt.is("fg-color")) {
        button.setForeground(opt.get("fg-color").asInstanceOf[Color])
      }
      this.add(button)
      this.invalidate()
      this.validate()
      this.repaint()
      return Pair[String, JButton](id, button)
    }
    // ########################################################   Button Component End   #####################################################
    
    
}
