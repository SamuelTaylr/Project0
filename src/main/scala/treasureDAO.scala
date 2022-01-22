class treasureDAO {

  def treasureFind(treasureId: Int): (Int,Int) ={

    var treasureName = ""
    var treasureGold = 0
    var treasureHealth = 0

    val dbCon = new dbConnector
    val con = dbCon.dbConnection()

    val statement = con.createStatement
    val rs = statement.executeQuery(s"SELECT * FROM game_data.treasures WHERE treasure_id = $treasureId")

    while(rs.next) {
      treasureName = rs.getString("treasure_name")
      treasureGold = rs.getInt("treasure_gold")
      treasureHealth = rs.getInt("treasure_health")
    }

    println(s"You find a $treasureName.")
    return (treasureHealth, treasureGold)

  }
}
