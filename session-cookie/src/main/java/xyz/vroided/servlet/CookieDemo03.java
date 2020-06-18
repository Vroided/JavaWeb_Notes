package xyz.vroided.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //Cookie,服务器端从客户端获取呀;
        Cookie[] cookies = req.getCookies(); //这里返回数组，说明Cookie可能存在多个
        PrintWriter out = resp.getWriter();
        //判断Cookie,是否存在
        if (cookies != null) {
            //如果存在怎么办
            out.write("上一次访间的人是:");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("name")) {
//                    System.out.println(cookie.getValue());
                    out.write(cookie.getValue());
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }
//        Cookie cookie = new Cookie("name", "Vroided");
        Cookie cookie = new Cookie("name", "乌波");
//        编码解码
//        URLEncoder.encode("乌波","utf-8")
//        URLDecoder.decode(cookie.getValue(),"UTF-8")
//        Cookie cookie = new Cookie("name", URLEncoder.encode("乌波", "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
