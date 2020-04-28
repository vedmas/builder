package jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JDBCTest {

    public static void main(String[] args) {
        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/test";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "123456";
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            connection.setAutoCommit(false);
            System.out.println("Соединение установлено");
            saveUsers(connection);
            connection.commit();
//            statement = connection.createStatement();
//            ResultSet resultSet = null;
//            resultSet = statement.executeQuery("CREATE TABLE public.users(id bigserial NOT NULL, name character varying, age integer, PRIMARY KEY(id))");

        } catch (Exception e) {
            log.error("Ошибка SQL", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Соединение разорвано");
                } catch (SQLException ex) {
                    log.error(ex.getMessage());
                }
            }
        }

    }
    private static void saveUsers(Connection connection) throws SQLException {
        try {
            PreparedStatement preparedStatement = preparedStatement = connection.prepareStatement("INSERT INTO users(name, age) VALUES (?, ?)");
            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1, "Bob" + i);
                preparedStatement.setInt(2, 25 + i);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException s) {
            log.error("Error save users", s);
            connection.rollback();
        }
    }
}
