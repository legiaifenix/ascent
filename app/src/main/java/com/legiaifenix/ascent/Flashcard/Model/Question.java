package com.legiaifenix.ascent.Flashcard.Model;

public class Question {

    protected String question;
    protected String answer;
    protected String extraInformation;

    public Question()
    {
        this.question = "";
        this.answer = "";
        this.extraInformation = "";
    }

    public Question(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }
}
