
# 🏋️‍♂️ Pose Embedding Caching & Comparison in Flutter

This project compares different vector database technologies for caching and comparing **pose embeddings** generated from exercise detection models in Flutter apps.

---

## 📌 Use Case

> ✅ Cache **pose embeddings** for each exercise
> ✅ Match **current pose embedding** with cached ones
> ✅ Analyze performance using **vector similarity (cosine distance)**

---

## ⚖️ Comparison Table

| Feature                    | `pgvector (Supabase)`          | `ObjectBox (Flutter)`           | Other Vector DBs (Qdrant, Pinecone, etc.)  |
| -------------------------- | ------------------------------ | ------------------------------- | ------------------------------------------ |
| **Local or Remote**        | 🟡 Remote / Self-hosted        | ✅ Fully local                   | Depends (Qdrant = local, Pinecone = cloud) |
| **Flutter Native**         | ✅ Via Supabase client          | ✅ Dart-native                   | 🟡 HTTP/gRPC based only                    |
| **Offline Capable**        | ❌ No                           | ✅ Yes                           | ✅ Qdrant if self-hosted                    |
| **Ease of Setup**          | 🟡 Requires Docker/Supabase    | ✅ Easy with Dart plugin         | 🟡 HTTP setup needed                       |
| **Similarity Search**      | ✅ Built-in (cosine, L2, inner) | 🟡 Manual (custom Dart logic)   | ✅ Built-in                                 |
| **Query Language**         | ✅ SQL-based                    | ✅ Dart API                      | 🟡 Varies (HTTP, REST, etc.)               |
| **Embedding Size Support** | ✅ Up to 1536+                  | 🟡 Good for 128–512             | ✅ Up to 2048+                              |
| **Best Use Case**          | ✅ Central training, analytics  | ✅ Personal, on-device inference | ✅ Multi-user search and retrieval          |

---

## 🔧 Recommendations

### ✅ Use **ObjectBox** if:

* You want full **offline support**
* You plan to analyze embeddings **per user**
* You want **fast**, native Dart experience

### ✅ Use **pgvector** (with Supabase or Postgres) if:

* You want to **aggregate embeddings** across users
* You want server-side **vector queries**
* You’re okay with a **backend dependency**

### ✅ Use a **Hybrid Setup**:

* Cache locally in `ObjectBox`
* Sync to `pgvector` in Supabase for central training & analysis

---

## 💡 Suggested Architecture

```mermaid
graph TD
    A[Pose Detection Model] --> B[Generate Embedding]
    B --> C[ObjectBox Cache (local)]
    C -->|Offline Match| D[Compare with Past Embeddings]
    C -->|Sync| E[Supabase + pgvector]
    E -->|Central Analysis| F[Exercise Improvement Insights]
```

---

## 🧮 Vector Similarity Example (Dart)

```dart
double cosineSimilarity(List<double> a, List<double> b) {
  double dot = 0, magA = 0, magB = 0;
  for (int i = 0; i < a.length; i++) {
    dot += a[i] * b[i];
    magA += a[i] * a[i];
    magB += b[i] * b[i];
  }
  return dot / (sqrt(magA) * sqrt(magB));
}
```

---

## 🚀 Alternatives You Can Explore

| Vector DB    | Local/Cloud | Offline Capable | Use Case                                  |
| ------------ | ----------- | --------------- | ----------------------------------------- |
| **Qdrant**   | Self-hosted | ✅ Yes           | Personal/Team-wide vector search          |
| **Weaviate** | Cloud       | ❌ No            | Semantic, multi-modal search              |
| **Pinecone** | Cloud       | ❌ No            | Scalable commercial vector search         |
| **FAISS**    | Backend     | ❌ No            | High-speed training & inference pipelines |

---

## 📁 To-Do Next

* [ ] Setup `ObjectBox` model for embeddings
* [ ] Implement similarity matching in Dart
* [ ] (Optional) Setup Supabase + pgvector syncing

---

## 🙋 Need Help?

Want a working implementation of:

* ObjectBox schema?
* Supabase pgvector table?
* Sync logic between them?

**Let me know — I can provide complete starter code.**

---

Let me know if you'd like this exported to a `.md` file or shared as a GitHub-style starter template.
