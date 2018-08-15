package com.legiaifenix.ascent;

import com.legiaifenix.ascent.Flashcard.Model.Flashcard;
import com.legiaifenix.ascent.Flashcard.Model.FlightTrainingFlashcard;

public class FlashcardFactory {


    public static Flashcard FlashcardFactory(String type)
    {
        switch (type) {
            case "flight-training":
                return new FlightTrainingFlashcard(type, null);
        }

        return null;
    }

}
