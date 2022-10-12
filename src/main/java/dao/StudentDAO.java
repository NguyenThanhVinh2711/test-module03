package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import static connectionDB.ConnectionDB.getConnection;

public class StudentDAO implements IStudentDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Student> selectAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            String query = "SELECT * FROM student_class";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,idStudent);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String className = resultSet.getString("className");
//                int id_classRoom = resultSet.getInt("id_classRoom");
                studentList.add(new Student(idStudent, name, dateOfBirth, address, phoneNumber, email, className));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Student> selectAllStudentByIdClass(int id_classRoom) {
        List<Student> studentList = new ArrayList<>();
        try {
            String query = "select * from student where id_classRoom = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_classRoom);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_Student = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
//                int id_classRoom = resultSet.getInt("id_classRoom");
                String className = resultSet.getString("className");
                studentList.add(new Student(id_Student, name, dateOfBirth, address, phoneNumber, email, className));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student getByIdStudent(int idStudent) {
        String query = "select * from student where idStudent = ?";
        Student student = null;
        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idStudent);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int id_classRoom = resultSet.getInt("id_classRoom");
                student = new Student(name,dateOfBirth,address,phoneNumber,email,id_classRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean editStudent(Student student) {
        boolean rowEdit = false;
        try {
            String query = "update student set name =? ,dateOfBirth = ?,address = ?,phoneNumber = ?,email = ? , id_classRoom = ? where idStudent = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getId_classRoom());
            preparedStatement.setInt(7,student.getIdStudent());
            rowEdit = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowEdit;
    }

    @Override
    public boolean deleteStudent(int idStudent) {
        boolean rowStudent = false;
        try {
            String query = "delete from student where idStudent = ?";
            connection = getConnection();
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,idStudent);
            rowStudent = preparedStatement.executeUpdate() >0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStudent;
    }

    public void createStudent (Student student){
        try {
            String query = "insert into student (name,dateOfBirth,address,phoneNumber,email, id_classRoom) values (?,?,?,?,?,?);";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getId_classRoom());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> selectStudentByName(String name) {
        List<Student> findNameStudent = new ArrayList<>();
        try {
            String query = "select * from student where name like ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                findNameStudent.add(new Student(resultSet.getInt("idStudent")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findNameStudent;
    }
}
