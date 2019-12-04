package it.distributedsystemsm.servlet;

import it.distributedsystemsm.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Servlet-based session-scoped counter
 * 
 * @author maschmid
 *
 */
@SuppressWarnings("serial")
@WebServlet("/EJBCounter")
public class EjbCounterServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(EjbCounterServlet.class);
    
    @Inject
    Counter counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        
        String servletId = (String)req.getServletContext().getAttribute("servletId");

        long count = counter.increment();

        PrintWriter writer = resp.getWriter();
        writer.println(servletId + " " + count);
        writer.close();

        logger.info("{} - {}",servletId,count);

        //System.out.println(servletId + " - " + count);
    }
}
