package com.multibot.multiple.LLM.controller;

import com.multibot.multiple.LLM.model.ChatRequest;
import com.multibot.multiple.LLM.model.ChatResponse;
import com.multibot.multiple.LLM.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest chatRequest, Authentication authentication) {
        try {
            String username = authentication != null ? authentication.getName() : "Anonymous";
            System.out.println("Chat request from user: " + username);

            String response = chatService.getChatResponse(chatRequest.getMessage());
            return ResponseEntity.ok(new ChatResponse(true, response));

        } catch (Exception e) {
            ChatResponse errorResponse = new ChatResponse(false, null, e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Server is running!");
    }

    @GetMapping("/user")
    public ResponseEntity<String> getCurrentUser(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok(authentication.getName());
        }
        return ResponseEntity.ok("Anonymous");
    }
}