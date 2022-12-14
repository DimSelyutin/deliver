package by.htp.deliv.controller;

import java.io.IOException;
import java.io.PrintWriter;

import by.htp.deliv.connection.ConnectionPoolException;
import by.htp.deliv.connection.PoolConnection;
import by.htp.deliv.entity.Post;
import by.htp.deliv.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        if (session.getAttribute("userName") == null) {
            resp.sendRedirect("index.jsp");
        } else {
            


            String sql = "SELECT * FROM blog";

            PoolConnection poolConnection = new PoolConnection();
            try {
                poolConnection.initPoolData();
                Connection con = poolConnection.takeConnection();

                

                PreparedStatement preparedStatement = con.prepareStatement(sql);

                ResultSet rs = preparedStatement.executeQuery();
                
                List<Post> usersList = new ArrayList<>();
                
                while(rs.next()) {
                    Post post = new Post(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    
                    usersList.add(post);
                    
                }
                req.setAttribute("listUsers", usersList);
                
                req.getRequestDispatcher("/WEB-INF/keys/blog.jsp").forward(req, resp);
            } catch (ConnectionPoolException | SQLException e) {
                
                e.printStackTrace();
            }
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
