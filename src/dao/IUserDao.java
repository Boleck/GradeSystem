package dao;

import entity.UserEntity;

public interface IUserDao {
    boolean isUserExist(String username);
    boolean isUserPasswordCorrect(String username, String password);
    String getUserNameById(int userId);
    void setUserPassword(String password);
    void addUser(UserEntity user);
    void deleteUser(int userId);
}
