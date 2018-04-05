package daoImpl;

import dao.IStudentDao;
import databases.ConnectionManager;
import databases.ResultSetProcessor;
import entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao implements IStudentDao, ResultSetProcessor<StudentEntity> {
    private ConnectionManager<StudentEntity> connectionManager = new ConnectionManager<>();
    @Override
    public List<StudentEntity> getAllStudents() {
        return connectionManager.getAll("SELECT * FROM student", this);
    }

    @Override
    public List<StudentEntity> getStudentsByGroupId(int groupId) {
        return null;
    }

    @Override
    public StudentEntity getStudentById(int studentId) {
        return null;
    }

    @Override
    public void deleteStudent(int studentId) {

    }

    @Override
    public void updateStudent(StudentEntity student) {

    }

    @Override
    public StudentEntity getProcessedObject(ResultSet resultSet) throws SQLException {
        StudentEntity student = new StudentEntity();
        student.setFullName(resultSet.getString("Name"));
        student.setGroupId(resultSet.getInt("GroupId"));
        student.setFullName(resultSet.getString("Name"));
        return student;
    }
}
