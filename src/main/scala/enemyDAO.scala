class enemyDAO {
// Create an enemy DAO that when an enemy encounter occurs, it creates a random number, queries the DB for the enemy
  // with that ID #, uses the data from the DB to display and have that specific enemy affect the character in a
  // certain way, in that way, the enemy table can contain hundreds of entries which will satisfy the project requirements

  def enemyAttack(enemyId: Int): Int ={
    val r = scala.util.Random
    val encounterNumber = r.nextInt(115)
    var enemyName = ""
    var enemyAttack = 0

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT * FROM game_data.enemy WHERE enemy_id = $enemyId")

    while(rs.next) {
      enemyName = rs.getString("enemy_name")
      enemyAttack = rs.getInt("enemy_attack")
    }

    println(s"You're Attacked by a $enemyName.")
    return enemyAttack

  }

  def enemyGold(enemyId: Int): Int = {
    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    var enemyGold = 0

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT enemy_gold FROM game_data.enemy WHERE enemy_id = $enemyId")

    while(rs.next) {
      enemyGold = rs.getInt("enemy_gold")
    }

    println(s"You find $enemyGold gold in the defeated enemies belongings.")
    return enemyGold
  }
}
