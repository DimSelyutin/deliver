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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginController extends HttpServlet{

    public static final Logger LOG = new Logger();
    
    public LoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();

        try {
            if (!checkPass(login, password, resp)) {

               req.getRequestDispatcher("/").forward(req, resp);            //RequestDispatcher -> forward(req,resp)

            } else {
                // Get session
                HttpSession session = req.getSession();
                // Save the user name to the session
                session.setAttribute("userName", login);
                LOG.log(Level.INFO, "Succes login");

                req.getRequestDispatcher("/index.jsp").forward(req, resp);

            }
        } catch (ConnectionPoolException | SQLException e) {
            out.println(e);
            LOG.log(Level.INFO, "Error");

        }
        out.close();
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