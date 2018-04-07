package dao;

public interface IUserDao {
    boolean isUserExist(String username);
    boolean isUserPasswordCorrect(String username, String password);
    String getUserNameById(int id);
    boolean setUserPassword(String password);
}
