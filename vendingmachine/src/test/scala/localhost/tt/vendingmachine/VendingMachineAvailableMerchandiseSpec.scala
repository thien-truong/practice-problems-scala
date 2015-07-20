package localhost.tt.vendingmachine

import org.scalatest.{Matchers, FunSpec}

class VendingMachineAvailableMerchandiseSpec extends FunSpec with Matchers {
  describe("VendingMachineInventory") {
    it("adds 2 items with merchandise-code A, merchandise-name Pepsi, and retail-price of 2.75 to " +
      "available inventory when inventory is empty") {
      val pepsi = new Merchandise("Pepsi", 2.75)
      val availableMerchandise = VendingMachineAvailableMerchandise()
      val expectedInventory = Map("A" -> new MerchandiseStock(pepsi, 2))
      availableMerchandise.addMerchandise("A", pepsi, 2)
      availableMerchandise.availableMerchandise shouldBe expectedInventory
    }

//    it("adds 3 items with merchandise-code B to inventory when 2 items of that merchandise-code is already in stock") {
//      val vendingMachineInventory = VendingMachineAvailableMerchandise()
//      vendingMachineInventory.addMerchandise("A", 2)
//      vendingMachineInventory.addMerchandise("B", 3)
//      vendingMachineInventory.addMerchandise("A", 3)
//      val expectedInventory = Map("B" -> 3, "A" -> 5)
//      vendingMachineInventory.availableMerchandise shouldBe expectedInventory
//
//    }

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
