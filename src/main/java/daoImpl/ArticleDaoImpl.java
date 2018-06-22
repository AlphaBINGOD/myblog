package daoImpl;

import dao.ArticleDao;
import entity.Article;
import utils.PaginationUtils;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description: 包含各种查询方法, 使用单例模式设计
 * @Modified By:
 * @Date 2018/6/2
 */
public class ArticleDaoImpl extends BaseDao implements ArticleDao {

    private  static ArticleDaoImpl articleDaoImpl = null;

    private ArticleDaoImpl(){ }

    //单例模式,用于获得实例,防止线程竞争导致产生多个实例,因此增加了一个同步
    public static synchronized ArticleDaoImpl getInstance() {
        if(articleDaoImpl == null){
            articleDaoImpl = new ArticleDaoImpl();
        }
        return articleDaoImpl;
    }


    /**
     *@Author: zsb
     *@Description: 查询所有的文章
     *@params:
     *@Date: 2018/6/4
    */
    @Override
    public List<Article> queryAllArticles() {
        return queryForAll("article", Article.class);
    }

    /**
     *@Author: zsb
     *@Description: 查询最新的文章,最新文章排行/栏目推荐
     *@params: article 列表的长度
     *@Date: 2018/6/4
    */
    @Override
    public List<Article> queryUpToDateArticle(int articleNum) {
        return queryRankingByCondition(Article.class,"article","id","DESC",0,articleNum);
    }

    /**
     *@Author: zsb
     *@Description:  根据浏览量返回推荐文章列表,点击排行
     *@params:
     *@Date: 2018/6/4
    */
    @Override
    public List<Article> queryRecommendArticle(int articleNum) {
        return queryRankingByCondition(Article.class,"article","browse","DESC",0,articleNum);
    }

    /**
     *@Author: zsb
     *@Description: 按特定条件分页后,按页查询当前页的所有文章
     *@params:
     *@Date: 2018/6/4
    */
    @Override
    public List<Article> queryPageArticlesById(int page, int articleNum) {
        return getPageData(page,Article.class,"article","id","DESC",articleNum);
    }

    @Override
    public int checkPaginationLimit(int page, int rowNum) {
        return checkPaginationLimit(page,"article",rowNum);
    }

    public int getTotalPage(int rowNum) {
        return getTotalPage("article", rowNum);
    }

    /**
     *@Author: zsb
     *@Description: 根据id查询一篇文章
     *@params:
     *@Date: 2018/6/9
    */
    @Override
    public Article queryArticleById(int id) {
        return null;
    }

    /**
     *@Author: zsb
     *@Description: 查询前一篇文章
     *@params:
     *@Date: 2018/6/4
    */
    @Override
    public Article queryPrevArticle(int id) {
        String sql = "SELECT * FROM article WHERE id > ? ORDER BY id LIMIT 1";
        //list肯定不为null,因为在内部就new了
        List<Article> list = this.queryForList(Article.class,sql,id);
        return (list.size() > 0)?list.get(0):null;
    }

    /**
     *@Author: zsb
     *@Description: 查询后一篇文章
     *@params:
     *@Date: 2018/6/4
    */
    @Override
    public Article queryNextArticle(int id) {
        String sql = "SELECT * FROM article WHERE id < ? ORDER BY id DESC LIMIt 1";
        //list肯定不为null,因为在内部就new了
        List<Article> list = this.queryForList(Article.class,sql,id);
        return (list.size() > 0)?list.get(0):null;
    }

    @Override
    public int articleBrowseIncrement(int id) {
        return incrementByOneStep("article", "browse", id);
    }

    /**
     *@Author: zsb
     *@Description: 根据id查询一篇文章
     *@params:
     *@Date: 2018/6/9
    */
    public Article queryOneArticlebyId(int id){
        return queryOneDataByCondition(Article.class, "article", "id",id);
    }



}
