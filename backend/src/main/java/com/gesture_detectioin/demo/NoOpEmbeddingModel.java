package com.gesture_detectioin.demo;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.embedding.Embedding;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoOpEmbeddingModel implements EmbeddingModel {
    @Override
    public EmbeddingResponse call(EmbeddingRequest request) {
        // Just return empty embeddings or throw to avoid misuse
        return new EmbeddingResponse(List.of(new Embedding(new float[]{10},0)));
    }

    @Override
    public float[] embed(Document document) {
        return new float[0];
    }
}

