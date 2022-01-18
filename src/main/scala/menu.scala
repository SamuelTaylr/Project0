import scala.io.StdIn.{readInt, readLine}

class menu {

  def firstSelection(selection: Int) : Int = {

    var id = 0

    selection match{

      case 1 => {
      val char = new characterDAO
      println("Enter character id to load character")
      id = readInt()
      char.getCharName(id)
      }
        return id

      case 2 => {
      val newChar = readLine("Enter Name of New Character ")
      println("Enter Health ")
      val newHealth = readInt()
      val char = new characterDAO
      char.makeNewChar(newChar,newHealth)
      id = char.getCharId(newChar)
      }
        return id
  }


}
  def secondSelection(selection: Int, charId: Int) : Unit = {

    selection match {

      case 1 => {
        println("You slowly make your way to the next room...")
        encounter.encounterMethod(charId)
      }

      case 2 => {
        println(
          s"""
            |There's no shame in quitting while you're ahead
            |Enter your character id $charId to restart later
            |""".stripMargin)
        System.exit(1)
      }
    }
  }


}
