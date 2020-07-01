package me.sup2is;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Board 인스턴스 생성");
        long start = System.currentTimeMillis();
        //DB에서 board를 가져온다고 가정
        Board board = getBoardFromDatabase();
        long end = System.currentTimeMillis();

        System.out.println("ProxyReply 인스턴스 생성 시간 : " + (end - start) / 1000 + "초");
        System.out.println(board.toString());

        System.out.println("실제 BoardReply 인스턴스에 접근");
        start = System.currentTimeMillis();

        for (Reply reply : board.getReplies()) {
            System.out.println(reply.getContent());
        }

        end = System.currentTimeMillis();

        System.out.println("실제 BoardReply 생성 시간 : " + (end - start) / 1000 + "초");

    }

    //데이터 초기화
    private static Board getBoardFromDatabase() {

        int boardId = 1;
        List<Reply> replies = new ArrayList<>();
        //Proxy 객체로 replies 초기화
        for (int i = 0; i < 10; i++) {
            replies.add(new ReplyProxy(i + 1, boardId, "댓글 " + (i + 1)));
        }

        Board board = new Board(boardId, "게시글1", "게시글입니다.", replies);
        return board;
    }

}

