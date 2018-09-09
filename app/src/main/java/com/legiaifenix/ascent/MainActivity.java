package com.legiaifenix.ascent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.legiaifenix.ascent.Flashcard.Model.URLDownload;

public class MainActivity extends AppCompatActivity
{

    protected Button flashcardBtn   = null;
    protected Button atcBtn         = null;
    protected Button donateBtn      = null;
    protected Button contactBtn     = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.updateData();

        this.flashcardBtn   = (Button) findViewById(R.id.btn_flashcards);
        this.flashcardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FlashcardMenuActivity.class);
                startActivity(i);
            }
        });
    }

    private void updateData()
    {
        // Checks if SDStorage exists
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URLDownload urlD = new URLDownload("https://legiaifenix.com/uploads/data.json", this);
            urlD.connect();
        }
    }

}
