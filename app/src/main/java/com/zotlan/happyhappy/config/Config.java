package com.zotlan.happyhappy.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {

    static final String CONFIG_ROOT = "configs/";
    private final Map<String, String> fallbackMap;

    private File configFile;
    private boolean configMapIsUpToDate;
    private long modifyTimestamp;
    private Map<String, String> configMap;

    Config(final String configFileName, final Map<String, String> fallbackMap) {
        this.configMap = new HashMap<>();
        this.configMapIsUpToDate = false;
        this.configFile = new File(configFileName);
        this.fallbackMap = fallbackMap;
        this.modifyTimestamp = configFile.lastModified();
    }

    private synchronized void initConfig() {
        try {
            final String rawConfigJSON = readInRawJSON();
            final TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
            };
            final ObjectMapper objectMapper = new ObjectMapper();
            configMap = objectMapper.readValue(rawConfigJSON, typeRef);
        } catch (IOException e) {
            System.err.println("Config file not found, falling back to default.");
            writeOutFallbackToFile();
            configMap = fallbackMap;
        } finally {
            configMapIsUpToDate = true;
        }
    }

    /**
     * well there must be a better way
     * @return
     */
    public boolean isFresh() {
        return configFile.lastModified() == modifyTimestamp;
    }
    /**
     * well there must be a better way
     * @return
     */
    public void resetConfig() {
        if (configFile.lastModified() != modifyTimestamp) {
            modifyTimestamp = configFile.lastModified();
            initConfig();
        }
    }

    public synchronized String getConfig(final String key) {
        if (!configMapIsUpToDate) {
            initConfig();
        }
        return configMap.get(key);
    }

    /**
     * Pretty high chance of death
     */
    public synchronized Integer getNumericConfig(final String key) {
        if (!configMapIsUpToDate) {
            initConfig();
        }
        return Integer.valueOf(configMap.get(key));
    }

    private String readInRawJSON() throws IOException {
        final FileReader reader = new FileReader(configFile);
        final StringBuilder rawConfigJSONBuilder = new StringBuilder();
        int inputChar;
        while ((inputChar = reader.read()) != -1) {
            rawConfigJSONBuilder.append((char) inputChar);
        }
        reader.close();
        return rawConfigJSONBuilder.toString();
    }

    private void writeOutFallbackToFile() {
        final ObjectMapper objectMapper = new ObjectMapper();
        new File(CONFIG_ROOT).mkdir();
        try(FileWriter writer = new FileWriter(configFile)) {
            final String jsonResult = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(fallbackMap);
            writer.write(jsonResult);
        } catch (IOException e) {
            System.err.println("Couldn't write the file out... that's a bummer");
        }
    }
}
