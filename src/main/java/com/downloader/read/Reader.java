package com.downloader.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Reader {

    private final List<String> nameRows = new ArrayList<>();
    private final List<String> parameterRows = new ArrayList<>();
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy");
    private final Date date = new Date();

    public Reader(String path) {
        init(path);
    }

    public int getCount() {
        return parameterRows.size();
    }

    public Collection<NameValuePair> getParams(int i, boolean replaceYear) {
        Collection<NameValuePair> params = new ArrayList<>();

        String text = parameterRows.get(i);

        String[] parameters = text.split("&");

        for(String str : parameters) {
            String[] pair = str.split("=");
            try {
                if(replaceYear && pair[1].contains("3_20")) {
                    pair[1] = "3_" + format.format(date);
                }
                params.add(new BasicNameValuePair(pair[0], pair[1]));
            }
            catch (RuntimeException e) {
                System.out.println("can't parse this parameter: " + getName(i) + Arrays.toString(pair));
                return null;
            }
        }

        return params;
    }

    public String getName(int i) {
        return nameRows.get(i) + "_";
    }


    private void init(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("can't find the parameters file: " + path);
        }
        if(reader != null) {
            List<String> fileRows = reader.lines().collect(Collectors.toList());
            for(int i = 0; i < fileRows.size(); i++) {
                if(fileRows.get(i).contains("id")) {
                    this.parameterRows.add(fileRows.get(i));
                    this.nameRows.add(fileRows.get(i - 1));
                }
            }
        }
    }
}
