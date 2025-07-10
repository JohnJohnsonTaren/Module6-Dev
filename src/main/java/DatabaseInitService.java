// Завдання №2 - створити клас для ініціалізації структури БД
// Створи клас з назвою DatabaseInitService.
// У цьому класі має бути метод public static void main(String[] args),
//      який зчитуватиме файл sql/init_db.sql і виконуватиме запити з цього класу у БД.
//
// Для роботи з БД використовуй написаний раніше тобою клас Database.
// Результат запуску цього класу - проініцалізована база даних
//      з коректно створеними таблицями та зв'язками між цими таблицями.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();

        try {
            String sql = Files.readString(Path.of("sql/init_db.sql"));
            Connection conn = Database.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        statement.close();
    }
}

