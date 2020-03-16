package mygit.service.Logic.Node;

public class CommitNode {

    private String timestamp;
    private String committer;
    private String message;
    private String Sha1;

    public CommitNode(String timestamp, String committer, String message,String Sha1) {
        this.timestamp = timestamp;
        this.committer = committer;
        this.message = message;
        this.Sha1 = Sha1;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public String getSha1() {
        return Sha1;
    }
    public String getCommitter() {
        return committer;
    }
    public String getMessage() {
        return message;
    }
}
