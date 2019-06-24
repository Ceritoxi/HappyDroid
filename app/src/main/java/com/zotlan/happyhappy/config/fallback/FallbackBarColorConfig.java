package com.zotlan.happyhappy.config.fallback;

import java.util.HashMap;
import java.util.Map;

public final class FallbackBarColorConfig {

    private static final String COLOR_DEFAULT_RED_KEY = "color.default.red";
    private static final String COLOR_DEFAULT_GREEN_KEY = "color.default.green";
    private static final String COLOR_DEFAULT_BLUE_KEY = "color.default.blue";
    private static final String FIRST_REDNESS_KEY = "first.redness";
    private static final String FIRST_GREENNESS_KEY = "first.greenness";
    private static final String FIRST_BLUENESS_KEY = "first.blueness";
    private static final String MID_REDNESS_KEY = "mid.redness";
    private static final String MID_GREENNESS_KEY = "mid.greenness";
    private static final String MID_BLUENESS_KEY = "mid.blueness";
    private static final String LAST_REDNESS_KEY = "last.redness";
    private static final String LAST_GREENNESS_KEY = "last.greenness";
    private static final String LAST_BLUENESS_KEY = "last.blueness";

    private static final String COLOR_DEFAULT_RED_VALUE = "68";
    private static final String COLOR_DEFAULT_GREEN_VALUE = "131";
    private static final String COLOR_DEFAULT_BLUE_VALUE = "234";
    private static final String FIRST_REDNESS_VALUE = "140";
    private static final String FIRST_GREENNESS_VALUE = "5";
    private static final String FIRST_BLUENESS_VALUE = "5";
    private static final String MID_REDNESS_VALUE = "250";
    private static final String MID_GREENNESS_VALUE = "190";
    private static final String MID_BLUENESS_VALUE = "55";
    private static final String LAST_REDNESS_VALUE = "10";
    private static final String LAST_GREENNESS_VALUE = "160";
    private static final String LAST_BLUENESS_VALUE = "50";

    private FallbackBarColorConfig() {
    }

    public static Map<String, String> getFallbackBarColorConfig() {
        return assemblyFallbackConfig();
    }

    private static Map<String, String> assemblyFallbackConfig() {
        final Map<String, String> result = new HashMap<>();
        result.put(COLOR_DEFAULT_RED_KEY, COLOR_DEFAULT_RED_VALUE);
        result.put(COLOR_DEFAULT_GREEN_KEY, COLOR_DEFAULT_GREEN_VALUE);
        result.put(COLOR_DEFAULT_BLUE_KEY, COLOR_DEFAULT_BLUE_VALUE);
        result.put(FIRST_REDNESS_KEY, FIRST_REDNESS_VALUE);
        result.put(FIRST_GREENNESS_KEY, FIRST_GREENNESS_VALUE);
        result.put(FIRST_BLUENESS_KEY, FIRST_BLUENESS_VALUE);
        result.put(MID_REDNESS_KEY, MID_REDNESS_VALUE);
        result.put(MID_GREENNESS_KEY, MID_GREENNESS_VALUE);
        result.put(MID_BLUENESS_KEY, MID_BLUENESS_VALUE);
        result.put(LAST_REDNESS_KEY, LAST_REDNESS_VALUE);
        result.put(LAST_GREENNESS_KEY, LAST_GREENNESS_VALUE);
        result.put(LAST_BLUENESS_KEY, LAST_BLUENESS_VALUE);
        return result;
    }
}
