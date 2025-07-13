package behavior.db;//Завдання №3 - створити клас для наповнення таблиць БД
//Створи клас з назвою BehaviorDB.DatabasePopulateService.
// У цьому класі має бути метод public static void main(String[] args),
//      який зчитуватиме файл sql/populate_db.sql і виконуватиме запити з цього класу у БД.
//
//Для роботи з БД використовуй написаний раніше тобою клас BehaviorDB.Database.
//Результат запуску цього класу - наповнені таблиці бази даних.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = Database.getInstance().getConnection();

        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of("sql/populate_db.sql"));
            statement.executeUpdate(sql);
        }  catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
