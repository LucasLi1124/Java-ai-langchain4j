package com.llf.java.ai.langchain4j;


import com.llf.java.ai.langchain4j.assistance.Assistance;
import dev.langchain4j.community.model.dashscope.QwenChatModel;


import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat(){
        Assistance assistance = AiServices.create(Assistance.class, qwenChatModel);
        String chat = assistance.chat("你是谁？");
        System.out.println(chat);
    }

    @Autowired
    private Assistance assistance;

    @Test
    public void testChat2(){
        String chat = assistance.chat("你是谁？");
        System.out.println(chat);
    }
}
