package dao;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> selectAllStudent ();
    List<Student> selectAllStudentByIdClass (int id_classRoom);
    Student getByIdStudent(int idStudent);
    boolean editStudent(Student student);
    boolean deleteStudent(int idStudent);
    List<Student> selectStudentByName(String name);
}
