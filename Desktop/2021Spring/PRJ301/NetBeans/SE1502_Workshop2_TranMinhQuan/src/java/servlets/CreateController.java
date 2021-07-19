/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import daos.LaptopDAO;
import dtos.Laptops;
import dtos.LaptopsErrorObject;
import dtos.Suppliers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CreateController extends HttpServlet {
private static final String SUCCESS = "ListController";
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "LoadSupplierController";

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
        String url = ERROR;
        try{
            String id = request.getParameter("ID");
            String name = request.getParameter("LaptopName");
            String TI = request.getParameter("TechnicalInformation");
            String year = request.getParameter("YearOfManufacture");
            String producer = request.getParameter("Producer");
            String status = request.getParameter("Status");
            String supp = request.getParameter("SupplierID");
            boolean valid = true;
            LaptopsErrorObject errorObj = new LaptopsErrorObject();
            if(id.trim().isEmpty()){
                errorObj.setIdError("ID is not supposed to be empty");
                valid = false;
            }
            if(name.trim().isEmpty()){
                errorObj.setIdError("Laptop name is not supposed to be empty");
                valid = false;
            }
            if(!name.trim().isEmpty() && name.length() < 6){
                errorObj.setIdError("Name must be greater than 6 characters");
                valid = false;
            }
            if(TI.trim().isEmpty()){
                errorObj.setIdError("Technical inforamtion is not supposed to be empty");
                valid = false;
            }
            if(year.trim().isEmpty()){
                errorObj.setIdError("Year is not supposed to be empty");
                valid = false;
            }
            if(producer.trim().isEmpty()){
                errorObj.setIdError("Producer is not supposed to be empty");
                valid = false;
            }
            if(status.trim().isEmpty()){
                errorObj.setIdError("Status is not supposed to be empty");
                valid = false;
            }
            LaptopDAO dao = new LaptopDAO();
            if(dao.GetLaptopByID(id) != null){
                errorObj.setIdError("ID is existed!");
                valid = false;
            }
            Suppliers supplier = new Suppliers(supp.split("-")[0].trim(), supp.split("-")[1].trim());
            Laptops laptop = new Laptops(id, name, TI, Integer.parseInt(year), producer, status, supplier);
            
            if(valid){
                if(dao.addLaptop(laptop)){
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert Failed!");
                }
            } else{
//                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e){
            log("ERROR at CreateController: " + e.getMessage());
        }
        finally{
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
