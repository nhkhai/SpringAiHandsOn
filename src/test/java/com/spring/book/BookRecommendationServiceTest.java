package com.spring.book;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRecommendationServiceTest {
    /*
    2.1.1 Inject BookRecommendationService as a Spring service
    */
    @Autowired
    private BookRecommendationService bookRecommendationService;

    private static final Logger logger = LoggerFactory.getLogger(BookRecommendationServiceTest.class);

    @Test
    void shouldFindMostPopularProgrammingBooks() {
       /*
         2.3 Update a JUnit test BookRecommendationServiceTest and verify that the API key works by logging the response.
        */
        var response = this.bookRecommendationService.findMostPopularProgrammingBooks();
        logger.info("Response: {}", response);
    }
}
