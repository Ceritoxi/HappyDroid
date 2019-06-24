package com.zotlan.happyhappy.config.fallback;

import java.util.HashMap;
import java.util.Map;

public final class FallbackBarConfig {

    private static final String MAX_INSEC_KEY = "max.insec";
    private static final String ACCEPTABLE_MIN_INSEC_KEY = "acceptable.min.insec";
    private static final String DEFAULT_WIDTH_KEY = "default.width";
    private static final String DEFAULT_HEIGHT_KEY = "default.height";

    private static final String MAX_INSEC_VALUE = "30600";
    private static final String ACCEPTABLE_MIN_INSEC_VALUE = "28800";
    private static final String DEFAULT_WIDTH_VALUE = "350";
    private static final String DEFAULT_HEIGHT_VALUE = "25";

    private FallbackBarConfig() {
    }

    public static Map<String, String> getFallbackBarConfig() {
        return assemblyFallbackBarConfig();
    }

    private static Map<String, String> assemblyFallbackBarConfig() {
        final Map<String, String> result = new HashMap<>();
        result.put(MAX_INSEC_KEY, MAX_INSEC_VALUE);
        result.put(ACCEPTABLE_MIN_INSEC_KEY, ACCEPTABLE_MIN_INSEC_VALUE);
        result.put(DEFAULT_WIDTH_KEY, DEFAULT_WIDTH_VALUE);
        result.put(DEFAULT_HEIGHT_KEY, DEFAULT_HEIGHT_VALUE);
        return result;
    }
}
