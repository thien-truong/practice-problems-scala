package localhost.tt.vendingmachine

import org.scalatest.{Matchers, FunSpec}

class VendingMachineAvailableMerchandiseSpec extends FunSpec with Matchers {
  describe("VendingMachineInventory") {
    it("adds 2 pepsi's (merchandise-code: A, merchandise-name: Pepsi, retail-price: 2.75) " +
      "to an empty available merchandise") {
      val pepsi = new Merchandise("Pepsi", 2.75)
      val availableMerchandise = VendingMachineAvailableMerchandise()
      val expectedAvailableMerchandise = Map("A" -> new MerchandiseStock(pepsi, 2))
      availableMerchandise.addMerchandise("A", pepsi, 2)
      availableMerchandise.availableMerchandise shouldBe expectedAvailableMerchandise
    }

    it("adds 5 pepsi's (merchandise-code: A, merchandise-name: Pepsi, retail-price: 2.75) " +
      "to a non-empty available merchandise") {
      val pepsi = new Merchandise("Pepsi", 2.75)
      val coke = new Merchandise("Coke", 0.75)
      val availableMerchandise = VendingMachineAvailableMerchandise()
      val expectedAvailableMerchandise = Map("C" -> new MerchandiseStock(coke, 3), "A" -> new MerchandiseStock(pepsi, 7))
      availableMerchandise.addMerchandise("A", pepsi, 2).addMerchandise("C", coke, 3).addMerchandise("A", pepsi, 5)
      availableMerchandise.availableMerchandise shouldBe expectedAvailableMerchandise
    }

    it("reduces 1 item with merchandise-code A from available merchandise") {
      val pepsi = new Merchandise("Pepsi", 2.75)
      val coke = new Merchandise("Coke", 0.75)
      val availableMerchandise = VendingMachineAvailableMerchandise()
      val expectedAvailableMerchandise = Map("C" -> new MerchandiseStock(coke, 3), "A" -> new MerchandiseStock(pepsi, 1))
      availableMerchandise.addMerchandise("A", pepsi, 2).addMerchandise("C", coke, 3).reduceMerchandise("A", 1)
      availableMerchandise.availableMerchandise shouldBe expectedAvailableMerchandise
    }

//    it("removes items with merchandise-code C") {
//      val vendingMachineInventory = VendingMachineAvailableMerchandise()
//      vendingMachineInventory.addMerchandise("A", 2)
//      vendingMachineInventory.addMerchandise("C", 3)
//      vendingMachineInventory.addMerchandise("A", 3)
//      vendingMachineInventory.removeMerchandise("C")
//      val expectedInventory = Map("A" -> 5)
//      vendingMachineInventory.availableMerchandise shouldBe expectedInventory
//    }



  }
}
