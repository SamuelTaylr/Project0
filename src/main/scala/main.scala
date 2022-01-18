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


    /*val url = new URL("http://mywebpages.comcast.net/jdeshon2/wave_files/jad0001a.wav")
    val audioIn = AudioSystem.getAudioInputStream(url)
    val clip = AudioSystem.getClip
    clip.open(audioIn)
    clip.start*/

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
        |""".stripMargin)

    val selection = readInt()
    var id = 0

    val menu = new menu

    id = menu.firstSelection(selection)

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
      }

    }
    while(selectionTwo > 0)


  }
}
