package com.llf.java.ai.langchain4j.assistance;


import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel")
public interface Assistance {
    String chat(String userMessage);
}
