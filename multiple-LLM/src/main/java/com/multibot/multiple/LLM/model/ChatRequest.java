package com.multibot.multiple.LLM.model;

public class ChatRequest {
    private String message;
    private String model; // Optional: if you want model selection

    // Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}