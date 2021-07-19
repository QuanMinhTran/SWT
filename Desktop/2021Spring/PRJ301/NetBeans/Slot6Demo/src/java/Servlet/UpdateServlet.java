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
public class UpdateServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");

            String pid = request.getParameter("pid");

            ProductDAO dao = new ProductDAO();
            Product p = dao.getProductbyId(pid);

            out.println("<form action='UpdateServlet' method=\"POST\" name='fupdate'>");
            out.println("<table width=\"600px\" border=\"0px solid\">");
            out.println("<tr>");
                out.println("<td>ProductID:</td>");
                out.println("<td><input type=\"text\" name=\"id\" value='" +p.getId()+"' readonly/></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Name:</td>");
                out.println("<td><input type=\"text\" name=\"name\" value=\""+p.getName()+"\"></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Description:</td>");
                out.println("<td><textarea name=\"desc\" rows=\"5\" cols=\"50\">"+p.getDescription()+"</textarea></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Quantity:</td>");
                out.println("<td><input type=\"number\" name=\"quantity\" value=\""+p.getQuantity()+"\"></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Price:</td>");
                out.println("<td><input type=\"number\" name=\"price\" value=\""+p.getPrice()+"\"></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>ImageURL:</td>");
                out.println("<td><input type=\"text\" name=\"url\" value=\""+p.getImgURL()+"\"></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td colspan=\"2\" align =\"center\">");
                    out.println("<input type=\"submit\" value=\"Update\"/>");
                    out.println("<input type=\"reset\" value=\"Reset\"/>");
                out.println("</td>");
            out.println("</tr>");
                
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
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
        try{
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String desc = request.getParameter("desc");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String url = request.getParameter("url");
            
            Product p = new Product(id, name, desc, Integer.parseInt(quantity), Double.parseDouble(price), url);
            
            ProductDAO dao = new ProductDAO();
            if(dao.updateProduct(p))
            {
                response.sendRedirect("ProductManagementServlet");
            }
            else{
                response.sendRedirect("error.html");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
