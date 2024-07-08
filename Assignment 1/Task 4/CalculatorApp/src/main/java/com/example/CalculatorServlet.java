package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String display = request.getParameter("display");
        try {
            double result = evaluate(display);
            request.setAttribute("result", result);
        } catch (Exception e) {
            request.setAttribute("result", "Error");
        }
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }

    private double evaluate(String expression) {
        
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return Double.valueOf(engine.eval(expression).toString());
        } catch (Exception e) {
            throw new RuntimeException("Invalid expression");
        }
    }
}
