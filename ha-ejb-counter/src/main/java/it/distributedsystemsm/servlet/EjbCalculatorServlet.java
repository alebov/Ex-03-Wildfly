package it.distributedsystemsm.servlet;

import it.distributedsystemsm.model.Calculator;
import it.distributedsystemsm.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@SuppressWarnings("serial")
@WebServlet("/EJBCalculator")
public class EjbCalculatorServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(EjbCalculatorServlet.class);

    @Inject
    Calculator calculator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        String servletId = (String)req.getServletContext().getAttribute("servletId");

        String operation = req.getParameter("operation");
        if(operation == null) {
            PrintWriter writer = resp.getWriter();
            writer.println("<p>Servlet id: " + servletId + "<p/>");
            writer.println("<p>Current value: " + calculator.getValue() + "<p/>");
        }
        else {
            long operand = Long.valueOf(req.getParameter("operand"));
            long result;

            System.out.println(operand);
            System.out.println(operation);

            switch (operation.charAt(0)) {
                case '+':
                    result = calculator.sum(operand);
                    break;
                case '-':
                    result = calculator.subtract(operand);
                    break;
                case '*':
                    result = calculator.multiply(operand);
                    break;
                case '/':
                    result = calculator.divide(operand);
                    break;
                default:
                    result = calculator.getValue();
                    break;
            }

            PrintWriter writer = resp.getWriter();
            writer.println("<p>Servlet id: " + servletId + "<p/>");
            writer.println("<p>Current value: " + result + "<p/>");

            logger.info("{} - {}", servletId, result);
        }
        //System.out.println(servletId + " - " + count);
    }

}