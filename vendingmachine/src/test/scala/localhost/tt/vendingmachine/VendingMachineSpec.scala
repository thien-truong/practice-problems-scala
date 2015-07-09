package localhost.tt.vendingmachine

import org.scalatest.{Matchers, FunSpec}

class VendingMachineSpec extends FunSpec with Matchers {
  describe("VendingMachine") {
    it("adds 2 items of sku 12345 to inventory when inventory is empty") {
      val vendingMachine = VendingMachine()
      val expectedInventory = Map("12345" -> 2)
      vendingMachine.addMerchandise("12345", 2)
      vendingMachine.merchandiseInventory shouldBe expectedInventory
    }
  }
}
