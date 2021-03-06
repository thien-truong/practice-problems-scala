package localhost.tt.vendingmachine

import scala.collection.mutable

case class VendingMachineAvailableMerchandise() {

  var availableMerchandise = mutable.HashMap.empty[String, MerchandiseStock]
  var monetaryBalance: Double = 30.0

  def resetCashBalanceAfterPurchase(priceOfMerchandiseSold: Double): Unit = {
    monetaryBalance += priceOfMerchandiseSold
  }

  def getMerchandise(merchandiseCode: String): Option[Merchandise] = {

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

      if (merchandiseStock.quantity < quantity) {
        throw new NegativeQuantityException(s"There are only ${merchandiseStock.quantity} items of " +
          s"merchandise code $upperCasedMerchandiseCode available. Reducing $quantity will result" +
          s"in negative inventory")
      }

      merchandiseStock.reduceQuantity(quantity)

      if (merchandiseStock.quantity == 0) {
        removeMerchandise(upperCasedMerchandiseCode)
      }

    }

    this
  }

  private def removeMerchandise(merchandiseCode: String): VendingMachineAvailableMerchandise = {
    availableMerchandise.remove(merchandiseCode.toUpperCase)
    this
  }

  def displayAvailableMerchandise(): Unit = {
    println("Code      Name             Price      Quantity")
    availableMerchandise.foreach{ case(key, value) => println(
      f"$key%-9s " +
      f"${value.merchandise.merchandiseName}%-9s " +
      f"${value.merchandise.retailPrice}%11.2f " +
      f"${value.quantity}%7d")
    }
  }

}

