package com.matt.largeLanguageModel;


import com.matt.largeLanguageModel.factory.LLMFactory;
import com.matt.largeLanguageModel.factory.service.LLMService;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testOpenAi() {
        String answer = openAiChatModel.chat("你是谁");
        System.out.println(answer);
    }


    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testLLM() {
        String response = qwenChatModel.chat("hello,你是谁");
        System.out.println(response);
    }


    @Test
    public void testOpenAiFactory() {
        LLMService llmService = LLMFactory.createLLMService(LLMFactory.modelType.OPENAI);
        String chat = llmService.chat("你是谁");
        System.out.println(chat);
    }

    @Test
    public void testQwenFactory() {
        LLMService llmService = LLMFactory.createLLMService(LLMFactory.modelType.QWEN);
        String chat = llmService.chat("你是谁");
        System.out.println(chat);
    }
}
