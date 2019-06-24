//package com.zotlan.happyhappy.refresh;
//
//import com.zotlan.happyhappy.config.Config;
//import com.zotlan.happyhappy.ui.screen.Screen;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * some clusterfuck
// */
//public class ConfigRefresher extends Thread {
//
//    private Screen screen;
//    private List<Config> configs;
//
//    public ConfigRefresher(final Screen screen, final List<Config> configs) {
//        super();
//        this.screen = screen;
//        this.configs = configs;
//    }
//
//    @Override public void run() {
//        while (screen != null) {
//            List<Config> outdatedConfigs = collectOutdatedConfigs();
//            if (outdatedConfigs != null && !outdatedConfigs.isEmpty()) {
//                try {
//                    sleep(500);//don't do this kids
//                } catch (InterruptedException e) {
//                    System.err.println("Interrupted yoohoo");
//                }
//                for (Config outdatedConfig : outdatedConfigs) {
//                    outdatedConfig.resetConfig();
//                }
//            }
//            eyySlowDown();
//        }
//    }
//
//    private List<Config> collectOutdatedConfigs() {
//        List<Config> result = new ArrayList<>();
//        for (Config config : configs) {
//            if (!config.isFresh()) {
//                result.add(config);
//            }
//        }
//        return result;
//    }
//
//    private void eyySlowDown() {
//        try {
//            sleep(200);
//        } catch (InterruptedException e) {
//            System.err.println("Interrupted yoohoo");
//        }
//    }
//}
