package Servlet;

import daoImpl.MeDaoImpl;
import entity.Me;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zsb@myblog
 * @Description:    <关于我>页面
 * @Modified By:
 * @Date 2018/6/10
 */
@WebServlet(value = "/pages/aboutMe",loadOnStartup = 1)
public class AboutMeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//获取关于我的数据
        MeDaoImpl meDao = MeDaoImpl.getMeDaoImpl();
//查询数据库,一个me
        Me me = meDao.queryMe();
//向request域里添加属性
        req.setAttribute("me",me);
//跳转页面
        req.getRequestDispatcher("/pages/aboutMe.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
