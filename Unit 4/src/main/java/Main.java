import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.csv.*;

public class Main {
    public static DatabaseHandler db;

    public static void main(String[] args) throws IOException {

        db = new DatabaseHandler();

        try (Reader in = new FileReader("Unit 4/src/main/resources/a.csv")) {
            Iterable<CSVRecord> records;
            try {
                records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
            }
            catch (IOException | IllegalArgumentException | NullPointerException e) {
                throw new IllegalArgumentException("File cannot be parsed as a CSV file.");
            }
            for (CSVRecord record : records) {
                addPerson(record.get("User Id"), record.get("First Name"), record.get("Last Name"), record.get("DL#"), record.get("SIN"), record.get("Sex"), record.get("Email"), record.get("Phone"), record.get("Date of birth"), record.get("Job Title"));
            }
        }
        catch (IOException e) {
            throw new IOException("Error locating/reading file.");
        }

        String query = "SELECT * FROM TEST";
        ResultSet resultSet = db.executeQuery(query);
        try (Writer writer = Files.newBufferedWriter(Paths.get("out/output.csv"), StandardCharsets.UTF_8);
             CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            printer.printRecords(resultSet, true);
        }
        catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("output.csv created and saved successfully at /out.");
    }

    public static void addPerson(String id, String firstName, String lastName, String dl, String sin, String sex, String email, String phone, String dob, String job) {
        String query =  "INSERT INTO TEST VALUES (" +
                "'" + id + "'," +
                "'" + firstName + "'," +
                "'" + lastName + "'," +
                "'" + dl + "'," +
                "'" + sin + "'," +
                "'" + (sex.equals("Male") ? "M" : "F") + "'," +
                "'" + email + "'," +
                "'" + phone + "'," +
                "'" + dob + "'," +
                "'" + job + "')";
        System.out.println("Added " + firstName + " " + lastName + ". ID: " + id);
        try {
            db.executeAction(query);
        }
        catch (Exception e) {
            System.out.println("Error inserting person (" + e + "): " + query);
        }
    }
}
