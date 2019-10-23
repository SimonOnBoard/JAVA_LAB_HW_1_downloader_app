package tasks;

import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names  = {"--mode","--m"}, description = "mode of downloading")
    private String mode;
    @Parameter(names  = {"--count","--c"}, description = "amount of threads")
    private int count = 1;
    @Parameter(names  = {"--files","--fi"}, description = "urls of files")
    private String urls;
    @Parameter(names  = {"--folder","--fo"}, description = "destination folder")
    private String folder;
    @Parameter(names  = {"--db_url","--url"}, description = "database connection url")
    private String url;
    @Parameter(names  = {"--db_username","--usr"}, description = "database user")
    private String user;
    @Parameter(names  = {"--db_password","--pass"}, description = "database password")
    private String password;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String[] getUrls() {
        return urls.split(";");
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkIfCountersError() {
        if(this.getCount() > 1 && !this.getMode().equals("multi-thread")){
            throw new IllegalArgumentException("Parameter mismatch");
        }
    }
}
