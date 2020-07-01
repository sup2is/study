package me.sup2is;

public class ReplyProxy extends Reply {

    private Reply reply;

    public ReplyProxy(int replyId, int parentId, String content) {
        super(replyId, parentId, content);
    }

    @Override
    public String getContent() {
        if(reply == null) {
            reply = new BoardReply(this.replyId, this.parentId, this.content);
        }
        return reply.getContent();
    }
}
