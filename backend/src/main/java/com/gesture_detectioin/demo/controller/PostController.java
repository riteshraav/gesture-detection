package com.gesture_detectioin.demo.controller;

import com.gesture_detectioin.demo.DTO.PoseData;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

@RestController
public class PostController {
    @Autowired
    VectorStore vectorStore;
    @Autowired
    EmbeddingModel embeddingModel;

    @PostMapping("/pose")
    public ResponseEntity<Void> receivePose(@RequestBody PoseData pose) {
        System.out.println("pose called");
        float[] vector = pose.landmarks.stream()
                .flatMapToDouble(l -> DoubleStream.of(l.getX(), l.getY(), l.getZ()))
                .collect(
                        () -> FloatBuffer.allocate(pose.landmarks.size() * 3),
                        (buffer, value) -> buffer.put((float)value),
                        (buffer1, buffer2) -> {}
                )
                .array();
        System.out.println("vector created");
        System.out.println("vector length is "+vector.length);
        System.out.println("ts is "+pose.timestamp);
        Document document = new Document(String.valueOf(pose.timestamp), Map.of(
                "vector", vector,
                "ts", String.valueOf(pose.timestamp)
        ));
        System.out.println("documment created");
        vectorStore.add(List.of(document));

        return ResponseEntity.ok().build();
    }
}

