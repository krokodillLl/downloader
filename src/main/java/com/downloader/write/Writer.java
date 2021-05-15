package com.downloader.write;


import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {


    public void writeExcel(String path, byte[] data) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(path);

        outputStream.write(data);
        outputStream.close();
    }
}
