package localhost.tt.vendingmachine

import scala.collection.mutable

case class VendingMachineInventory() {
  var merchandiseInventory = mutable.HashMap.empty[String, Int]
  var monetaryBalance: Double = 0.0

  def addMerchandise(merchandiseCode: String, quantity: Int): Unit = {
    val maybeMerchandise: Option[(String, Int)] =
      merchandiseInventory.find{case (key, value) => key == merchandiseCode}

    if (maybeMerchandise.nonEmpty) {
      val newQuantity: Int = maybeMerchandise.get._2 + quantity
      merchandiseInventory += (merchandiseCode -> newQuantity)
    } else {
      merchandiseInventory += (merchandiseCode -> quantity)
    }

  }

}

