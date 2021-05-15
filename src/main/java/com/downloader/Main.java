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
        String readPath = "C:\\Users\\kirill.shadrin\\Downloads\\parameters.txt";
        String writePath = "C:\\Users\\kirill.shadrin\\Downloads\\out.xlsx";

        if(args.length > 0) {
            switch (args.length) {
                case 1: url = args[0];
                break;
                case 2: url = args[0]; readPath = args[1];
                break;
                case 3: url = args[0]; readPath = args[1]; writePath = args[2];
                break;
            }
        }

        HttpService httpService = new HttpService();
        Reader reader = new Reader();

        Collection<NameValuePair> params = reader.getParams(readPath);

        Content response = httpService.CreatePost(url, params);

        Writer writer = new Writer();

        writer.writeExcel(writePath, response.asBytes());
    }
}
