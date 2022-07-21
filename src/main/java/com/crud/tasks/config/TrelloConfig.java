package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TrelloConfig {

    @Value("https://api.trello.com/1")
    private String trelloApiEndpoint;
    @Value("e57152a13d8c735e44725b9f8058b020")
    private String trelloAppKey;
    @Value("dfe8a804b1bd354a0cf123c9e03483d278ec83eff455959f5975fdfbc9ff6c60")
    private String trelloToken;
    @Value("kkazula92")
    private String trelloUser;
}
