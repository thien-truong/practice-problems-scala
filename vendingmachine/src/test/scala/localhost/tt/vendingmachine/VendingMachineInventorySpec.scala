package localhost.tt.vendingmachine

import org.scalatest.{Matchers, FunSpec}

class VendingMachineInventorySpec extends FunSpec with Matchers {
  describe("VendingMachineInventory") {
    it("adds 2 items with merchandise-code A to inventory when inventory is empty") {
      val vendingMachineInventory = VendingMachineInventory()
      val expectedInventory = Map("A" -> 2)
      vendingMachineInventory.addMerchandise("A", 2)
      vendingMachineInventory.merchandiseInventory shouldBe expectedInventory
    }

    it("adds 3 items with merchandise-code B to inventory when 2 items of that merchandise-code is already in stock") {
      val vendingMachineInventory = VendingMachineInventory()
      vendingMachineInventory.addMerchandise("A", 2)
      vendingMachineInventory.addMerchandise("B", 3)
      vendingMachineInventory.addMerchandise("A", 3)
      val expectedInventory = Map("B" -> 3, "A" -> 5)
      vendingMachineInventory.merchandiseInventory shouldBe expectedInventory

    }

    it("removes items with merchandise-code C") {
      val vendingMachineInventory = VendingMachineInventory()
      vendingMachineInventory.addMerchandise("A", 2)
      vendingMachineInventory.addMerchandise("C", 3)
      vendingMachineInventory.addMerchandise("A", 3)
      vendingMachineInventory.removeMerchandise("C")
      val expectedInventory = Map("A" -> 5)
      vendingMachineInventory.merchandiseInventory shouldBe expectedInventory
    }

  }
}
