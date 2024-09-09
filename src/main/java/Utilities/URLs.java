package Utilities;

public enum URLs {

    Google("https://accounts.google.com/"),
    GMAIL("https://mail.google.com/");

    private final String url;

    URLs(String url){
        this.url=url;
    }

    public String getURL() {
        return url;
    }
}
