package com.legiaifenix.ascent.Flashcard.Model;

import android.content.Context;

import com.legiaifenix.ascent.Toast.ErrorToast;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDownload {

    protected Context context;
    protected URL url;
    protected String urlPath;

    public URLDownload(String urlPath, Context context)
    {
        this.context = context;
        this.urlPath = urlPath;
    }

    public URLDownload connect()
    {
        try {
            this.url = new URL(this.urlPath);
        } catch (MalformedURLException e) {
            ErrorToast errorToast = new ErrorToast("URL Malformed", e.getMessage(), this.context);
            errorToast.showToast();
        }

        return this;
    }

}
