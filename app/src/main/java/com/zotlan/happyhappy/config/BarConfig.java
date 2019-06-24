package com.zotlan.happyhappy.config;

import com.zotlan.happyhappy.config.fallback.FallbackBarConfig;

public final class BarConfig extends Config {

    private volatile static BarConfig barConfig;
    private static final String CONFIG_FILE_NAME = CONFIG_ROOT + "bar.cfg";

    private BarConfig() {
        super(CONFIG_FILE_NAME, FallbackBarConfig.getFallbackBarConfig());
    }

    public static BarConfig getInstance() {
        if (barConfig == null) {
            synchronized (BarConfig.class) {
                if (barConfig == null) {
                    barConfig = new BarConfig();
                }
            }
        }
        return barConfig;
    }

}
