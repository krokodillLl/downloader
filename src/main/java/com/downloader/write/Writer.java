package com.downloader.write;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Writer {

    private final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");

    public void writeExcel(String path, String name, byte[] data) {
        FileOutputStream outputStream = null;
        File file = new File(path + name + format.format(new Date()) + ".xls");
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("can't found a write path: " + path + name + format.format(new Date()) + ".xls");
        }

        try {
            Objects.requireNonNull(outputStream).write(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("can't write a text");
        }
    }
}
