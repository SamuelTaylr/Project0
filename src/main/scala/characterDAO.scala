import java.sql.PreparedStatement

class characterDAO {

  def getCharName(id: Int): Unit = {

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT * FROM game_data.character WHERE char_id = $id")
    var name = scala.collection.mutable.ArrayBuffer("")
    while(rs.next) {
      name += rs.getString("char_name")

    }
    for(x <- name) {
      println(x)
    }
  }

  def makeNewChar(charName: String, health: Int, enemies_killed: Int = 0): Unit = {

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    val rs = s"INSERT INTO game_data.character (char_name, char_health, enemies_killed) VALUES (?, ?, ?)"

    val preparedStmt: PreparedStatement = con.prepareStatement(rs)
    preparedStmt.setString(1,charName)
    preparedStmt.setInt(2, health)
    preparedStmt.setInt(3, enemies_killed)
    preparedStmt.execute()
  }

  def getCharId(name: String): Int = {

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    var charId = 0

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT char_id FROM game_data.character WHERE char_name = $name")

    while(rs.next) {
      charId = rs.getInt("char_id")

    }
    return charId

  }

  def updateCharHealth(charId: Int, changeHealth: Int) : Unit = {
    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    var charHealth = 0

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT char_health FROM game_data.character WHERE char_id = $charId")

    while(rs.next) {
      charHealth = rs.getInt("char_health")
    }

    charHealth += changeHealth
    val rsTwo = s"UPDATE game_data.character SET char_health = (?), distance_traveled = distance_traveled + 1 WHERE char_id = $charId"

    val preparedStmt: PreparedStatement = con.prepareStatement(rsTwo)

    preparedStmt.setInt(1, charHealth)
    preparedStmt.execute()
    println(s"You have $charHealth health remaining")



  }

  def getCharHealth(charId: Int): Int = {

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    var charHealth = 0

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT char_health FROM game_data.character WHERE char_id = $charId")

    while(rs.next) {
      charHealth = rs.getInt("char_health")

    }
    return charHealth

  }



}
