package com.zotlan.happyhappy.config;

import com.zotlan.happyhappy.config.fallback.FallbackBarColorConfig;

public final class BarColorConfig extends Config{

    private static final int COLOR_LIMIT = 256;
    private volatile static BarColorConfig barColorConfig;
    private static final String CONFIG_FILE_NAME = CONFIG_ROOT + "bar_color.cfg";

    private BarColorConfig() {
        super(CONFIG_FILE_NAME, FallbackBarColorConfig.getFallbackBarColorConfig());
    }

    public static BarColorConfig getInstance() {
        if (barColorConfig == null) {
            synchronized (BarColorConfig.class) {
                if (barColorConfig == null) {
                    barColorConfig = new BarColorConfig();
                }
            }
        }
        return barColorConfig;
    }

    @Override
    public Integer getNumericConfig(final String key) {
        return super.getNumericConfig(key) % COLOR_LIMIT;
    }
}
