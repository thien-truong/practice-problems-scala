package localhost.tt.vendingmachine

import scala.io.StdIn

class ConsoleInput {
  def readLine(text: String): String = StdIn.readLine(text)
}
