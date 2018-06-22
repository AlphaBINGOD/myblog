package entity;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/2
 */
public class Article {
    private int id;
    private String title;
    private String content;
    private String image;
    private String time;
    private String editor;
    private int browse;
    private int comment;
    private String type;
    private String notice;
    private String keywords;

    public Article(){

    }

    public Article(int id, String title, String content, String image, String time, String editor, int browse, int comment, String type, String notice, String keywords) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.time = time;
        this.editor = editor;
        this.browse = browse;
        this.comment = comment;
        this.type = type;
        this.notice = notice;
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", time='" + time + '\'' +
                ", editor='" + editor + '\'' +
                ", browse=" + browse +
                ", comment=" + comment +
                ", type='" + type + '\'' +
                ", notice='" + notice + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editer) {
        this.editor = editer;
    }

    public int getBrowse() {
        return browse;
    }

    public void setBrowse(int browse) {
        this.browse = browse;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
