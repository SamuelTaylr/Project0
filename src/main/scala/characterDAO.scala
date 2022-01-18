import java.sql.PreparedStatement
import scala.io.StdIn.readLine

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

  def makeNewChar(charName: String, health: Int, charClass: String, charRace: String, charFaction: Int, distanceTraveled: Int = 0): Unit = {

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    val rs = s"INSERT INTO game_data.character (char_name, char_health, distance_traveled, char_class, char_race, faction_id) VALUES (?, ?, ?, ?, ?, ?)"

    val preparedStmt: PreparedStatement = con.prepareStatement(rs)
    preparedStmt.setString(1,charName)
    preparedStmt.setInt(2, health)
    preparedStmt.setInt(3, distanceTraveled)
    preparedStmt.setString(4,charClass)
    preparedStmt.setString(5, charRace)
    preparedStmt.setInt(6, charFaction)
    preparedStmt.execute()
  }

  def getCharId(name: String): Int = {

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    var charId = 0

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT char_id FROM game_data.character WHERE char_name = '$name'")

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

  def deleteCharacter(): Unit = {
    val dbCon = new dbConnector
    val con = dbCon.dbConnection()

    println(
      """
        |**********************
        |Enter a Character Name
        |to Delete Them
        |**********************
        |""".stripMargin)

    val charName = readLine()

    val rs = s"DELETE FROM game_data.character WHERE char_name = ?"

    val preparedStmt: PreparedStatement = con.prepareStatement(rs)
    preparedStmt.setString(1,charName)
    preparedStmt.execute()

    println(s"$charName Deleted from Database Successfully")
  }

  def getAllCharacters(): Unit = {
    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    val charName = scala.collection.mutable.ArrayBuffer("")

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT * FROM game_data.character")

    while(rs.next) {
      charName += rs.getString("char_name")
    }

    for(s <- charName) {
      println(s)
    }
  }

  def displayCharacterInfo(charId: Int) : Unit = {
    val dbCon = new dbConnector
    val con = dbCon.dbConnection()
    val charName = scala.collection.mutable.ArrayBuffer("")

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT * FROM game_data.character")

    while(rs.next) {
      charName += rs.getString("char_name")
    }

    for(s <- charName) {
      println(s)
    }
  }

}
