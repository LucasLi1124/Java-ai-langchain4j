package com.llf.java.ai.langchain4j.assistance;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;


import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT
        , streamingChatModel = "qwenStreamingChatModel"
//        , chatModel = "qwenChatModel"
        , chatMemoryProvider = "chatMemoryProviderXiaozhi"
        , tools = "appointmentTools"
        , contentRetriever = "contentRetrieverXiaozhiPincone"//配置向量存储
)
public interface XiaozhiAgent {

    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
        // String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);


}
