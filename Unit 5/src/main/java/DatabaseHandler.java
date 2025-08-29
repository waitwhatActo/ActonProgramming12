import java.sql.*;

public class DatabaseHandler {
    public static final String DB_url = "jdbc:derby:database/u5DB;create=true";
    public static Connection connection = null;
    public static Statement sqlStatement = null;

    public DatabaseHandler() {
        createConnection();
        createTable("logins");
    }

    public void createTable(String tableName) {
        try {
            sqlStatement = connection.createStatement();
            DatabaseMetaData dmbd = connection.getMetaData();
            ResultSet tables = dmbd.getTables(null, null, tableName.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table \"" + tableName + "\" already exists.");
            }
            else {
                String sql ="CREATE TABLE logins (" +
                            "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                            "username VARCHAR(255) NOT NULL UNIQUE, " +
                            "password VARCHAR(128) NOT NULL)";
                System.out.println(sql);
                sqlStatement.executeUpdate(sql);
                sqlStatement.execute("INSERT INTO logins (username, password) VALUES ('dbadmin', '&%zpmKsKXiQ90OOi7hgC8%*n3I9joYU#VN6lhxL8sPhKaUmFjYwgHIP%Ta@IrkG^H2KMfM439wL$x!&h@ay*PF!rexLYfgzj^Y3FLpZszqH9HTgKm32uvN^47OuWV6%l')");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeAction(String query) {
        try {
            sqlStatement = connection.createStatement();
            sqlStatement.execute(query);
        }
        catch (SQLException e) {
            System.out.println("Error executing query ("+ e + "): " + query);
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet;
        try {
            sqlStatement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = sqlStatement.executeQuery(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connection = DriverManager.getConnection(DB_url);
        }
        catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
