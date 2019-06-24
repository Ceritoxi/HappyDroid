package com.zotlan.happyhappy.config.fallback;

import java.util.HashMap;
import java.util.Map;

/**
 * yeah ikr, i should use objects and shit
 */
@Deprecated
public final class FallbackOldBarColorConfig {

    private static final String BAR_DEFAULT_RED_KEY = "color.default.red";
    private static final String BAR_DEFAULT_GREEN_KEY = "color.default.green";
    private static final String BAR_DEFAULT_BLUE_KEY = "color.default.blue";
    private static final String PHASE_1_RED_KEY = "colorchange.phase.1.red";
    private static final String PHASE_1_GREEN_KEY = "colorchange.phase.1.green";
    private static final String PHASE_1_BLUE_KEY = "colorchange.phase.1.blue";
    private static final String PHASE_2_RED_KEY = "colorchange.phase.2.red";
    private static final String PHASE_2_GREEN_KEY = "colorchange.phase.2.green";
    private static final String PHASE_2_BLUE_KEY = "colorchange.phase.2.blue";
    private static final String PHASE_3_RED_KEY = "colorchange.phase.3.red";
    private static final String PHASE_3_GREEN_KEY = "colorchange.phase.3.green";
    private static final String PHASE_3_BLUE_KEY = "colorchange.phase.3.blue";
    private static final String PHASE_4_RED_KEY = "colorchange.phase.4.red";
    private static final String PHASE_4_GREEN_KEY = "colorchange.phase.4.green";
    private static final String PHASE_4_BLUE_KEY = "colorchange.phase.4.blue";
    private static final String PHASE_5_RED_KEY = "colorchange.phase.5.red";
    private static final String PHASE_5_GREEN_KEY = "colorchange.phase.5.green";
    private static final String PHASE_5_BLUE_KEY = "colorchange.phase.5.blue";
    private static final String PHASE_6_RED_KEY = "colorchange.phase.6.red";
    private static final String PHASE_6_GREEN_KEY = "colorchange.phase.6.green";
    private static final String PHASE_6_BLUE_KEY = "colorchange.phase.6.blue";
    private static final String PHASE_7_RED_KEY = "colorchange.phase.7.red";
    private static final String PHASE_7_GREEN_KEY = "colorchange.phase.7.green";
    private static final String PHASE_7_BLUE_KEY = "colorchange.phase.7.blue";

    private static final String BAR_DEFAULT_RED_VALUE = "0";
    private static final String BAR_DEFAULT_GREEN_VALUE = "0";
    private static final String BAR_DEFAULT_BLUE_VALUE = "255";
    private static final String PHASE_1_RED_VALUE = "255";
    private static final String PHASE_1_GREEN_VALUE = "0";
    private static final String PHASE_1_BLUE_VALUE = "0";
    private static final String PHASE_2_RED_VALUE = "224";
    private static final String PHASE_2_GREEN_VALUE = "100";
    private static final String PHASE_2_BLUE_VALUE = "0";
    private static final String PHASE_3_RED_VALUE = "224";
    private static final String PHASE_3_GREEN_VALUE = "164";
    private static final String PHASE_3_BLUE_VALUE = "0";
    private static final String PHASE_4_RED_VALUE = "229";
    private static final String PHASE_4_GREEN_VALUE = "210";
    private static final String PHASE_4_BLUE_VALUE = "39";
    private static final String PHASE_5_RED_VALUE = "189";
    private static final String PHASE_5_GREEN_VALUE = "219";
    private static final String PHASE_5_BLUE_VALUE = "0";
    private static final String PHASE_6_RED_VALUE = "138";
    private static final String PHASE_6_GREEN_VALUE = "219";
    private static final String PHASE_6_BLUE_VALUE = "0";
    private static final String PHASE_7_RED_VALUE = "83";
    private static final String PHASE_7_GREEN_VALUE = "216";
    private static final String PHASE_7_BLUE_VALUE = "0";

    private FallbackOldBarColorConfig() {
    }

    public static Map<String, String> getFallbackBarColorConfig() {
        return assemblyFallbackConfig();
    }

    private static Map<String, String> assemblyFallbackConfig() {
        final Map<String, String> result = new HashMap<>();
        result.put(BAR_DEFAULT_RED_KEY, BAR_DEFAULT_RED_VALUE);
        result.put(BAR_DEFAULT_GREEN_KEY, BAR_DEFAULT_GREEN_VALUE);
        result.put(BAR_DEFAULT_BLUE_KEY, BAR_DEFAULT_BLUE_VALUE);
        result.put(PHASE_1_RED_KEY, PHASE_1_RED_VALUE);
        result.put(PHASE_1_GREEN_KEY, PHASE_1_GREEN_VALUE);
        result.put(PHASE_1_BLUE_KEY, PHASE_1_BLUE_VALUE);
        result.put(PHASE_2_RED_KEY, PHASE_2_RED_VALUE);
        result.put(PHASE_2_GREEN_KEY, PHASE_2_GREEN_VALUE);
        result.put(PHASE_2_BLUE_KEY, PHASE_2_BLUE_VALUE);
        result.put(PHASE_3_RED_KEY, PHASE_3_RED_VALUE);
        result.put(PHASE_3_GREEN_KEY, PHASE_3_GREEN_VALUE);
        result.put(PHASE_3_BLUE_KEY, PHASE_3_BLUE_VALUE);
        result.put(PHASE_4_RED_KEY, PHASE_4_RED_VALUE);
        result.put(PHASE_4_GREEN_KEY, PHASE_4_GREEN_VALUE);
        result.put(PHASE_4_BLUE_KEY, PHASE_4_BLUE_VALUE);
        result.put(PHASE_5_RED_KEY, PHASE_5_RED_VALUE);
        result.put(PHASE_5_GREEN_KEY, PHASE_5_GREEN_VALUE);
        result.put(PHASE_5_BLUE_KEY, PHASE_5_BLUE_VALUE);
        result.put(PHASE_6_RED_KEY, PHASE_6_RED_VALUE);
        result.put(PHASE_6_GREEN_KEY, PHASE_6_GREEN_VALUE);
        result.put(PHASE_6_BLUE_KEY, PHASE_6_BLUE_VALUE);
        result.put(PHASE_7_RED_KEY, PHASE_7_RED_VALUE);
        result.put(PHASE_7_GREEN_KEY, PHASE_7_GREEN_VALUE);
        result.put(PHASE_7_BLUE_KEY, PHASE_7_BLUE_VALUE);
        return result;
    }

}
