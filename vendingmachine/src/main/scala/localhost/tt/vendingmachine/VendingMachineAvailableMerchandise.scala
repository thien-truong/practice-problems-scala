package localhost.tt.vendingmachine

import scala.collection.mutable

case class VendingMachineAvailableMerchandise() {

  var availableMerchandise = mutable.HashMap.empty[String, MerchandiseStock]
  var monetaryBalance: Double = 30.0

  def addMerchandise(merchandiseCode: String, merchandise: Merchandise, quantity: Int): VendingMachineAvailableMerchandise = {
    val upperCasedMerchandiseCode: String = merchandiseCode.toUpperCase

    if (availableMerchandise.contains(merchandiseCode)) {
      val merchandiseStock: MerchandiseStock = availableMerchandise.apply(merchandiseCode)

      if (merchandiseStock.merchandise != merchandise) {
        throw new IllegalArgumentException("Merchandise name or retail price does not match the merchandise " +
          "in existing available merchandise. Cannot add.")
      }

      merchandiseStock.addQuantity(quantity)
    } else {
      val merchandiseStock: MerchandiseStock = new MerchandiseStock(merchandise, quantity)
      availableMerchandise += (upperCasedMerchandiseCode -> merchandiseStock)
    }

    this
  }

//  def reduceMerchandise(merchandiseCode: String, quantity: Int): Unit = {
//
//  }

//  def removeMerchandise(merchandiseCode: String): Unit = {
//    availableMerchandise.remove(merchandiseCode)
//  }

}

