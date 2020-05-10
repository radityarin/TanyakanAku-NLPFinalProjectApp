package com.example.questionanswersystem_nlpproject.response;

import com.example.questionanswersystem_nlpproject.model.Answer;

public class AnswerResponse {
    private boolean success;
    private String message;
    private Answer data;

    public AnswerResponse(boolean success, String message, Answer data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Answer getData() {
        return data;
    }

    public void setData(Answer data) {
        this.data = data;
    }
}
