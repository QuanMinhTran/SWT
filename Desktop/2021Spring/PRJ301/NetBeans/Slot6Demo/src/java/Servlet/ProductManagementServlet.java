/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAOS.ProductDAO;
import DTOS.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ProductManagementServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            //connect DB
            ProductDAO daoObject = new ProductDAO();
            
            //get data from product Table
            ArrayList<Product> dataFromDatabase = daoObject.getAllProducts();
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductManagementServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<a href='productform.html'> Create New Product</a>");
            out.println("<table border='1'>");
            out.println("<tr><td>Product ID</td> <td> Product Name</td> <td>Description</td> <td>Price</td> <td>Quantity</td> <td>Image URL</td></tr>");
            
            for(Product p: dataFromDatabase){
                out.println("<tr>");
                out.println("<td>"+p.getId()+"</td>");
                out.println("<td>"+p.getName()+"</td>");
                out.println("<td>"+p.getDescription()+"</td>");
                out.println("<td>"+p.getPrice()+"</td>");
                out.println("<td>"+p.getQuantity()+"</td>");
                out.println("<td>"+p.getImgURL()+"</td>");
                out.println("<td><a href='UpdateServlet?pid="+p.getId()+"'>Edit</a>"
                        + "| <a href='DeleteServlet?pid="+p.getId()+"'>Delete</a></td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            
//            out.println("<h1>Servlet ProductManagementServlet at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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




