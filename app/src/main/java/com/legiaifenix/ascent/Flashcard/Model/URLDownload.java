package com.legiaifenix.ascent.Flashcard.Model;

import android.content.Context;

import com.legiaifenix.ascent.Toast.ErrorToast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDownload extends ErrorHandler
{
    protected URL url;
    protected String urlPath;
    protected File file;

    public static String storagePath = "/sdcard/ascent-flashcards.json";

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
            this.triggerError("URL Malformed", e);
        }

        return this;
    }

    public void download()
    {
        try {
            HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                this.triggerError("The response from the server was not accepted: " + connection.getResponseMessage());
            }

            this.file = new File(storagePath, connection.getInputStream());

        } catch (IOException e) {
            this.triggerError("Failed to establish a connection to the database", e);
        }
    }

    public File getFile() {
        return file;
    }
}
