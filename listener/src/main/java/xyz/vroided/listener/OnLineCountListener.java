package xyz.vroided.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if (onLineCount == null) {
            context.setAttribute("onLineCount", 1);
        } else {
            onLineCount++;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if (onLineCount == null) {
            context.setAttribute("onLineCount", 1);
        } else {
            onLineCount--;
            context.setAttribute("onLineCount", onLineCount);
        }
    }
}