package daoImpl;

import dao.MeDao;
import entity.Me;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class MeDaoImpl extends BaseDao implements MeDao {

    private static MeDaoImpl meDao = null;

    private MeDaoImpl(){ }

    public static synchronized MeDaoImpl getMeDaoImpl(){
        if(meDao == null){
            meDao = new MeDaoImpl();
        }
        return meDao;
    }


    /**
     *@Author: zsb
     *@Description: 个人信息
     *@params:
     *@Date: 2018/6/4
    */
    @Override
    public Me queryMe() {
        String sql = "SELECT * FROM me ORDER BY id DESC LIMIT 1";
        List<Me> meList = queryForList(Me.class, sql, null);
        return meList.size()>0 ? meList.get(0) : null;
    }

}
