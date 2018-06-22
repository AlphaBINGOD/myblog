package Servlet;

import daoImpl.AlbumDaoImpl;
import entity.Album;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/14
 */
@WebServlet(value = "/pages/album",loadOnStartup = 1)
public class AlbumServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有相册
        List<Album> albumList = AlbumDaoImpl.getInstance().queryAllAlbum();
        //将相册数据传入request域
        req.setAttribute("albumList",albumList);
        //转发到album.jsp
        req.getRequestDispatcher("/pages/album.jsp").forward(req,resp);
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
