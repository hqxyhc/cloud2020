package com.atguigu.springcloud.pojo;

/**
 * @ClassName Blog
 * @Description: 描述
 * @Author hc
 * @Date 2021/3/5 9:59
 * @Version V1.0
 **/
public class Blog {
    private String id;
    private String title;
    private String content;
    private String tips;
    private String writer;
    private String lastTime;
    private String kind;
    private int readNum;
    private int likeNum;

    public Blog() {
    }

    public Blog(String id, String title, String content, String tips, String writer, String lastTime, String kind) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tips = tips;
        this.writer = writer;
        this.lastTime = lastTime;
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
