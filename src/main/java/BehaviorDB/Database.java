package BehaviorDB;// Завдання №1 - створити утилітний клас для роботи з БД
// Створи клас-сінглтон BehaviorDB.Database, який інкапсулює у собі логіку для роботи з БД.
// Під час створення екземпляру цього класу має відбуватись підключення до СУБД та
//      зберігатись екземпляр Connection.
// Має бути можливість отримати Connection викликом методу getConnection().
// Наприклад, ось так:
//      Connection conn = BehaviorDB.Database.getInstance().getConnection();

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection conn;

    private Database() {
        try {
            String dbUrl = "jdbc:h2:./sql/test_db";
            Class.forName("org.h2.Driver"); // Загрузка драйвера БД
            this.conn = DriverManager.getConnection(dbUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

