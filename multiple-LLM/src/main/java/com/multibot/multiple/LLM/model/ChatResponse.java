package com.multibot.multiple.LLM.model;

public class ChatResponse {
    private boolean success;
    private String response;
    private String error;

    // Constructors
    public ChatResponse() {}

    public ChatResponse(boolean success, String response) {
        this.success = success;
        this.response = response;
    }

    public ChatResponse(boolean success, String response, String error) {
        this.success = success;
        this.response = response;
        this.error = error;
    }

    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}