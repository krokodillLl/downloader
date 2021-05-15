package com.downloader.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Reader {

    public Collection<NameValuePair> getParams(String path) throws IOException {
        Collection<NameValuePair> params = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();

        while(reader.ready()) {
            sb.append(reader.readLine());
        }

        String text = sb.toString();

        String[] parameters = text.split("&");

        for(String str : parameters) {
            String[] pair = str.split("=");
            params.add(new BasicNameValuePair(pair[0], pair[1]));
        }

        return params;
    }
}
