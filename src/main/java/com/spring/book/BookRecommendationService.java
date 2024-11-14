package com.spring.book;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/*
2.1.1 BookRecommendationService as a Spring service
 */
@Service
class BookRecommendationService {
    private final ChatClient chatClient;

    public BookRecommendationService(ChatClient.Builder chatClientBuilder) {
        /*
         2.1.2 Initialize `this.chatClient`
         */
        this.chatClient = chatClientBuilder.build();
    }

    public String findMostPopularProgrammingBooks() {
        /*
         2.1.3 Complete the method `findMostPopularProgrammingBooks` to ask for the 5 best programming books in 2023.
         */
        return this.chatClient.prompt().user("What are the 5 best programming books in 2023?").call().content();

    }
}
