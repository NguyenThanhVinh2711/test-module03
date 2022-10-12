package controller;

import dao.StudentDAO;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createStudent(request, response);
                    break;
                case "edit":
                    editStudent(request, response);
                    break;
                case "find":
                    findByNameStudent(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
                case "edit":
                    showEditStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    displayStudent(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> studentList = studentDAO.selectAllStudent();
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent/list.jsp");
        dispatcher.forward(request, response);
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idStudent = Integer.parseInt(request.getParameter("idStudent"));
            String name = request.getParameter("name");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            int id_classRoom = Integer.parseInt(request.getParameter("id_classRoom"));
            Student newStudent = new Student(idStudent, name, dateOfBirth, address, phoneNumber, email, id_classRoom);
            studentDAO.editStudent(newStudent);

            RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditStudent(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idStudent = Integer.parseInt(request.getParameter("idStudent"));
            Student showStudent = studentDAO.getByIdStudent(idStudent);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent/edit.jsp");
            request.setAttribute("showEditStudent", showStudent);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idStudent = Integer.parseInt(request.getParameter("idStudent"));
            studentDAO.deleteStudent(idStudent);
            List<Student> studentList = studentDAO.selectAllStudent();
            request.setAttribute("studentList", studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response){
        try {
            String name = request.getParameter("name");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            int id_classRoom = Integer.parseInt(request.getParameter("id_classRoom"));
            Student student = new Student(name,dateOfBirth,address,phoneNumber,email,id_classRoom);
            studentDAO.createStudent(student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent/create.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreate(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        RequestDispatcher dispatcher= request.getRequestDispatcher("viewStudent/create.jsp");
        dispatcher.forward(request,response);
    }

    private void findByNameStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String name = request.getParameter("name");
        List<Student> findByName = new ArrayList<>();
        findByName = studentDAO.selectStudentByName(name);
        request.setAttribute("studentList",findByName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent/list.jsp");
        dispatcher.forward(request,response);
    }


}
