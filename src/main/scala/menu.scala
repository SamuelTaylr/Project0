import scala.io.StdIn.{readInt, readLine}

class menu {

  def firstSelection(selection: Int) : Int = {

    var id = 0

    selection match{

      case 1 => {
        val newChar = readLine("Enter Name of New Character: ")
        val newClass = readLine("Enter Name of Character's Class: ")
        val newRace = readLine("Enter your Character's Race: ")
        println(
          """
            |Choose a Faction:
            |Enter 1 for the Alliance
            |Enter 2 for the Horde
            |""".stripMargin)
        val newFaction = readInt()
        println("Enter Health: ")
        val newHealth = readInt()
        val char = new characterDAO
        char.makeNewChar(newChar,newHealth, newClass, newRace, newFaction)
        id = char.getCharId(newChar)
      }
        return id

      case 2 => {
        val char = new characterDAO
        println("Enter character id to load character: ")
        id = readInt()
        char.getCharName(id)
      }
        return id

      case 3 => {
        val char = new characterDAO
        val charName = readLine("Enter character name to load character: ")
        val id = char.getCharId(charName)
        if(id > 0) {
          char.displayCharacterInfo(id)
          char.updateCharacterInfo(id)
        }
        else {
          println("Invalid character name entered")
        }
      }
        return id

      case 4 => {
        val char = new characterDAO
        char.deleteCharacter()
        val testId = 0
        return testId
      }

      case 5 => {
        val char = new characterDAO
        char.getAllCharacters()
        val testingCode = 0
        return testingCode
      }
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
            |Enter your character id: $charId to restart later
            |""".stripMargin)
        System.exit(1)
      }
    }
  }


}
