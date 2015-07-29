package localhost.tt.vendingmachine

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

class VendingMachineConsoleInterfaceSpec extends FunSpec with Matchers with BeforeAndAfter with MockFactory{
  describe("VendingMachineConsoleInterface") {
    val mockedConsoleInput = mock[ConsoleInput]
    val availableMerchandise = new VendingMachineAvailableMerchandise
    val expectedAvailableMerchandise = Map(
      "A" -> new MerchandiseStock(new Merchandise("Pepsi", 2.75), 1),
      "B" -> new MerchandiseStock(new Merchandise("Coca Cola", 0.75), 5),
      "C" -> new MerchandiseStock(new Merchandise("Snicker", 2.00), 1)
    )

    before {
      availableMerchandise
        .addMerchandise("A", new Merchandise("Pepsi", 2.75), 2)
        .addMerchandise("B", new Merchandise("Coca Cola", 0.75), 5)
        .addMerchandise("C", new Merchandise("Snicker", 2.00), 1)
    }

    it("lets the user buy a Pepsi") {
      inSequence {
        (mockedConsoleInput.readLine _).expects(*).returning("a")
        (mockedConsoleInput.readLine _).expects(*).returning("4")
      }
      val consoleInterface = new VendingMachineConsoleInterface(mockedConsoleInput, availableMerchandise)
      consoleInterface.purchaseMerchandise()
      availableMerchandise.availableMerchandise shouldBe expectedAvailableMerchandise
    }

    it ("throws an exception when the user enters XX for merchandise code") {
      (mockedConsoleInput.readLine _).expects(*).returning("XX")
      val consoleInterface = new VendingMachineConsoleInterface(mockedConsoleInput, availableMerchandise)
      intercept[FinishVendingException] {
        consoleInterface.purchaseMerchandise()
      }
    }

  }
}
