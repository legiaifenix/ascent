package com.legiaifenix.ascent.Toast;

import android.content.Context;
import android.widget.Toast;

public class ErrorToast extends Message {

    protected Integer duration;
    protected Toast toast;

    public ErrorToast(String title, String body, Context context) {
        super(title, body, context);
        this.duration = Toast.LENGTH_SHORT;
        this.type = MessageTypes.Error;
    }


    @Override
    public void showToast()
    {
        this.toast = Toast.makeText(this.context, this.body, this.duration);
        this.toast.show();
    }

}
