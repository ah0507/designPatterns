package com.chensee.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyServlet extends HttpServlet {

    private ServletConfig servletConfig;

    public MyServlet() {

    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
        System.out.println("初始化加载。。。");
        //servletConfig可以获得servlet的信息
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        // 获取Servlet上下文对象
        ServletContext servletContext = servletConfig.getServletContext();

        String contextPath = servletContext.getContextPath();
        String user = servletContext.getInitParameter("user");
        System.out.println(contextPath);
        System.out.println(user);

    }

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            //response.getWriter().write(123);
            //request.getRequestDispatcher("main.jsp").forward(request, response);
        }*/

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ServletContext servletContext = servletConfig.getServletContext();
        //读web.xml
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/web.xml");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String s = null;
            while ((s=bufferedReader.readLine())!=null){
                response.getWriter().write(s);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("已销毁。。。");
    }

}
