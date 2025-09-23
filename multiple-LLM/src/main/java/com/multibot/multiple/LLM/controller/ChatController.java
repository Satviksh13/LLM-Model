package com.multibot.multiple.LLM.controller;

import com.multibot.multiple.LLM.model.ChatRequest;
import com.multibot.multiple.LLM.model.ChatResponse;
import com.multibot.multiple.LLM.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow frontend to access
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest chatRequest) {
        try {
            String response = chatService.getChatResponse(chatRequest.getMessage());
            return ResponseEntity.ok(new ChatResponse(true, response));

        } catch (Exception e) {
            ChatResponse errorResponse = new ChatResponse(false, null, e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Server is running!");
    }
}