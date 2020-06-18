package xyz.vroided.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class JavaBeanDemo1 implements HttpSessionBindingListener {

    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(name+"被加到session中了");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(name+"被session踢出来了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaBeanDemo1(String name) {
        this.name = name;
    }
}