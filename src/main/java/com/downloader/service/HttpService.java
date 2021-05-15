package com.downloader.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

public class HttpService {

    public Content CreateGet(String url) {
        Content getResult = null;
        try {
            getResult = Request.Get(url)
                    .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult;
    }

    public Content CreatePost(String url, Collection<NameValuePair> params) {
        Content postResult = null;
        try {
            postResult = Request.Post(url)
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return postResult;
    }
}
