package localhost.tt.vendingmachine

case class MerchandiseStock(merchandise: Merchandise, var quantity: Int ) {
  def addQuantity(quantity: Int) = {this.quantity += quantity}
}
