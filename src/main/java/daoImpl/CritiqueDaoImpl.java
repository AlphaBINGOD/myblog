package daoImpl;

import dao.CritiqueDao;
import entity.Article;
import entity.Critique;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class CritiqueDaoImpl extends BaseDao implements CritiqueDao{

    private static CritiqueDaoImpl critiqueDao = null;
    //单例
    private CritiqueDaoImpl(){

    }
    //预防线程竞争导致产生多个实例
    public static synchronized CritiqueDaoImpl getInstance(){
        if(critiqueDao == null){
            critiqueDao = new CritiqueDaoImpl();
        }
        return critiqueDao;
    }



    @Override
    public List<Critique> queryCritique(String sql, Object... objects) {
        return null;
    }


    /**
     *@Author: zsb
     *@Description: 查询最新的评论, 按照id值就可以了,不需要真的比较时间
     *@params: 返回的评论数
     *@Date: 2018/6/5
    */
    @Override
    public List<Critique> queryUpToDateCritique(int critiqueNum) {
        return queryRankingByCondition(Critique.class,"critique","id","DESC",0, critiqueNum);
    }

    /**
     *@Author: zsb
     *@Description: 查询一页评论
     *@params:
     *@Date: 2018/6/11
    */
    @Override
    public List<Critique> queryPageCritiques(int page, int critiqueNum) {
        return getPageData(page, Critique.class,"critique","id","DESC",critiqueNum);
    }

    @Override
    public int getTotalPage(int critiqueNum) {
        return getTotalPage("critique",critiqueNum);
    }

    @Override
    public int checkPaginationLimit(int page, int rowNum) {
        return checkPaginationLimit(page, "critique",rowNum);
    }

    @Override
    public int addCritique(Critique critique) {
        String sql = "INSERT INTO critique(name, content, time) VALUES(?,?,?)";
        return update(sql,critique.getName(),critique.getContent(),critique.getTime());
    }

    @Override
    public int deleteCritique(Critique critique) {
        return 0;
    }

    @Override
    public int updateCritique(Critique before, Critique after) {
        return 0;
    }
}
