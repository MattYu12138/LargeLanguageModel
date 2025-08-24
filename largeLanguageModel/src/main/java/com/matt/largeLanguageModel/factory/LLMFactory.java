package com.matt.largeLanguageModel.factory;

import com.matt.largeLanguageModel.factory.service.LLMService;
import com.matt.largeLanguageModel.factory.service.OpenAiService;
import com.matt.largeLanguageModel.factory.service.QwenService;


public class LLMFactory {

    public enum modelType {
        OPENAI, QWEN
    }

    public static LLMService createLLMService(modelType type) {
        return switch(type){
            case QWEN -> new QwenService();
            case OPENAI -> new OpenAiService();
        };
    }
}
