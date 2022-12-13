package by.htp.deliv.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.htp.deliv.connection.ConnectionPoolException;
import by.htp.deliv.connection.PoolConnection;
import by.htp.deliv.entity.User;
import by.htp.deliv.exception.ValidationException;
import by.htp.deliv.service.Validation;

public class RegistrationController extends HttpServlet {

    private Validation valid;

    public RegistrationController() {
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
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();

        try {

            if (checkUserInBase(login)) {
                out.println("Login is occupide");
            } else {
                User user = new User(login, password, phone);  

                writeUserInBase(user);

                out.println("New user was created!"); 

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);

            }

        } catch (ValidationException e ){
            out.println(e);
        } catch (ConnectionPoolException | SQLException e) {
            out.println("Somthing went wrong :(");
        }

    }

    private boolean checkUserInBase(String _login) throws ConnectionPoolException, SQLException {
        boolean result = false;
        String sql = "SELECT * FROM user WHERE `login` = '" + _login + "'";

        PoolConnection conPool = new PoolConnection();
        conPool.initPoolData();
        Connection conn = conPool.takeConnection();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        result = resultSet.next();
        conPool.closeConnection(conn, preparedStatement);
        return result;
    }

    private void writeUserInBase(User user) throws ConnectionPoolException, SQLException, ValidationException {


       Validation.ValidationBuilder vald = new Validation.ValidationBuilder(user);
       valid = vald.validLogin().validPhone().validPassword().build();
       
        if (!valid.getUncorrectFieldName().isEmpty()) { 
            throw new ValidationException("Uncorrect input: "+valid.getUncorrectFieldName().toString());
        } else {
            
            String sql = "INSERT INTO `user` (`login`, `phone`, `password`) VALUES ('"+user.getLogin()+"','"+user.getPhone()+"','"+user.getPassword()+"')";
            PoolConnection conPool = new PoolConnection();
            conPool.initPoolData();
            Connection conn = conPool.takeConnection();
            
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            conPool.closeConnection(conn, statement);
        }
    }

    
}
