package dao;

import entity.Article;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public interface ArticleDao {
    //查询所有文章-列表
    List<Article> queryAllArticles();
    //查询最新文章-列表,展示标题列表
    List<Article> queryUpToDateArticle(int articleNum);
    //查询推荐文章-列表,展示6条
    List<Article> queryRecommendArticle(int articleNum);
    //按页查询当前页的所有文章,每页5条数据
    List<Article> queryPageArticlesById(int page, int articleNum);
    //页码合法性检查
    public int checkPaginationLimit(int page,int rowNum);
    //按id查询一篇文章
    Article queryArticleById(int id);
    //查询前一篇文章,用于翻页提示
    Article queryPrevArticle(int id);
    //查询下一篇文章,翻页提示
    Article queryNextArticle(int id);
    //查询


    //改---------------------------------------------------------------
    //
    int articleBrowseIncrement(int id);
}
