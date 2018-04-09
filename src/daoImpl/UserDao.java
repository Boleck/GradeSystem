package daoImpl;

import dao.IUserDao;
import databases.ConnectionManager;
import databases.ResultSetProcessor;
import entity.UserEntity;
import utils.UserUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IUserDao, ResultSetProcessor<UserEntity> {
    private ConnectionManager<UserEntity> connectionManager = new ConnectionManager<>();

    @Override
    public boolean isUserExist(String username) {
        return connectionManager.count("SELECT COUNT(*) FROM user WHERE username = ?", new Object[]{username}) == 1;
    }

    @Override
    public boolean isUserPasswordCorrect(String username, String password) {
        UserEntity user = connectionManager.getFirst("SELECT * FROM user WHERE username = ?", this, new Object[]{username});
        return UserUtils.check(password, user.getPassword());
    }

    @Override
    public String getUserNameById(int userId) {
        return connectionManager.getFirst("SELECT * FROM user WHERE id = ?",this, new Object[]{userId}).getUsername();
    }

    @Override
    public void setUserPassword(String password) {

    }

    @Override
    public void addUser(UserEntity user) {
        connectionManager.saveOrUpdate("INSERT INTO user (username, password) values (?, ?)", new Object[] {
                user.getUsername(), UserUtils.getSaltedHash(user.getPassword()) });
    }

    @Override
    public void deleteUser(int userId) {
        //
    }

    @Override
    public UserEntity getProcessedObject(ResultSet resultSet) throws SQLException {
        UserEntity user = new UserEntity();
        user.setId(resultSet.getInt("id"));
        user.setPassword(resultSet.getString("password"));
        user.setUsername(resultSet.getString("username"));
        return user;
    }
}
