package com.matt.largeLanguageModel.factory.service;

import dev.langchain4j.community.model.dashscope.QwenChatModel;

public class QwenService implements LLMService{

    private final QwenChatModel qwenChatModel;

    public QwenService() {
        this.qwenChatModel = QwenChatModel.builder().build();
    }
    @Override
    public String chat(String prompt) {
        return qwenChatModel.chat(prompt);
    }
}
