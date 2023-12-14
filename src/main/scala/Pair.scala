package de.dragonrex

class Pair[KEY, VALUE](private var key: KEY, private var value: VALUE) {
  def getKey(): KEY = {
    return key
  }

  def setKey(newKey: KEY) = {
    this.key = newKey
  }

  def getValue(): VALUE = {
    return value
  }

  def setValue(newValue: VALUE) = {
    this.value = newValue
  }
}
