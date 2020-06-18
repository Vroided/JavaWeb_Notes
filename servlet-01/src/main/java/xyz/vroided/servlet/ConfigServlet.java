package xyz.vroided.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigServlet extends HttpServlet {

    private ServletConfig config;

    /**
     * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
     * 会自动将这些初始化参数封装到ServletConfig对象中，
     * 在调用servlet的init方法时，将ServletConfig对象传递给servlet。
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取在web.xml中配置的初始化参数
        String paramVal = this.config.getInitParameter("name");//获取指定的初始化参数
        resp.getWriter().print(paramVal);

        resp.getWriter().print("<hr/>");
        //获取所有的初始化参数
        Enumeration e = config.getInitParameterNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            String value = config.getInitParameter(name);
            resp.getWriter().print(name + "=" + value + "<br/>");
        }
        PrintWriter writer = resp.getWriter();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

}