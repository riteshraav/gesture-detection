package com.gesture_detectioin.demo.DTO;

import java.util.List;

public class PoseData {
    public String sessionId;
    public long timestamp;
    public List<Landmark> landmarks;

    public record Landmark(String type, float x, float y, float z) {
        public float getX() { return x; }
        public float getY() { return y; }
        public float getZ() { return z; }
    }
}
