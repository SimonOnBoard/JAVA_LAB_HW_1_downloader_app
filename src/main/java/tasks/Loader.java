package tasks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Loader implements Runnable {
    private ImageLoader imageLoader;
    private String url;
    private String destinationFolder;


    public Loader(String url, String folder, ImageLoader imageLoader) {
        this.url = url;
        this.destinationFolder = folder;
        this.imageLoader = imageLoader;
    }

    @Override
    public void run() {
        imageLoader.load(url,destinationFolder);
    }

}
