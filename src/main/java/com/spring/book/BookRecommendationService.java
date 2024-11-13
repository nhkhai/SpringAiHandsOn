package com.spring.book;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.stereotype.Service;

@Service
class BookRecommendationService {
    private final ChatClient chatClient;

    public BookRecommendationService(ChatClient.Builder builder) {
        this.chatClient = builder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
    }

    public String findMostPopularProgrammingBooks() {
        return this.chatClient.prompt().user("5 best programming books in year 2023").call().content();
    }

    public Book findFictionBook() {
        return this.chatClient.prompt().user("what is the most popular fiction book in 2023?").call().entity(Book.class);
    }
}