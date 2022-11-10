package com.toonystank.skiesutilsbungee.iplimiter;

public enum IPLimitReturnType {
    SUCCESS(true),
    ALT(true),
    MAIN(true),
    ERROR(false),
    ALREADY_EXISTS(false),
    NOT_FOUND(false);

    private final boolean success;

    IPLimitReturnType(boolean success) {
        this.success = success;
    }
    public boolean getBoolean() {
        return success;
    }
}
