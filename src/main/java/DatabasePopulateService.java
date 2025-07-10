//Завдання №3 - створити клас для наповнення таблиць БД
//Створи клас з назвою DatabasePopulateService.
// У цьому класі має бути метод public static void main(String[] args),
//      який зчитуватиме файл sql/populate_db.sql і виконуватиме запити з цього класу у БД.
//
//Для роботи з БД використовуй написаний раніше тобою клас Database.
//Результат запуску цього класу - наповнені таблиці бази даних.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();

        try {
            String sql = Files.readString(Path.of("sql/populate_db.sql"));
            Connection conn = Database.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }  catch (Exception ex) {
            ex.printStackTrace();
        }

        statement.close();
    }
}
