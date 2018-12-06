/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.web;

import edu.iit.sat.itmd4515.stirpude.domain.Owner;
import edu.iit.sat.itmd4515.stirpude.domain.StoreInventory;
import edu.iit.sat.itmd4515.stirpude.service.OwnerService;
import edu.iit.sat.itmd4515.stirpude.service.StoreInventoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author shruti
 */
@WebServlet(name = "OwnerServletwithoutServlet", urlPatterns = {"/OwnerWelcome","/url2","/ow/welcome1"})

public class OwnerServletwithoutSecure extends HttpServlet {

    @Resource
    Validator validator;
    
   // @PersistenceContext(unitName ="itmd4515") private EntityManager em;
    
    @EJB 
    OwnerService owSvc;
    
    @EJB 
    StoreInventoryService siSvc;

    private static final Logger LOG = Logger.getLogger(OwnerServletwithoutSecure.class.getName());
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("This is inside servlets");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OwnerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OwnerServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Welcome" + request.getRemoteUser() + "</h2>");
            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");
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
        LOG.info("Inside the doGet method");
          System.out.println("This is inside servlets");
         System.out.println("This is inside servlets");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OwnerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OwnerServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Welcome" + request.getRemoteUser() + "</h2>");
            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");
            out.println("</body>");
            out.println("</html>");
        }
        /*for(Owner ow : owSvc.findAll()){
            
            LOG.info("The owners list in the store inventory:"+ow.toString());
            
        }
        
        for(StoreInventory si : siSvc.findAll()){
            
            LOG.info("The store inventory list :"+si.toString());
            
        }
        
        
        //response.sendRedirect("newownerform.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/newownerform.jsp");
        dispatcher.forward(request, response);*/
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
        System.out.println("This is inside servlets");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OwnerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OwnerServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>Welcome" + request.getRemoteUser() + "</h2>");
            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");
            out.println("</body>");
            out.println("</html>");
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
