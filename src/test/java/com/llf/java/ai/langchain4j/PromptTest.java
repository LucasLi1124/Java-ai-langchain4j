package com.llf.java.ai.langchain4j;

import com.llf.java.ai.langchain4j.assistance.MemoryChatAssistance;
import com.llf.java.ai.langchain4j.assistance.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {


    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(4, "今天几号");
        System.out.println(answer);
    }





    @Autowired
    private MemoryChatAssistance memoryChatAssistance;
    @Test
    public void testUserMessage() {
        String answer1 = memoryChatAssistance.chat("我是峰峰");
        System.out.println(answer1);

        String answer2 = memoryChatAssistance.chat("我18了");
        System.out.println(answer2);

        String answer3 = memoryChatAssistance.chat("你知道我是谁吗？");
        System.out.println(answer3);
    }



    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(10, "我是峰峰");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(10, "我是谁");
        System.out.println(answer2);
    }
}
