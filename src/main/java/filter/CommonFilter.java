package filter;

import daoImpl.ArticleDaoImpl;
import daoImpl.CritiqueDaoImpl;
import entity.Article;
import entity.Critique;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/11
 */
@WebFilter("/pages/*")  //只拦截
public class CommonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("正在获取侧边栏数据");
        int recommendArticleNum = 5;
        int upToDateArticleNum = 5;
        int critiqueNum = 4;
        //通用-----------------------------------------------------------------------------------------------
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        ArticleDaoImpl articleDao = ArticleDaoImpl.getInstance();
        //获取点击排行文章
        List<Article> recommendArticles = articleDao.queryRecommendArticle(recommendArticleNum);
        //获取最新文章排行
        List<Article> upToDateArticles = articleDao.queryUpToDateArticle(upToDateArticleNum);
        //获取最新评论数据
        List<Critique> upToDateCritiques = CritiqueDaoImpl.getInstance().queryUpToDateCritique(critiqueNum);
        //向requeset对象传入获取到的数据,这个要根据需要是传到哪个域,如果是不经常更新的数据,就传到session域吧
        req.setAttribute("recommendArticles",recommendArticles);
        req.setAttribute("upToDateArticles",upToDateArticles);
        req.setAttribute("upToDateCritiques",upToDateCritiques);
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
