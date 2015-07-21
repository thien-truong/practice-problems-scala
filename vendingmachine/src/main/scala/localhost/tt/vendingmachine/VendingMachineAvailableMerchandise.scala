package localhost.tt.vendingmachine

import scala.collection.mutable

case class VendingMachineAvailableMerchandise() {
  var availableMerchandise = mutable.HashMap.empty[String, MerchandiseStock]
  var monetaryBalance: Double = 30.0

  def getMerchandise(merchandiseCode: String): Option[Unit] = {

    if (availableMerchandise.contains(merchandiseCode.toUpperCase)) {
      val merchandiseStock: MerchandiseStock = availableMerchandise.apply(merchandiseCode)
      return Some(merchandiseStock.merchandise)
    }

    Option.empty
  }

  def addMerchandise(merchandiseCode: String, merchandise: Merchandise, quantity: Int): VendingMachineAvailableMerchandise = {
    val upperCasedMerchandiseCode: String = merchandiseCode.toUpperCase

    if (availableMerchandise.contains(upperCasedMerchandiseCode)) {
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

  def reduceMerchandise(merchandiseCode: String, quantity: Int): VendingMachineAvailableMerchandise = {
    val upperCasedMerchandiseCode: String = merchandiseCode.toUpperCase

    if (availableMerchandise.contains(upperCasedMerchandiseCode)) {
      val merchandiseStock: MerchandiseStock = availableMerchandise.apply(merchandiseCode)
      merchandiseStock.reduceQuantity(quantity)

      if (merchandiseStock.quantity < quantity) {
        throw new NegativeQuantityException(s"There are only ${merchandiseStock.quantity} items of " +
          s"merchandise code $upperCasedMerchandiseCode available. Reducing $quantity will result" +
          s"in negative inventory")
      }

      if (merchandiseStock.quantity == 0) {
        removeMerchandise(upperCasedMerchandiseCode)
      }

    }

    this
  }

  def removeMerchandise(merchandiseCode: String): VendingMachineAvailableMerchandise = {
    availableMerchandise.remove(merchandiseCode.toUpperCase)
    this
  }

}

