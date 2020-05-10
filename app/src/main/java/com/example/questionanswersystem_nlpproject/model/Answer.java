package com.example.questionanswersystem_nlpproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Answer {

    private String answer, answer_type, result_sentence;
    private ArrayList<String> key_words;

    public Answer(String answer, String answer_type, String result_sentence, ArrayList<String> key_words) {
        this.answer = answer;
        this.answer_type = answer_type;
        this.result_sentence = result_sentence;
        this.key_words = key_words;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer_type() {
        return answer_type;
    }

    public void setAnswer_type(String answer_type) {
        this.answer_type = answer_type;
    }

    public String getResult_sentence() {
        return result_sentence;
    }

    public void setResult_sentence(String result_sentence) {
        this.result_sentence = result_sentence;
    }

    public ArrayList<String> getKey_words() {
        return key_words;
    }

    public void setKey_words(ArrayList<String> key_words) {
        this.key_words = key_words;
    }

}
