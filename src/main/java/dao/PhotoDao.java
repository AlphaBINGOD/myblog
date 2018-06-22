package dao;

import entity.Photo;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public interface PhotoDao {
    //根据album_id查询出所有相关的图片
    List<Photo> queryAlbumAllPhoto(int albumId);
}
