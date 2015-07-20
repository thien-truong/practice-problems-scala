package localhost.tt.vendingmachine

case class MerchandiseStock(merchandise: Merchandise, quantity: Int ) {
  def addQuantity(quantity: Int): Unit = this.quantity + quantity
}
