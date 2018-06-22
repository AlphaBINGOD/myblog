package entity;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class Album {
    private int id;
    private String title;
    private String image;
    private String content;
    private String notice;
    private String time;

    public Album() {
    }

    public Album(int id, String title, String image, String content, String notice, String time) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.notice = notice;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
