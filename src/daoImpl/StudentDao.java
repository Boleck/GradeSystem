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
        return connectionManager.getAll("SELECT * FROM student WHERE group_id = ?",this, new Object[]{ groupId });
    }

    @Override
    public StudentEntity getStudentById(int studentId) {
        return connectionManager.getFirst("SELECT * FROM student WHERE id = ?",this, new Object[]{ studentId });
    }

    @Override
    public void deleteStudent(int studentId) {
        connectionManager.delete("DELETE FROM student WHERE id = ?", new Object[] { studentId });
    }

    @Override
    public void addStudent(StudentEntity student) {
        connectionManager.saveOrUpdate("INSERT INTO student (name, group_id) values (?, ?)", new Object[] {
        student.getFullName(), student.getGroupId() });
    }

    @Override
    public StudentEntity getProcessedObject(ResultSet resultSet) throws SQLException {
        StudentEntity student = new StudentEntity();
        student.setId(resultSet.getInt("id"));
        student.setFullName(resultSet.getString("name"));
        student.setGroupId(resultSet.getInt("group_id"));
        return student;
    }
}
