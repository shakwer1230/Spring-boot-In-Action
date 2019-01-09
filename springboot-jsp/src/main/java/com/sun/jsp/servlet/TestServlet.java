package com.sun.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/8
 * @
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer=resp.getWriter();
        writer.write("执行TestServlet内的doGet方法成功！");
        writer.flush();
        writer.close();
    }
}
