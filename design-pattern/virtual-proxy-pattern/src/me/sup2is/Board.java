package me.sup2is;

import java.util.List;

public class Board {

    private int boardId;
    private String title;
    private String content;
    private List<Reply> replies;

    public Board(int boardId, String title, String content, List<Reply> replies) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.replies = replies;
    }

    public int getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", replies=" + replies +
                '}';
    }
}
