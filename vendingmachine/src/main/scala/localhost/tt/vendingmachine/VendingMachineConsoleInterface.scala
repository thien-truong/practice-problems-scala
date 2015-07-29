package localhost.tt.vendingmachine

case class VendingMachineConsoleInterface(consoleInput: ConsoleInput, availableMerchandise: VendingMachineAvailableMerchandise) {

  private def getMoreCash(merchandisePrice: Double, merchandiseName: String, cashPaidSoFar: Double): Double = {
    val additionalCashNeeded: Double = merchandisePrice - cashPaidSoFar
    val additionalCashPaidString: String = consoleInput.readLine(f"Your $merchandiseName costs $$$merchandisePrice%.2f. Please enter at least $$$additionalCashNeeded%.2f more: ")
    var additionalCashEntered: Double = 0.0

    try {
      additionalCashEntered = additionalCashPaidString.toDouble
    } catch {
      case exception: NumberFormatException =>
        println(f"Error: $exception. Expecting a numeric value.")
    }

    cashPaidSoFar + additionalCashEntered
  }

  private def dispenseMerchandise(selectedMerchandiseCode: String, selectedMerchandise: Merchandise, cashPaidSoFar: Double): Unit = {
    val selectedMerchandisePrice: Double = selectedMerchandise.retailPrice
    val selectedMerchandiseName: String = selectedMerchandise.merchandiseName
    val change = cashPaidSoFar - selectedMerchandisePrice
    
    availableMerchandise.reduceMerchandise(selectedMerchandiseCode, 1)
    availableMerchandise.resetCashBalanceAfterPurchase(selectedMerchandisePrice)
    println(f"Enjoy your $selectedMerchandiseName! And here is your change of $$$change%.2f.")
  }

  private def purchaseSpecifiedMerchandise(merchandiseCode: String, selectedMerchandise: Merchandise) = {
    val maxCashAcceptedByMachine = 5.0
    val merchandisePrice: Double = selectedMerchandise.retailPrice
    println(f"Please note that this machine cannot accept more than $$$maxCashAcceptedByMachine%.2f in cash.")
    val cashPaidSoFarString: String = consoleInput.readLine("Enter cash $: ")
    var cashPaidSoFar: Double = 0.0

    try {
      cashPaidSoFar = cashPaidSoFarString.toDouble
    } catch {
      case exception: NumberFormatException => println(f"Error: $exception. Expecting a numeric value.")
    }

    while (cashPaidSoFar < merchandisePrice) {
      cashPaidSoFar = getMoreCash(merchandisePrice, selectedMerchandise.merchandiseName, cashPaidSoFar)
    }

    if (cashPaidSoFar <= maxCashAcceptedByMachine) {
      dispenseMerchandise(merchandiseCode, selectedMerchandise, cashPaidSoFar)
    } else {
      println(f"This machine cannot accept more than $$$maxCashAcceptedByMachine%.2f in cash.  Here is your $$$cashPaidSoFar%.2f back.")
    }

  }

  def purchaseMerchandise(): Unit = {
    val merchandiseCode: String = consoleInput.readLine("Enter XX to quit. Otherwise enter the code " +
      "that corresponds to the drink you wish to purchase: ").toUpperCase

    if (merchandiseCode.toUpperCase == "XX") throw new FinishVendingException

    val selectedMerchandise: Option[Merchandise] = availableMerchandise.getMerchandise(merchandiseCode)

    if (selectedMerchandise.nonEmpty) {
      purchaseSpecifiedMerchandise(merchandiseCode, selectedMerchandise.get)
    } else {
      println("No such code in the system.")
    }

  }

}
