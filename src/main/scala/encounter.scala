object encounter  {


  def encounterMethod(charId: Int): Unit = {
    val char = new characterDAO
    val r = scala.util.Random
    val encounterNumber = r.nextInt(5)
    Thread.sleep(1500)


    encounterNumber match {
      case 0 => {
        println("You see a small, dimly lit chamber, apprehensive, you begin to walk inside.")
        Thread.sleep(5000)
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

        char.updateCharHealth(charId, 1)
      }


      case 1 => {
        println("You come to a narrow hallway with only one exit, its too quiet here...")
        Thread.sleep(5000)
        println("A Skeleton Attacks!")
        println(
          """
            |      .-.
            |     (o.o)
            |      |=|
            |     __|__
            |   //.=|=.\\
            |  // .=|=. \\
            |  \\ .=|=. //
            |   \\(_=_)//
            |    (:| |:)
            |     || ||
            |     () ()
            |     || ||
            |     || ||
            |    ==' '==
            |""".stripMargin)
        char.updateCharHealth(charId, -1)
      }

      case 2 => {
        println("You enter a brightly lit room with a strange altar in the center...")
        Thread.sleep(5000)
        print("Slowly, you approach the altar")
        Thread.sleep(5000)
        println("You find a health potion!")
        println(
          """
            |         mmm
            |         )-(
            |        (   )
            |        |   |
            |        |   |
            |        |___|
            |""".stripMargin)
        char.updateCharHealth(charId, 3)
      }

      case 3 =>
        println("You see a strange building in the distance...")
        Thread.sleep(5000)
        println(
          """
            |
            |             +
            |             A
            |          __/_\__
            |         /\-'o'-/\
            |        _||:<_>:||_
            |       /\_/=====\_/\
            |      _|:_:_[I]_:_:|_
            |   _/::::::::::::::::\_
            | _/::::::::::::::::::::\_
            |/::::::::::::::::::::::::\
            |""".stripMargin)

        println("No point in delaying, you begin to walk towards it.")

      case 4 =>
        println("You enter a strange, dirty chamber with moss growing everywhere...")
        Thread.sleep(5000)
        println("You hear a scratching noise coming from behind you...")
        Thread.sleep(5000)

        println("A small pink rabbit leaps at you out of nowhere!")
        println(
          """
            |                ((`\
            |            ___ \\ '--._
            |         .'`   `'    o  )
            |        /    \   '. __.'
            |       _|    /_  \ \_\_
            |      {_\______\-'\__\_\
            |""".stripMargin)
        char.updateCharHealth(charId, -3)


    }
  }



}
