import scala.io.StdIn.readInt
import java.net.URL
import javax.sound.sampled._
import javax.sound.midi._
import javax.sound.midi.ShortMessage._

object main {

  def main(args: Array[String]): Unit = {


    val rcvr = MidiSystem.getReceiver()

    val msg = new ShortMessage
    msg.setMessage(NOTE_ON, 0, 60, 93)

    rcvr.send(msg, -1)


    def menuMethod(): Unit = {
      println(
        """
          |******************************
          |Welcome to SQL Dungeon
          |******************************
          |Press 1 to Start New Game
          |******************************
          |Press 2 to Continue
          |******************************
          |Press 3 to Edit Character
          |******************************
          |Press 4 to Delete Character
          |******************************
          |Press 5 to Show All Characters
          |******************************
          |Press 6 to View a Character Sheet
          |******************************
          |Press 7 to Create a New Character
          |******************************
          |""".stripMargin)

      val selection = readInt()
      var id = 0

      val menu = new menu

      id = menu.firstSelection(selection)

      if(selection == 1 || selection == 2){
        println(
          """
            |****************************
            |Ready to begin your journey?
            |****************************
            |Enter 1 to Begin or 2 to Quit
            |****************************
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
            menuMethod()
          }

        }
        while(selectionTwo > 0)

      }

      else {

        menuMethod()

      }
    }
    menuMethod()
    }




}
