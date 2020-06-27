package com.forestsoftware.kands2revamp;

public class QuizObject {
    private String id;
    private String word;
    private String definition;
    private int number;

    public QuizObject(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
    public QuizObject(String wordn) {
        this.word = word;
    }
    public QuizObject(String word, String definition, int number) {
        this.word = word;
        this.definition = definition;
        this.number = number;
    }
    public QuizObject(String id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.definition = meaning;
    }

    public QuizObject() {
//        this.word = word;
//        this.definition = definition;
//        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public int getNumber()
    {
        return number;
    }
    public void setNumber(int number)
    {
        this.number = number;
    }



}
