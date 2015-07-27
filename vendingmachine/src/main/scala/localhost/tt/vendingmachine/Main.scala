package localhost.tt.vendingmachine

object Main {
  def main (args: Array[String]) {
    val availableMerchandise = new VendingMachineAvailableMerchandise
    availableMerchandise
      .addMerchandise("A", new Merchandise("Pepsi", 2.75), 2)
      .addMerchandise("B", new Merchandise("Coca Cola", 0.75), 5)
      .addMerchandise("C", new Merchandise("Snicker", 2.00), 1)
    val consoleInterface = new VendingMachineConsoleInterface(availableMerchandise)
    availableMerchandise.displayAvailableMerchandise()
    consoleInterface.purchaseMerchandise()
  }
}