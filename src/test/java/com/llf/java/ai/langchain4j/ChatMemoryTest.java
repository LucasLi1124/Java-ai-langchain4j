package com.llf.java.ai.langchain4j;

import com.llf.java.ai.langchain4j.assistance.Assistance;
import com.llf.java.ai.langchain4j.assistance.MemoryChatAssistance;
import com.llf.java.ai.langchain4j.assistance.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistance assistance;

    @Test
    public void testChatMemory() {
        String answer1 = assistance.chat("我是峰峰");
        System.out.println(answer1);
        String answer2 = assistance.chat("我是谁");
        System.out.println(answer2);
    }


    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory1() {
        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是峰峰");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage1.text());
        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1,
                aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Autowired
    private MemoryChatAssistance memoryChatAssistance;


    @Test
    public void testChatMemory2() {
        String answer1 = memoryChatAssistance.chat("我是峰峰");
        System.out.println(answer1);
        String answer2 = memoryChatAssistance.chat("我是谁？");
        System.out.println(answer2);
    }
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory3() {
        String answer1 = separateChatAssistant.chat(1,"我是峰峰");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"我是谁？");
        System.out.println(answer2);
        String answer3 = separateChatAssistant.chat(2,"我是谁？");
        System.out.println(answer3);
    }
}
