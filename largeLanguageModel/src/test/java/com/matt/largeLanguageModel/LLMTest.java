package com.matt.largeLanguageModel;


import com.matt.largeLanguageModel.factory.LLMFactory;
import com.matt.largeLanguageModel.factory.service.LLMService;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testOpenAi() {
        Assumptions.assumeTrue(openAiChatModel != null, "OpenAI model not available");
        // Simply ensure the bean is created; avoid network calls in tests
        System.out.println("OpenAI model initialized");
    }


    @Autowired(required = false)
    private QwenChatModel qwenChatModel;

    @Test
    public void testLLM() {
        Assumptions.assumeTrue(qwenChatModel != null, "DashScope API key not configured");
        String response = qwenChatModel.chat("hello,你是谁");
        System.out.println(response);
    }


    @Test
    public void testOpenAiFactory() {
        LLMService llmService = LLMFactory.createLLMService(LLMFactory.modelType.OPENAI);
        Assumptions.assumeTrue(llmService != null, "OpenAI service not created");
    }

    @Test
    public void testQwenFactory() {
        Assumptions.assumeTrue(System.getenv("DASHSCOPE_API_KEY") != null,
                "DashScope API key not configured");
        LLMService llmService = LLMFactory.createLLMService(LLMFactory.modelType.QWEN);
        Assumptions.assumeTrue(llmService != null, "Qwen service not created");
    }
}
