package com.legiaifenix.ascent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class FlashcardActivity extends AppCompatActivity {

    private TextSwitcher questionSwitcher;
    private TextSwitcher answerSwitcher;

    private int stringIndex = 0;

    private TextView cardText;
    private LinearLayout cardHolder;

    private String[] questions = {"ONE", "TWO", "THREE"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        questionSwitcher = findViewById(R.id.question_switcher);

        cardHolder = findViewById(R.id.card_holder);

        cardHolder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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

        questionSwitcher.setText(questions[0]);
    }

}
