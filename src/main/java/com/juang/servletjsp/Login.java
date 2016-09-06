/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juang.servletjsp;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juang
 */
@WebServlet(name = "Login", urlPatterns = {"/login"}, initParams = {
    @WebInitParam(name = "action", value = "0")})
public class Login extends HttpServlet {

    private Integer param;

    @Override
    public void init(ServletConfig config) throws ServletException {
        param = Integer.parseInt(config.getInitParameter("action"));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (param) {
            case 0:
                System.out.println("masuk 0");
                request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
                break;
            case 1:
                System.out.println("masuk 1");
                response.sendRedirect(response.encodeRedirectURL(getServletContext().getContextPath() + "/home"));
                break;
            default:
                System.out.println("masuk default");
                request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
