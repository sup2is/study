package me.sup2is;

public class Post {

    private int id;
    private String destination;
    private String content;

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getContent() {
        return content;
    }

    public Post(int id, String destination, String content) {
        this.id = id;
        this.destination = destination;
        this.content = content;
    }
}
