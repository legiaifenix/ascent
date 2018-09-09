package com.legiaifenix.ascent.Marshaller;

import android.content.Context;

import com.legiaifenix.ascent.Toast.ErrorToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class JsonToArray {

    protected File jsonFile;
    protected String pathToFile;

    protected JSONObject json;
    protected JSONArray parsedJson;

    public JsonToArray(String pathToFile, Context context)
    {
        this.pathToFile = pathToFile;
        this.init(context);
    }

    private void init(Context context)
    {
        if( this.pathToFile.length() > 0 ) {
            try{
                this.json = new JSONObject(this.pathToFile);
            } catch (JSONException e) {
                ErrorToast errormessage = new ErrorToast("Data Sync", e.getMessage(), context);
                errormessage.showToast();
            }

        }
    }

}
