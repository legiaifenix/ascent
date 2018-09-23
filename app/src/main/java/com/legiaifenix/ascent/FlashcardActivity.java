package com.legiaifenix.ascent;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.legiaifenix.ascent.Flashcard.Model.Question;
import com.legiaifenix.ascent.Flashcard.Model.URLDownload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FlashcardActivity extends AppCompatActivity {

    private TextSwitcher questionSwitcher;
    private TextSwitcher answerSwitcher;

    private int stringIndex = 0;

    private TextView cardText;
    private LinearLayout cardHolder;

    private ArrayList<Question> questions = new ArrayList<Question>();

    private URLDownload urlD;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Harvest the cards info
        // this.updateData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        questionSwitcher = findViewById(R.id.question_switcher);
        cardHolder = findViewById(R.id.card_holder);

        cardHolder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Execution click on card
                cardHolder.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        });

        questionSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                cardText = new TextView(FlashcardActivity.this);
                cardText.setTextColor(Color.BLACK);
                cardText.setTextColor(Color.BLACK);

                return cardText;
            }
        });

        this.dummyTestQuestionAdd();
    }

    private void dummyTestQuestionAdd()
    {
        Question q = new Question("What is the name of the energy that exercises force into an object exposed to a parcel of air?", "Kinetic Energy");
        this.questions.add(q);
        this.questionSwitcher.setText(this.questions.get(0).getQuestion());
    }

    private void updateData()
    {
        // Checks if SDStorage exists
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            this.urlD = new URLDownload("https://legiaifenix.com/uploads/data.json", this);
            urlD.connect().download();
        }
    }

}
