import java.sql.*;

public class DatabaseHandler {
    public static final String DB_url = "jdbc:derby:database/u4DB;create=true";
    public static Connection connection = null;
    private static Statement sqlStatement = null;

    public DatabaseHandler() {
        createConnection();
        createTable("test");
    }

    public void createTable(String tableName) {
        try {
            sqlStatement = connection.createStatement();
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, tableName.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table \"" + tableName + "\" already exists");
            } else {
                String sql = "CREATE TABLE " + tableName + " (" +
                        "id VARCHAR(16) PRIMARY KEY, " +
                        "first_name VARCHAR(255) NOT NULL, " +
                        "last_name VARCHAR(255) NOT NULL, " +
                        "dl VARCHAR(20) NOT NULL, " +
                        "sin VARCHAR(20) NOT NULL, " +
                        "sex CHAR(1) NOT NULL, " +
                        "email VARCHAR(255), " +
                        "phone VARCHAR(15), " +
                        "dob DATE, " +
                        "job VARCHAR(255))";

                System.out.println(sql);
                sqlStatement.executeUpdate(sql);
            }
        } catch (SQLException e) {
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


    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connection = DriverManager.getConnection(DB_url);
        }
        catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
