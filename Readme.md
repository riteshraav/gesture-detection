
# Pose Embedding Caching & Comparison in Flutter


## Comparison Table

| Feature                    | `pgvector (Supabase)`          | `ObjectBox (Flutter)`           | 
| -------------------------- | ------------------------------ | ------------------------------- | 
| **Local or Remote**        |  Remote / Self-hosted        |  Fully local                   |
| **Flutter Native**         |  Via Supabase client          |  Dart-native                   | 
| **Offline Capable**        |  No                           |  Yes                           |
| **Ease of Setup**          |  Requires Docker/Supabase    |  Easy with Dart plugin         | 
| **Similarity Search**      |  Built-in (cosine, L2, inner) |  Manual (custom Dart logic)   | 
| **Query Language**         |  SQL-based                    |  Dart API                      |
| **Embedding Size Support** |  Up to 1536+                  |  Good for 128–512             |
| **Best Use Case**          |  Central training, analytics  |  Personal, on-device inference | 

---

## 🔧 Recommendations

###  **ObjectBox** 

* **offline support**
* analyze embeddings **per user**
* **fast**, native Dart experience

### Use **pgvector** (with Supabase or Postgres) 

*  **aggregate embeddings** across users
* server-side **vector queries**
*  **backend dependency**

### Use a **Hybrid Setup**:

* Cache locally in `ObjectBox`
* Sync to `pgvector` in Supabase for central training & analysis


##  Alternatives You Can Explore

| Vector DB    | Local/Cloud | Offline Capable | Use Case                                  |
| ------------ | ----------- | --------------- | ----------------------------------------- |
| **Qdrant**   | Self-hosted |  Yes           | Personal/Team-wide vector search          |
| **Weaviate** | Cloud       |  No            | Semantic, multi-modal search              |
| **Pinecone** | Cloud       |  No            | Scalable commercial vector search         |
| **FAISS**    | Backend     |  No            | High-speed training & inference pipelines |

