/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.RestaurantCalculator;

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
        
        ArrayList itemQtys= new ArrayList();
        
        
        String steakQty=(String)request.getParameter("steakQty");
        String lobsterQty=(String)request.getParameter("lobsterQty");
        String beerQty=(String)request.getParameter("beerQty");
        String saladQty=(String)request.getParameter("saladQty");
        
        itemQtys.add(steakQty);
        itemQtys.add(lobsterQty);
        itemQtys.add(beerQty);
        itemQtys.add(saladQty);
        
        // call method pass in list.  Retrieve bill object
        RestaurantCalculator rc = new RestaurantCalculator();
        
        //find prices for these items
//        double steakPrice=rc.getSteakPrice(steakQty);
//        double lobsterPrice=rc.getLobsterPrice(lobsterQty);
//        double beerPrice=rc.getBeerPrice(beerQty);
//        double saladPrice=rc.getSaladPrice(saladQty);
//        System.out.println(steakPrice);
//        System.out.println(lobsterPrice);
//        System.out.println(beerPrice);
//        System.out.println(saladPrice);
        
        request.setAttribute("steakPrice",rc.getSteakPrice(steakQty));
        request.setAttribute("lobsterPrice",rc.getLobsterPrice(lobsterQty));
        request.setAttribute("beerPrice",rc.getBeerPrice(beerQty));
        request.setAttribute("saladPrice",rc.getSaladPrice(saladQty));
        request.setAttribute("subtotal",rc.getSubtotal());
        request.setAttribute("tax", rc.getTax());
        request.setAttribute("total", rc.getTotal());
        request.setAttribute("suggestedTip", rc.getSuggestedTip());
        
        

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
