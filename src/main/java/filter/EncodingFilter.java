package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/12
 */
@WebFilter(urlPatterns = "/*",initParams = {@WebInitParam(name = "encoding",value = "UTF-8")} )
public class EncodingFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //获取filter里的初始化参数值,就是web.xml里的filter初始化参数
        String encoding = filterConfig.getInitParameter("encoding");
        //对请求和响应
        if(null!=encoding&& !encoding.equals("")){
            req.setCharacterEncoding(encoding);
            //设置服务器与浏览器的编码格式保持一致
            resp.setCharacterEncoding(encoding);

            resp.setContentType("text/html;charset=" + encoding);
        }
        //过滤器链条传递,按web.xml里的过滤器顺序
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
