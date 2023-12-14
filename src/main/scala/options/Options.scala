package de.dragonrex
package options

class Options {
  var map: Map[String, Any] = Map[String, Any]()

  def add(key: String, value: Any): Options = {
    map += (key, value)
    return this
  }
  
  def get(key: String): Any = {
    return map.apply(key)
  }
  
  def is(key: String): Boolean = {
    return map.exists(x => x._1.eq(key))
  }
  
  def rm(key: String): Unit = {
    map -= key
  }
}
