package com.zotlan.happyhappy.config;

@Deprecated
public final class ConfigStatus {

    private boolean needsReset = true;

    private volatile static ConfigStatus configStatus;

    private ConfigStatus() {
    }

    public static ConfigStatus getInstance() {
        if (configStatus == null) {
            synchronized (ConfigStatus.class) {
                if (configStatus == null) {
                    configStatus = new ConfigStatus();
                }
            }
        }
        return configStatus;
    }

    public boolean eedsReset() {
        return needsReset;
    }

    public void setNeedsReset(final boolean needsReset) {
        this.needsReset = needsReset;
    }
}
