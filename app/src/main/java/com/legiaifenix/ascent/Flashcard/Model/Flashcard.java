package com.legiaifenix.ascent.Flashcard.Model;

import java.util.LinkedList;

public class Flashcard {

    protected String type;

    protected LinkedList<Question> questions = new LinkedList<Question>();

    public Flashcard(String type, LinkedList<Question> list)
    {
        this.type = type;
        this.questions = list;
    }

    public Flashcard(LinkedList<Question> list)
    {
        this.questions = list;
    }


}
