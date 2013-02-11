/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MenuItem;
import service.RestaurantService;

/**
 *
 * @author Drew
 */
@WebServlet(name = "RestaurantOrderServlet", urlPatterns = {"/RestaurantOrderServlet"})
public class RestaurantOrderServlet extends HttpServlet {

    private static final String destination = "/billDetailPage.jsp";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //get all the request parameters
        RestaurantService rs = new RestaurantService();
        List<MenuItem> currentMenuChoices = rs.getCurrentMenuChoices();
        List<MenuItem> currentOrder = new ArrayList<MenuItem>();
        String quantity;
        boolean add;
        
         //get quantities from the request and put into the current order
        for (MenuItem m:currentMenuChoices){
            quantity= (String)request.getParameter(m.getItemName());
            if (!quantity.isEmpty()){
                m.setItemQuantity(Integer.parseInt(quantity));
                add = currentOrder.add(m);
            }
        }
        
        rs.saveOrder(currentOrder);
        request.setAttribute("currentOrder", currentOrder);
        
        
        request.setAttribute("subtotal",rs.getSubtotal());
        request.setAttribute("tax", rs.getTax());
        request.setAttribute("total", rs.getTotal());
        request.setAttribute("suggestedTip", rs.getSuggestedTip());
        
        

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
