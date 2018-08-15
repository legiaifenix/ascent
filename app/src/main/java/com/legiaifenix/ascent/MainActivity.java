package com.legiaifenix.ascent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.legiaifenix.ascent.Flashcard.Model.Flashcard;

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

        this.flashcardBtn   = (Button) findViewById(R.id.btn_flashcards);
        drawActivityViaButton(this.flashcardBtn);

        this.atcBtn         = (Button) findViewById(R.id.btn_atc);
        drawActivityViaButton(this.atcBtn);

        this.donateBtn      = (Button) findViewById(R.id.btn_donate);
        drawActivityViaButton(this.donateBtn);

        this.contactBtn     = (Button) findViewById(R.id.btn_contact);
        drawActivityViaButton(this.contactBtn);
    }

    /**
     * Sets the listenner for a Btn parameter
     * @param btn Button - As the target Btn from the view that we wish to set a listener on
     */
    private void drawActivityViaButton(final Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), FlashcardMenuActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * Discovers the Activity.class to return based on the Btn tag that is sent
     *
     * @param tag String - As the Btn tag on the view to better identify it
     * @return Class
     */
    private Class findActivityToDraw(String tag)
    {
        switch (tag) {
            case "flashcardBtn":
                return FlashcardMenuActivity.class;
        }

        return null;
    }

}
