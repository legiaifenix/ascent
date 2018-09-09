package com.legiaifenix.ascent.Toast;

import android.content.Context;

abstract public class Message {

    protected String title;
    protected String body;
    protected MessageTypes type;
    protected Context context;

    public Message(String title, String body, Context context)
    {
        this.title = title;
        this.body = body;
        this.context = context;
    }

    public abstract void showToast();

}
