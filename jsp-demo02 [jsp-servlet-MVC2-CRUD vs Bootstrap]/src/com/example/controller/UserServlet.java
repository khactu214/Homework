package com.example.controller;

import com.example.da.UserDAO;
import com.example.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    public void init() {userDAO = new UserDAO();}
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action){
                case "/new":
                    showNewForm(req,resp);
                    break;
                case "/insert":
                    insertUser(req,resp);
                    break;
                case "/delete":
                    deleteUser(req,resp);
                    break;
                case "/edit":
                    showEditForm(req,resp);
                    break;
                case "/update":
                    updateUser(req,resp);
                    break;
                default:
                    listUser(req,resp);
                    break;
            }
        }catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,IOException,ServletException,ClassNotFoundException {
        List<User> listUser = userDAO.selectAllUser();
        req.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(req,resp);
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,IOException,ClassNotFoundException{
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User book = new User(name,email,country);
        userDAO.updateUser(book);
        resp.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,ServletException,IOException,ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-form.jsp");
        req.setAttribute("user",existingUser);
        dispatcher.forward(req,resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,IOException,ClassNotFoundException{
        int id = Integer.parseInt(req.getParameter("id"));
        userDAO.deleteUser(id);
        resp.sendRedirect("list");
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException,IOException,ClassNotFoundException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User newUser = new User(name,email,country);
        userDAO.insertUser(newUser);
        resp.sendRedirect("list");
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(req,resp);
    }
}
