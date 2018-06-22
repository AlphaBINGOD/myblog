package Servlet;

import daoImpl.ArticleDaoImpl;
import daoImpl.BaseDao;
import daoImpl.CritiqueDaoImpl;
import entity.Article;
import entity.Critique;
import utils.PaginationUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/4
 */
@WebServlet(value = "/pages/article",loadOnStartup = 1)
public class ArticleServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
 //初始化分页数据-------------------------------------------------------------------------------------
        int articleRowNum = 5;
        String url = "article";
        String targetURL = "/pages/article.jsp";  //默认的是慢生活页面
 //数据获取请求数据------------------------------------------------------------------------------------
        //获得页面传入的页码,根据这个页码才能查询对应的文章,如果获取不到传入的pageNum则设为默认值1
        int currentPage = req.getParameter("currentPage")!=null ? Integer.parseInt(req.getParameter("currentPage")) : 1;
        //获得需要查询的id值,没有id值说明不是查看具体文章
        int id = req.getParameter("id")!=null? Integer.parseInt(req.getParameter("id")) : -1;

 //实例化一个对象,用于各种article查询---------------------------------------------------------------------
        ArticleDaoImpl articleDao = ArticleDaoImpl.getInstance();
 //根据id值判断要转发到哪个页面,id值如果不等于-1,即有传入参数,则说明要转发到文章细节,没值则说明是单纯的文章展示,同时决定需要传输什么参数
        if(id != -1){
            targetURL = "/pages/article_detail.jsp";
            //浏览数自增1
            articleDao.articleBrowseIncrement(id);
            //根据id查询一篇文章
            Article idAriticle = articleDao.queryOneArticlebyId(id);
            //查询前一页
            Article prevArticle = articleDao.queryPrevArticle(id);
            //查询后一页
            Article nextArticle = articleDao.queryNextArticle(id);

            req.setAttribute("idArticle",idAriticle);       //通过id获得的idArticle
            req.setAttribute("prevArticle",prevArticle);
            req.setAttribute("nextArticle",nextArticle);
        } else{
            //获取总页数
            int totalPage = articleDao.getTotalPage(articleRowNum);
            //验证页码合法性,主要是点击前一页后一页的时候可能出现的超出页码边界
            currentPage =  articleDao.checkPaginationLimit(currentPage,"article",articleRowNum);
            //获取一页的文章
            List<Article> pageArticles = articleDao.queryPageArticlesById(currentPage,articleRowNum);
            //传入request域
            req.setAttribute("pageArticles",pageArticles);
            req.setAttribute("totalPage",totalPage);        //返回分页对象
            req.setAttribute("currentPage",currentPage);    //这一点需要特别注意,因为前台不知道后台的页码范围,因此,将当前页码回传前台,然后前台更新自己的页码
            req.setAttribute("url",url);                    //针对慢生活,需要分页,但是分页部分jsp作为一个通用组件,需要额外提供当前请求参数
        }

 //转发到页面-------------------------------------------------------------------------------------------
        req.getRequestDispatcher(targetURL).forward(req,res);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
