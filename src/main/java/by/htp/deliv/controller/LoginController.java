package by.htp.deliv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger.Level;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.deliv.connection.ConnectionPoolException;
import by.htp.deliv.connection.Logger;
import by.htp.deliv.connection.PoolConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    public static final Logger LOG = new Logger();

    public LoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("userName") != null) {
            resp.sendRedirect("index.jsp");
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
         
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("userName") != null) {
            resp.sendRedirect("index.jsp");
        } else {

            String login = req.getParameter("login");
            String password = req.getParameter("password");
            PrintWriter out = resp.getWriter();

            try {
                if (!checkPass(login, password, resp)) {

                    req.getRequestDispatcher("index.jsp").forward(req, resp); // RequestDispatcher -> forward(req,resp)

                } else {
                    // Get session
                    session = req.getSession();
                    // Save the user name to the session
                    session.setAttribute("userName", login);
                    Cookie cookie = new Cookie("userName", login);

                    
                    resp.sendRedirect("index.jsp");

                }
            } catch (ConnectionPoolException | SQLException e) {

                out.println(e);
                LOG.log(Level.INFO, e.toString());

            }
        }
    }

    private boolean checkPass(String _login, String _password, HttpServletResponse resp)
            throws IOException, ConnectionPoolException, SQLException {
        PrintWriter out = resp.getWriter();

        boolean result = false;
        String sql = "SELECT * FROM user WHERE `login` = '" + _login + "'";
        try {
            PoolConnection conPool = new PoolConnection();
            conPool.initPoolData();
            Connection conn = conPool.takeConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                if (resultSet.getString(4).equals(_password)) {
                    result = true;
                }
            }
        } catch (Exception e) {
            out.println(e);
        }
        return result;

    }

}
