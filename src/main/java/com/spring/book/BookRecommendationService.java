package com.spring.book;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
class BookRecommendationService {
    private final ChatClient chatClient;

    public BookRecommendationService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String findMostPopularProgrammingBooks() {
        return this.chatClient.prompt().user("5 best programming books in year 2023").call().content();
    }
}