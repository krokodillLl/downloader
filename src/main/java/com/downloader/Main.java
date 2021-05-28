package com.downloader;

import java.io.IOException;
import java.util.Collection;

import com.downloader.service.HttpService;
import com.downloader.read.Reader;
import com.downloader.write.Writer;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;

public class Main {

    public static void main(String[] args) throws IOException {

        String url = "https://fedstat.ru/indicator/data.do?format=excel";
        String readPath = "C:\\Users\\kirill.shadrin\\Downloads\\parametersNew.txt";
        String writePath = "C:\\Users\\kirill.shadrin\\Downloads\\hello";

        if(args.length > 0) {
            switch (args.length) {
                case 1: readPath = args[0];
                break;
                case 2: readPath = args[0]; writePath = args[1];
                break;
            }
        }

        HttpService httpService = new HttpService();
        Reader reader = new Reader(readPath);

        for(int i = 0; i < reader.getCount(); i++) {
            Collection<NameValuePair> nameValuePairs = reader.getParams(i);
            if(nameValuePairs == null)
                continue;
            Content response = httpService.CreatePost(url, nameValuePairs);

            Writer writer = new Writer();

            writer.writeExcel(writePath, reader.getName(i), response.asBytes());
        }


    }
}
