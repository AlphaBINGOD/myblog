package daoImpl;

import dao.AlbumDao;
import dao.ArticleDao;
import entity.Album;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class AlbumDaoImpl extends BaseDao implements AlbumDao{

    private static AlbumDaoImpl albumDao = null;

    private AlbumDaoImpl(){}

    public synchronized static AlbumDaoImpl getInstance(){
        if(albumDao == null){
            albumDao = new AlbumDaoImpl();
        }
        return albumDao;
    }



    /**
     *@Author: zsb
     *@Description:  获取所有相册
     *@params:
     *@Date: 2018/6/15
    */
    @Override
    public List<Album> queryAllAlbum() {
        return queryForAll("album", Album.class);
    }
}
