package test;

import daoImpl.ArticleDaoImpl;
import entity.Article;
import org.junit.jupiter.api.Test;
import utils.TokenUtils;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/3
 */

public class testClass {
    @Test
    public  void testmain() {
        //ArticleDaoImpl articleDao = ArticleDaoImpl.getInstance();
        //Article article = new Article(1,"2","3","4","5","6",7,8,"9","0","10");
        //System.out.println(articleDao.queryRecommendArticle(1).get(0));
        //System.out.println("abc" + 1);
        System.out.println(TokenUtils.getToken());
    }
}
