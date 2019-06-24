package com.zotlan.happyhappy.config;

import com.zotlan.happyhappy.config.fallback.FallbackGeneralConfig;

public final class GeneralConfig extends Config{

    private volatile static GeneralConfig generalConfig;
    private static final String CONFIG_FILE_NAME = CONFIG_ROOT + "config.cfg";


    private GeneralConfig() {
        super(CONFIG_FILE_NAME, FallbackGeneralConfig.getFallbackGeneralConfig());
    }

    public static GeneralConfig getInstance() {
        if (generalConfig == null) {
            synchronized (GeneralConfig.class) {
                if (generalConfig == null) {
                    generalConfig = new GeneralConfig();
                }
            }
        }
        return generalConfig;
    }
}
