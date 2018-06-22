package entity;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class Photo {
    private int id;
    private String image;
    private String note;
    private String content;
    private String type;
    private String notice;
    private String time;
    private int albumId;

    public Photo(){

    }

    public Photo(int id, String image, String note, String content, String type, String notice, String time, int albumId) {
        this.id = id;
        this.image = image;
        this.note = note;
        this.content = content;
        this.type = type;
        this.notice = notice;
        this.time = time;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
