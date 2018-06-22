package daoImpl;

import dao.PhotoDao;
import entity.Photo;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class PhotoDaoImpl extends BaseDao implements PhotoDao{

    private static PhotoDaoImpl photoDao = null;

    private PhotoDaoImpl(){}

    public static PhotoDaoImpl getInstance(){
        if(photoDao == null){
            photoDao = new PhotoDaoImpl();
        }
        return photoDao;
    }



    @Override
    public List<Photo> queryAlbumAllPhoto(int albumId) {
        String sql = "SELECT * FROM photo WHERE albumId = ?";
        return queryForList(Photo.class, sql, albumId);
    }
}
