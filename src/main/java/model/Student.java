package model;

import java.time.LocalDate;

public class Student  {
    private int idStudent;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private int id_classRoom;
    private String className;

    public Student(int idStudent) {
    }

    public Student(int idStudent, String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int id_classRoom, String className) {
        this.idStudent = idStudent;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id_classRoom = id_classRoom;
        this.className = className;
    }

    public Student(int id_student, String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, String className) {
        this.idStudent = idStudent;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id_classRoom = id_classRoom;
        this.className = className;
    }

    public Student(String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int id_classRoom) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id_classRoom = id_classRoom;
    }

    public Student(int idStudent, String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int id_classRoom) {
        this.idStudent = idStudent;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id_classRoom = id_classRoom;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_classRoom() {
        return id_classRoom;
    }

    public void setId_classRoom(int id_classRoom) {
        this.id_classRoom = id_classRoom;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
