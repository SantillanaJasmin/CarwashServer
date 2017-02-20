/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jasmin
 */
public class AddCarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCarServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pst = null;

        int res = 20;
        
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a Connectiontion
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carwash", "root", "password");
          
            
            // Execute SQL query
            String sql;
            sql = "INSERT INTO cars (car_model, car_type, car_plate) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Honda");
            pst.setString(2, "A");
            pst.setString(3, "ABC 123");
            res = pst.executeUpdate();

            // Clean-up environment
            pst.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddCarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().write("Result: " + res);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String plate = request.getParameter("plate");
		
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a Connectiontion
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carwash", "root", "password");

            // Execute SQL query
            String sql;
            sql = "INSERT INTO cars(car_model, car_type, car_plate) VALUES (?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, model);
            pst.setString(2, type);
            pst.setString(3, plate);
            res = pst.executeUpdate();

            // Clean-up environment
            pst.close();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddCarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().write("Result: " + res);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
