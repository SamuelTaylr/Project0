import javax.sound.midi.{MidiSystem, ShortMessage}
import javax.sound.midi.ShortMessage.NOTE_ON

object encounter  {


  def encounterMethod(charId: Int): Unit = {
    val char = new characterDAO
    val r = scala.util.Random
    val encounterNumber = r.nextInt(6)
    Thread.sleep(1500)


    encounterNumber match {
      case 0 => {

        val rcvr = MidiSystem.getReceiver()

        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 78, 93)
        rcvr.send(msg, -1)
        println("You see a small, dimly lit chamber, apprehensive, you begin to walk inside.")
        Thread.sleep(0)
        println("You find an abandoned couch and rest for a while...")
        println(
          """
            |  .--------------.--------------.
            |  |              |              |
            |  |      **      |      **      |
            |  |              |              |
            |  |______________|______________|
            |  /                             \
            | /                               \
            |/_________________________________\
            ||                                 |
            ||_________________________________|
            |[]                               []
            |""".stripMargin)
        char.updateCharHealth(charId, -3)
        char.checkCharGold(charId)
      }


      case 1 => {
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 78, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(115)

        println("You come to a narrow hallway with only one exit, its too quiet here...")
        Thread.sleep(0)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(0)
        println("You summon your courage and fight...")
        Thread.sleep(0)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)
        char.checkCharGold(charId)
      }

      case 2 => {
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 45, 93)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(10)
        val treasure = new treasureDAO

        println("You enter a brightly lit room with a strange altar in the center...")
        Thread.sleep(0)
        print("Slowly, you approach the altar")
        Thread.sleep(0)
        val treasureTuple = treasure.treasureFind(encounterNumber)
        val healthChange = treasureTuple._1
        val goldChange = treasureTuple._2
        println(healthChange)


        char.updateCharHealth(charId, -healthChange, goldChange)
        char.checkCharGold(charId)
      }

      case 3 =>
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 45, 93)
        rcvr.send(msg, -1)

        println("You see a strange building in the distance...")
        Thread.sleep(0)
        println("No point in delaying, you begin to walk towards it.")
        Thread.sleep(0)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(0)
        println("You summon your courage and fight...")
        Thread.sleep(0)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)

        char.checkCharGold(charId)

      case 4 =>
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 99, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(115)

        println("You enter a strange, dirty chamber with moss growing everywhere...")
        Thread.sleep(0)
        println("You hear a scratching noise coming from behind you...")
        Thread.sleep(0)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(0)
        println("You summon your courage and fight...")
        Thread.sleep(0)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)
        char.checkCharGold(charId)


      case 5 =>
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 99, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(115)

        println("You see someone peeking from around a corner...")
        Thread.sleep(0)
        println("You slowly walk towards them, unsure of who it could be...")
        Thread.sleep(0)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(0)
        println("You summon your courage and fight...")
        Thread.sleep(0)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)
        char.checkCharGold(charId)
    }




  }



}
