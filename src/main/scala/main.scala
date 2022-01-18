import scala.io.Source.DefaultBufSize.==
import scala.io.StdIn.readInt

object main {

  def main(args: Array[String]): Unit = {
    println(
      """
        |Welcome to my Game
        |Press 1 to Continue
        |Press 2 to Start New Game
        |""".stripMargin)
    val selection = readInt()
    var id = 0

    val menu = new menu

    id = menu.firstSelection(selection)

    println(
      """
        |Ready to begin your journey?
        |Enter 1 to begin or 2 to quit
        |""".stripMargin)
    val selectionTwo = readInt()
    menu.secondSelection(selectionTwo, id)

    do {
      println(
        """
          |Can you keep going?
          |Enter 1 to continue on or 2 to quit
          |""".stripMargin)
      val selectionTwo = readInt()
      val char = new characterDAO
      var charHealth = char.getCharHealth(id)
      if(charHealth > 0 ) {
        menu.secondSelection(selectionTwo, id)
      }
      else {
        println("Your Character has no health left!  Try again with a new character.")
      }

    }
    while(selectionTwo > 0)


  }
}
