package dao;

import entity.Album;

import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public interface AlbumDao {
        //获取所有相册
    List<Album> queryAllAlbum();
}
