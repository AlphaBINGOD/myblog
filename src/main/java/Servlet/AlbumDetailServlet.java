package Servlet;

import daoImpl.AlbumDaoImpl;
import daoImpl.PhotoDaoImpl;
import entity.Photo;

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
 * @Date 2018/6/15
 */
@WebServlet(value = "/pages/album/album_detail",loadOnStartup = 1)
public class AlbumDetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求里提交的相册id参数
        int albumId = Integer.parseInt(req.getParameter("albumId"));
        //数据库获取相关数据
        List<Photo> photoList = PhotoDaoImpl.getInstance().queryAlbumAllPhoto(albumId);
        //存入request域
        req.setAttribute("photoList",photoList);
        //转发到jsp
        req.getRequestDispatcher("/pages/album_detail.jsp").forward(req, resp);
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
