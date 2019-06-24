package com.zotlan.happyhappy.config.fallback;

import java.util.HashMap;
import java.util.Map;

public final class FallbackGeneralConfig {

    private static final String DEFAULT_SCREEN_TITLE_KEY = "screen.title";
    private static final String DEFAULT_SCREEN_WIDTH_KEY = "screen.width";
    private static final String DEFAULT_SCREEN_HEIGHT_KEY = "screen.height";

    private static final String DEFAULT_SCREEN_TITLE_VALUE = "HAPPY HOURS";
    private static final String DEFAULT_SCREEN_WIDTH_VALUE = "800";
    private static final String DEFAULT_SCREEN_HEIGHT_VALUE = "600";

    private FallbackGeneralConfig() {
    }

    public static Map<String, String> getFallbackGeneralConfig() {
        return assemblyFallbackGeneralConfig();
    }

    private static Map<String, String> assemblyFallbackGeneralConfig() {
        final Map<String, String> result = new HashMap<>();
        result.put(DEFAULT_SCREEN_TITLE_KEY, DEFAULT_SCREEN_TITLE_VALUE);
        result.put(DEFAULT_SCREEN_WIDTH_KEY, DEFAULT_SCREEN_WIDTH_VALUE);
        result.put(DEFAULT_SCREEN_HEIGHT_KEY, DEFAULT_SCREEN_HEIGHT_VALUE);
        return result;
    }
}
