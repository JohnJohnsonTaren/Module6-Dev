// Завдання №4 - створити клас для вибірки даних з БД
// Створи клас з назвою DatabaseQueryService.
// У цьому класі мають бути методи для кожного файлу з SELECT виразом з попереднього завдання.
// Кожний метод має:
//     - зчитувати відповідний .sql файл
//     - повертати потрібний результат
// Кожний метод називай згідно Java Code Conventions.
// Зверни увагу на коректний тип значення, що повертатиме метод.
// Наприклад, для файлу find_max_projects_client сигнатура методу
//      виглядатиме List<MaxProjectCountClient> findMaxProjectsClient().
// При цьому клас MaxProjectCountClient необхідно описати, наприклад:
//      public class MaxProjectCountClient {
//          private String name;
//          private int projectCount;
//      }
//
// Для роботи з БД використовуй написаний раніше тобою клас Database.
// Результат виконання завдання - методи для кожного SELECT запиту,
//      які можна викликати, наприклад, наступним чином:
//      List<MaxProjectCountClient> maxProjectCountClients =
//          new DatabaseQueryService().findMaxProjectsClient();
// Запусти так кожний метод, і переконайсь, що він повертає коректну інформацію
//      і під час запуску ніде не виникають Exceptions.

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() throws Exception {
        List<MaxProjectCountClient> result = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();

        String sqlQuery = Files.readString(Paths.get("sql/find_max_projects_client.sql"));
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String clientName = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                result.add(new MaxProjectCountClient(clientName, projectCount));


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        resultSet.close();
        statement.close();
        return result;
    }

    public static void main(String[] args) throws Exception {
        DatabaseInitService.main(args); // Ініціалізація структури БД

        DatabasePopulateService.main(args); // Наповнення БД даними

        DatabaseQueryService queryService = new DatabaseQueryService(); // Запуск DatabaseQueryService
        List<MaxProjectCountClient> maxProjectClients = queryService.findMaxProjectsClient();

        for (MaxProjectCountClient client: maxProjectClients) {
            System.out.println(client);
        }

        Database.getInstance().close();
    }
}
