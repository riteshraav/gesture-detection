//package com.gesture_detectioin.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
//import org.springframework.ai.vectorstore.qdrant.QdrantVectorStoreConfig;
//import org.springframework.ai.embedding.EmbeddingClient;
//
//@Configuration
//public class VectorStoreConfig {
//
//    @Bean
//    public QdrantVectorStore vectorStore(EmbeddingClient embeddingClient) {
//        QdrantVectorStoreConfig config = QdrantVectorStoreConfig.builder()
//                .withRestUrl("http://localhost:6333") // or withGrpcHost + port if using gRPC
//                .withCollectionName("pose_db")
//                .withApiKey("") // leave blank if no API key is needed
//                .withUseTls(false)
//                .withInitSchema(true)
//                .build();
//
//        return new QdrantVectorStore(embeddingClient, config);
//    }
//}
