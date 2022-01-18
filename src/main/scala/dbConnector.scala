import java.sql.{Connection, DriverManager}

class dbConnector {

  def dbConnection(): Connection = {
    val MySQLURL = "jdbc:mysql://localhost:3306/grocery_store"
    val databseUserName = "root"
    val databasePassword = "root"
    val driver = "com.mysql.cj.jdbc.Driver"
    //val driver = "com.mysql.jdbc.Driver"
    val con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword)

    try {
      Class.forName(driver)
      val con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword)
      if (con != null) System.out.println("Database connection is successful !!!!")

    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    return con
  }

}
