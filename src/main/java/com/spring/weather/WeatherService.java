package com.spring.weather;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
class WeatherService {

    private final ChatClient chatClient;

    @Value("classpath:weather/singapore-weather.png")
    private Resource singaporeWeather;

    public WeatherService(ChatClient.Builder builder) {
        this.chatClient = builder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
    }

    public String analyseWeather() {
        return this.chatClient.prompt().user(
                promptUserSpec -> promptUserSpec.text("what will the weather be like on Tuesday?")
                        .media(MimeTypeUtils.IMAGE_PNG, this.singaporeWeather)
        ).call().content();
    }


}
