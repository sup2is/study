package me.sup2is;

public class BoardReply extends Reply{

    public BoardReply(int replyId, int parentId, String content) {
        super(replyId, parentId, content);
        delay();
    }

    @Override
    public String getContent() {
        return this.content;
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
