import javax.sound.midi.{MidiSystem, ShortMessage}
import javax.sound.midi.ShortMessage.NOTE_ON

object encounter  {


  def encounterMethod(charId: Int): Unit = {
    val char = new characterDAO
    val r = scala.util.Random
    val encounterNumber = r.nextInt(7)
    Thread.sleep(1500)


    encounterNumber match {
      case 0 => {

        val rcvr = MidiSystem.getReceiver()

        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 78, 93)
        rcvr.send(msg, -1)
        println("You see a small, dimly lit chamber, apprehensive, you begin to walk inside.")
        Thread.sleep(1500)
        println("You find an abandoned couch and rest for a while...")

        char.updateCharHealth(charId, -3)
        char.checkCharGold(charId)
      }


      case 1 => {
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 78, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(200)

        println("You come to a narrow hallway with only one exit, its too quiet here...")
        Thread.sleep(1500)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(1500)
        println("You summon your courage and fight...")
        Thread.sleep(1500)
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
        Thread.sleep(1500)
        print("Slowly, you approach the altar \n")
        Thread.sleep(1500)
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
        Thread.sleep(1500)
        println("No point in delaying, you begin to walk towards it.")
        Thread.sleep(1500)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(1500)
        println("You summon your courage and fight...")
        Thread.sleep(1500)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)

        char.checkCharGold(charId)

      case 4 =>
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 99, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(200)

        println("You enter a strange, dirty chamber with moss growing everywhere...")
        Thread.sleep(1500)
        println("You hear a scratching noise coming from behind you...")
        Thread.sleep(1500)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(1500)
        println("You summon your courage and fight...")
        Thread.sleep(1500)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)
        char.checkCharGold(charId)


      case 5 =>
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 99, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(200)

        println("You see someone peeking from around a corner...")
        Thread.sleep(1500)
        println("You slowly walk towards them, unsure of who it could be...")
        Thread.sleep(1500)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(1500)
        println("You summon your courage and fight...")
        Thread.sleep(1500)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)
        char.checkCharGold(charId)

      case 6 =>
        val rcvr = MidiSystem.getReceiver()
        val msg = new ShortMessage
        msg.setMessage(NOTE_ON, 0, 99, 99)
        rcvr.send(msg, -1)

        val r = scala.util.Random
        val encounterNumber = r.nextInt(200)

        println("You enter a massive room, you can't even see the ceiling...")
        Thread.sleep(1500)
        println("You step into the room, fearing the worst...")
        Thread.sleep(1500)
        println("Suddenly, something drops from the darkness above you...")
        Thread.sleep(1500)

        val enemy = new enemyDAO
        val enemyAttack = enemy.enemyAttack(encounterNumber)
        Thread.sleep(1500)
        println("You summon your courage and fight...")
        Thread.sleep(1500)
        val enemyGold = enemy.enemyGold(encounterNumber)

        char.updateCharHealth(charId, enemyAttack, enemyGold)
        char.checkCharGold(charId)
    }




  }



}
