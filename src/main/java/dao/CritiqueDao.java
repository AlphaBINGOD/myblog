package dao;

import entity.Critique;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public interface CritiqueDao {
    //查询所有评论
    List<Critique> queryCritique(String sql, Object... objects);
    //根据时间查询最新的评论
    List<Critique> queryUpToDateCritique(int critiqueNum);
    //查询一页评论
    List<Critique> queryPageCritiques(int page, int critiqueNum);
    //查询总页数
    int getTotalPage(int critiqueNum);
    //页面合法性检查
    int checkPaginationLimit(int page,int rowNum);
    int addCritique(Critique critique);
    int deleteCritique(Critique critique);
    int updateCritique(Critique before, Critique after);
}
