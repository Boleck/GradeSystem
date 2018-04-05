package databases;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetProcessor<T> {
    T getProcessedObject(ResultSet resultSet) throws SQLException;
}
