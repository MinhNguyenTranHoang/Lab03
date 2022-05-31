/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MINH
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GET requests will end up here!

        // Load a JSP from this servlet
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        // After a JSP has been loaded, stop the code call
        return; // VERY IMPORTANT!
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // POST requests will end up here!

        // Capture the incoming parameters from the JSP
        String age = request.getParameter("age");
        String message;
        //System.out.println(age);
        // Set attributes in the request object, to be forwarded to the JSP
        //request.setAttribute("message", age);
        if (age.equals("")) {
            message = "You must give your current age.";
        } else {
            try {
                int intValue = Integer.parseInt(age);
                if(intValue<0){
                    message = "You weren't born yet.";
                }else{
                intValue++;
                message = "Your age next birthday will be " + intValue;
                }
            } catch (NumberFormatException e) {
                message = "You must enter a number.";
            }
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;

//        request.setAttribute("lastName", lastname);
//        
//        // Validation
//        if( firstname == null || firstname.equals("") || lastname == null || lastname.equals("") ){
//            // if validation fails:
//            // Set up an error message
//            String message = "Please enter both a first and last name.";
//            // put the error message into the request object as an attribute
//            request.setAttribute("message", message);
//            // load the form once again
//            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
//            // after a JSP has been loaded, stop the code call
//            return;
//        }
    }

}
