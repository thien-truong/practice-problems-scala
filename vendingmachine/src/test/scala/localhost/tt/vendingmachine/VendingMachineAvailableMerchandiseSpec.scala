package localhost.tt.vendingmachine

import org.scalatest.{Matchers, FunSpec}

class VendingMachineAvailableMerchandiseSpec extends FunSpec with Matchers {
  describe("VendingMachineInventory") {
    it("adds 2 pepsi to an empty available merchandise") {
      val pepsi = new Merchandise("Pepsi", 2.75)
      val availableMerchandise = VendingMachineAvailableMerchandise()
      val expectedAvailableMerchandise = Map("A" -> new MerchandiseStock(pepsi, 2))
      availableMerchandise.addMerchandise("A", pepsi, 2)
      availableMerchandise.availableMerchandise shouldBe expectedAvailableMerchandise
    }

    it("adds 5 pepsi to a non-empty available merchandise") {
      val pepsi = new Merchandise("Pepsi", 2.75)
      val coke = new Merchandise("Coke", 0.75)
      val availableMerchandise = VendingMachineAvailableMerchandise()
      val expectedAvailableMerchandise = Map("C" -> new MerchandiseStock(coke, 3), "A" -> new MerchandiseStock(pepsi, 7))
      availableMerchandise.addMerchandise("A", pepsi, 2).addMerchandise("C", coke, 3).addMerchandise("A", pepsi, 5)
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

//    it("reduces 1 item with Merchandise-code B from inventory") {
//      val vendingMachineInventory = VendingMachineAvailableMerchandise()
//      vendingMachineInventory.addMerchandise("A", 2)
//      vendingMachineInventory.addMerchandise("C", 3)
//      vendingMachineInventory.addMerchandise("B", 3)
//      vendingMachineInventory.reduceMerchandise("C", 1)
//      val expectedInventory = Map("A" -> 2, "C" -> 3, "B" -> 2)
//      vendingMachineInventory.availableMerchandise shouldBe expectedInventory
//    }

  }
}
