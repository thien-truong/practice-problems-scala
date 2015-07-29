package localhost.tt.vendingmachine

object Main {
  def main (args: Array[String]) {
    val availableMerchandise = new VendingMachineAvailableMerchandise
    availableMerchandise
      .addMerchandise("A", new Merchandise("Pepsi", 2.75), 2)
      .addMerchandise("B", new Merchandise("Coca Cola", 0.75), 5)
      .addMerchandise("C", new Merchandise("Snicker", 2.00), 1)
    val consoleInput = new ConsoleInput
    val consoleInterface = new VendingMachineConsoleInterface(consoleInput, availableMerchandise)
    var finishedVending: Boolean = false

    while (!finishedVending) {
      availableMerchandise.displayAvailableMerchandise()

      try {
        consoleInterface.purchaseMerchandise()
      } catch {
        case exception: FinishVendingException => finishedVending = true
      }

    }
  }
}
