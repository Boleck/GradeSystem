package databases;


import com.mysql.jdbc.Connection;
import daoImpl.UserDao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager<T> {
    private static String url = "jdbc:mysql://localhost:3306/gradesystem";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "jestem glodny!";



    public static Connection getConnection(){
        //TODO: connection pooling
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            //TODO: better logging
            e.printStackTrace();
        } catch (SQLException e) {
            //TODO: better logging
            e.printStackTrace();
        }
        return conn;
    }

    public void saveOrUpdate(String sqlStatement, Object[] args) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //TODO: better logging
            e.printStackTrace();
        }
    }

    public List<T> getAll(String sqlStatement,
                          ResultSetProcessor<T> resultSetProcessor) {
        return getAll(sqlStatement, resultSetProcessor, new Object[] {});
    }

    public T getFirst(String sqlStatement,
                          ResultSetProcessor<T> resultSetProcessor, Object[] args) {
        return getAll(sqlStatement + " LIMIT 1",resultSetProcessor,args).get(0);
    }


    public List<T> getAll(String sqlStatement,
                          ResultSetProcessor<T> resultSetProcessor, Object[] args) {

        List<T> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(resultSetProcessor.getProcessedObject(resultSet));
                }
            }

        } catch (Exception e) {
            //TODO: better logging
            e.printStackTrace();
        }

        return list;
    }

    public void deleteAll(String sqlStatement) {
        delete(sqlStatement, new Object[] {});

    }

    public void delete(String sqlStatement, Object[] args) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)){

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            //TODO: better logging
            e.printStackTrace();
        }
    }


    public int count(String sqlStatement, Object[] args) {
        int count = 0;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("COUNT(*)");
                }
            }

        } catch (Exception e) {
            //TODO: better logging
            e.printStackTrace();
        }

        return count;
    }
}
