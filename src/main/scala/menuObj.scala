import java.sql.{DriverManager, Statement}
import scala.io.StdIn.{readInt, readLine}

object menuObj {

  /*println(
    """
      |Welcome to my Game
      |Press 1 to Continue
      |Press 2 to Start New Game
      |""".stripMargin)
  val selection = readInt()
  var id = 0

  def firstSelection(selection: Int) : Unit {
    selection match{
    case 1 => {
    val char = new characterDAO
    println("Enter character id to load character")
    id = readInt()
    char.getCharName(id)
  }

    case 2 => {
    val newChar = readLine("Enter Name of New Character ")
    println("Enter Health ")
    val newHealth = readInt()
    val char = new characterDAO
    char.makeNewChar(newChar,newHealth)
    id = char.getCharId(newChar)
    println(id)
  }
  }
      selection match{
        case 1 => {
          val char = new characterDAO
          println("Enter character id to load character")
          id = readInt()
          char.getCharName(id)
        }

        case 2 => {
          val newChar = readLine("Enter Name of New Character ")
          println("Enter Health ")
          val newHealth = readInt()
          val char = new characterDAO
          char.makeNewChar(newChar,newHealth)
          id = char.getCharId(newChar)
          println(id)
        }

  }

}
*/}