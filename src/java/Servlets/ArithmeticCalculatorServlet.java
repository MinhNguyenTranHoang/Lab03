/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MINH
 */
@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/ArithmeticCalculatorServlet"})
public class ArithmeticCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GET requests will end up here!

        // Load a JSP from this servlet
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        // After a JSP has been loaded, stop the code call
        return; // VERY IMPORTANT!
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String v1 = request.getParameter("v1");
        String v2 = request.getParameter("v2");
        String v3 = request.getParameter("v3");
        String message="0";
        int result;
        if (v1.equals("") && v2.equals("")) {
            message = "--";
        }else if(v1.equals("") || v2.equals("")){
            message = "invalid";
        }else{
            try {
                int value1 = Integer.parseInt(v1);
                int value2 = Integer.parseInt(v2);
                result = Integer.parseInt(message);
                 switch (v3) {
            case "+":   
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "%":                    
                result = value1 % value2;
                break;
            default:
                break;
        }
                 message=String.valueOf(result);
            } catch (NumberFormatException e) {
                message = "invalid";
            }
        }
        request.setAttribute("message", message);
        request.setAttribute("val1", v1);
        request.setAttribute("val2", v2);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;

    }
}
