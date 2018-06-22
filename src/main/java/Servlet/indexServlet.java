package Servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import daoImpl.ArticleDaoImpl;
import entity.Article;

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
 * @Date 2018/6/4
 */
@WebServlet(value = "/index",loadOnStartup = 1)
public class indexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有需要在页面显示的数据,然后放到request对象里保存,在jsp里再取出来
//数据初始化-------------------------------------------------------------------------------------------------
        int recommendArticleNum = 5;
        int upToDateArticleNum = 5;
        int articleRowNum = 5;
//获得一个AtricleDaoImpl对象实例------------------------------------------------------------------------------
        ArticleDaoImpl articleDao = ArticleDaoImpl.getInstance();
//获取页面参数
        //获得页面传入的页码,根据这个页码才能查询对应的文章,如果获取不到传入的pageNum则设为默认值1
        int currentPage = req.getParameter("currentPage")!=null ? Integer.parseInt(req.getParameter("currentPage")) : 1;
        //验证页码合法性,主要是点击前一页后一页的时候可能出现的超出页码边界
        currentPage =  articleDao.checkPaginationLimit(currentPage,"article",articleRowNum);
//获取数据--------------------------------------------------------------------------------------------------
        List<Article> recommendArticles = articleDao.queryRecommendArticle(recommendArticleNum);
        List<Article> upToDateArticles  = articleDao.queryUpToDateArticle(upToDateArticleNum);
        //获取一页的文章
        List<Article> pageArticles = articleDao.queryPageArticlesById(currentPage,articleRowNum);
        //获取总页数
        int totalPage = articleDao.getTotalPage(articleRowNum);
//向request域传入查询到的数据----------------------------------------------------------------------------------
        req.setAttribute("recommendArticles",recommendArticles);  //栏目推荐
        req.setAttribute("upToDateArticles",upToDateArticles);      //最新文章
        req.setAttribute("pageArticles",pageArticles);      //单页文章
        req.setAttribute("totalPage",totalPage);        //返回分页对象
        req.setAttribute("currentPage",currentPage);    //这一点需要特别注意,因为前台不知道后台的页码范围,因此,将当前页码回传前台,然后前台更新自己的页码

//跳转到index.jsp--------------------------------------------------------------------------------------------
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
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
