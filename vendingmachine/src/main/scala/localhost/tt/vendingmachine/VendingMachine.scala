package localhost.tt.vendingmachine

import scala.collection.mutable

case class VendingMachine() {
  var merchandiseInventory = mutable.HashMap.empty[String, Int]
  var monetaryBalance: Double = 0.0

  def addMerchandise(sku: String, quantity: Int): Unit = {
    merchandiseInventory += (sku -> quantity)
  }
}
