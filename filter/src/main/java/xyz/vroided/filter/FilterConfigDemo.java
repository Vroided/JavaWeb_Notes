package xyz.vroided.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class FilterConfigDemo implements Filter {

    /* 过滤器初始化
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("----过滤器初始化----");
        /**
         *  <filter>
                  <filter-name>FilterConfigDemo</filter-name>
                  <filter-class>xyz.vroided.filter.FilterConfigDemo</filter-class>
                  <!--配置FilterConfigDemo过滤器的初始化参数-->
                  <init-param>
                      <param-name>name</param-name>
                      <param-value>admin</param-value>
                  </init-param>
                  <init-param>
                      <param-name>password</param-name>
                      <param-value>123456</param-value>
                  </init-param>
            </filter>

             <filter-mapping>
                  <filter-name>FilterConfigDemo</filter-name>
                  <!--“/*”表示拦截所有的请求 -->
                  <url-pattern>/*</url-pattern>
             </filter-mapping>
         */
        //得到过滤器的名字
        String filterName = filterConfig.getFilterName();
        //得到在web.xml文件中配置的初始化参数
        String initParam1 = filterConfig.getInitParameter("name");
        String initParam2 = filterConfig.getInitParameter("password");
        //返回过滤器的所有初始化参数的名字的枚举集合。
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();

        System.out.println(filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterConfigDemo执行前！！！");
        chain.doFilter(request, response);  //让目标资源执行，放行
        System.out.println("FilterConfigDemo执行后！！！");
    }

    @Override
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}