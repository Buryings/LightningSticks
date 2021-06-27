package me.buryings.lightningsticks.util;

public enum Log {
    URGENT("urgent", "[LS URGENT]: "),
    WARNING("warning", "[LS WARNING]: "),
    NORMAL("normal", "[LS LOG]: "),
    STARTUP("startup", "[LS STARTUP]: "),
    STOPPING("stopping", "[LS STOPPING]: ");

    private final String id;
    private final String display;

    Log(String id, String display) {
        this.id = id;
        this.display = display;
    }

    public String getID() {
        return id;
    }

    public String getDisplay() {
        return display;
    }

    public void sendLog(String message) {
        System.out.println(getDisplay() + " " + message);
    }
}
