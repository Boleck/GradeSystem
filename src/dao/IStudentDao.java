package dao;

import entity.StudentEntity;

import java.util.List;

public interface IStudentDao {
    List<StudentEntity> getAllStudents();
    List<StudentEntity> getStudentsByGroupId(int groupId);
    StudentEntity getStudentById(int studentId);
    void deleteStudent(int studentId);
    void updateStudent(StudentEntity student);
}
