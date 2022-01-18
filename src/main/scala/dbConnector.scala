import java.sql.{Connection, DriverManager}

class dbConnector {

  def dbConnection(): Connection = {
    val MySQLURL = "jdbc:mysql://localhost:3306/grocery_store"
    val databaseUserName = "root"
    val databasePassword = "root"
    val driver = "com.mysql.cj.jdbc.Driver"
    val con = DriverManager.getConnection(MySQLURL, databaseUserName, databasePassword)
    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(MySQLURL, databaseUserName, databasePassword)

    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con
  }

}
