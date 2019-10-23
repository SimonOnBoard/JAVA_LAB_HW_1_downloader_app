package tasks;

import com.beust.jcommander.JCommander;

import java.util.Scanner;

public class MainApp {
    public static ThreadPool threadPool;
    public static void main(String[] args) {
        Args args1 = new Args();
        JCommander jCommander = new JCommander(args1);
        jCommander.parse(args);
        args1.checkIfCountersError();
        initThreadPool(args1.getCount());
        System.out.println(args1.getCount());
        System.out.println(args1.getFolder());
        getDownloadByThreadPool(args1);
    }

    private static void getDownloadByThreadPool(Args args1) {
        for( String url : args1.getUrls()){
            threadPool.submit(new Loader(url,args1.getFolder(),
                    ImageLoader.create(args1.getUrl(),args1.getUser(),args1.getPassword())));
        }
    }

    private static void initThreadPool(int count) {
        threadPool = new ThreadPool(count);
    }

}
