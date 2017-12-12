package com.amukoski;

import com.amukoski.operators.FactoryOperator;
import com.amukoski.operators.Operator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer num1 = Integer.valueOf(req.getParameter("num1"));
        Integer num2 = Integer.valueOf(req.getParameter("num2"));
        String operation = req.getParameterValues("operation")[0];

        printResponse(resp, operation, num1, num2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer num1 = Integer.valueOf(req.getParameter("num1"));
        Integer num2 = Integer.valueOf(req.getParameter("num2"));
        String operation = req.getParameterValues("operation")[0];

        printResponse(resp, operation, num1, num2);
    }

    private void printResponse(HttpServletResponse resp, String operatorName, Integer... numbers) throws IOException {
        Operator operator = FactoryOperator.provideOperator(operatorName);
        Integer result = operator.apply(numbers);

        resp.setContentType("text/html");
        resp.getWriter().write(String.format("Operation '%s' on %s is %d", operatorName, Arrays.toString(numbers), result));
    }


}
