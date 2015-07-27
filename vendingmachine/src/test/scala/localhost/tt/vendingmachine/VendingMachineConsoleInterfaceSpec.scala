package localhost.tt.vendingmachine

import org.scalatest.{FunSpec, Matchers}

class VendingMachineConsoleInterfaceSpec extends FunSpec with Matchers {
  describe("VendingMachineConsoleInterface") {
    it("throws an exception if the user enters XX for merchandiseCode") {
      val availableMerchandise = new VendingMachineAvailableMerchandise
      availableMerchandise
        .addMerchandise("A", new Merchandise("Pepsi", 2.75), 2)
        .addMerchandise("B", new Merchandise("Coca Cola", 0.75), 5)
        .addMerchandise("C", new Merchandise("Snicker", 2.00), 1)
      val consoleInterface = new VendingMachineConsoleInterface(availableMerchandise)
    }
  }
}
