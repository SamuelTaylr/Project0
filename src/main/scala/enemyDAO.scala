class enemyDAO {
// Create an enemy DAO that when an enemy encounter occurs, it creates a random number, queries the DB for the enemy
  // with that ID #, uses the data from the DB to display and have that specific enemy affect the character in a
  // certain way, in that way, the enemy table can contain hundreds of entries which will satisfy the project requirements

  def enemyAttack(): Int ={
    val r = scala.util.Random
    val encounterNumber = r.nextInt(55)
    var enemyName = ""
    var enemyAttack = 0

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT * FROM game_data.enemy WHERE enemy_id = $encounterNumber")

    while(rs.next) {
      enemyName = rs.getString("enemy_name")
      enemyAttack = rs.getInt("enemy_attack")
    }

    println(s"You're Attacked by an $enemyName.")
    return enemyAttack

  }
}
