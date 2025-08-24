package com.matt.largeLanguageModel.factory.service;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * Service for interacting with the Qwen chat model. The bean is only created
 * when a DashScope API key is provided via the {@code dashscope.api-key}
 * property. This prevents application start up failures during tests or in
 * environments where the key is not configured.
 */
@Service
@ConditionalOnProperty(name = "dashscope.api-key")
public class QwenService implements LLMService {

    private final QwenChatModel qwenChatModel;

    public QwenService(@Value("${dashscope.api-key}") String apiKey) {
        this.qwenChatModel = QwenChatModel.builder()
                .apiKey(apiKey)
                .build();
    }

    @Override
    public String chat(String prompt) {
        return qwenChatModel.chat(prompt);
    }
}
