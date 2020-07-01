package me.sup2is;

public abstract class Reply {

    int replyId;
    int parentId;
    String content;

    public Reply(int replyId, int parentId, String content) {
        this.replyId = replyId;
        this.parentId = parentId;
        this.content = content;
    }

    public abstract String getContent();

}
