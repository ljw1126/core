package com.example.core.entity;

public enum Grade {
    BASIC,
    VIP;

    public boolean isVIP() {
        return this == VIP;
    }
}

