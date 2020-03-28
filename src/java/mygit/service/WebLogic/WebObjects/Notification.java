package mygit.service.WebLogic.WebObjects;

public class Notification {
    private String text;
    private String createdTime;

    public Notification(String i_text, String i_CreatedTime) {
        this.text = i_text;
        this.createdTime = i_CreatedTime;
    }

    public Notification(String notification) {
        String[] noti = notification.split("~");
        this.text = noti[0];
        this.createdTime = noti[1];
    }

    public String getText() {
        return text;
    }

    public String getM_CreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return text + "~" + createdTime;
    }
}
