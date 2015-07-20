package localhost.tt.vendingmachine

import org.scalatest.{FunSpec, Matchers}


class MerchandiseStockSpec extends FunSpec with Matchers {
  describe("MerchandiseStock"){
    it("increases the quantity of a merchandise"){
      val merchandiseStock = new MerchandiseStock(new Merchandise("Pepsi", 2.75), 2)
      merchandiseStock.addQuantity(5)
      val expectedMerchandiseStock = new MerchandiseStock(new Merchandise("Pepsi", 2.75), 7)
      merchandiseStock shouldBe expectedMerchandiseStock
    }
  }
}
