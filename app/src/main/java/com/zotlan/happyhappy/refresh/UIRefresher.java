//package com.zotlan.happyhappy.refresh;
//
//import com.zotlan.happyhappy.ui.bar.RefreshableBar;
//import com.zotlan.happyhappy.ui.combobox.Box;
//import com.zotlan.happyhappy.ui.screen.Screen;
//
//public class UIRefresher extends Thread {
//
//    private Screen screen;
//
//    public UIRefresher(final Screen screen) {
//        super();
//        this.screen = screen;
//    }
//
//    @Override public void run() {
//        while (screen != null) {
//            screen.refresh();
//            refreshRefreshableBars();
//            refreshComboBoxes();
//            eyySlowDown();
//        }
//    }
//
//    private void eyySlowDown() {
//        try {
//            sleep(200);
//        } catch (InterruptedException e) {
//            System.err.println("Interrupted yoohoo");
//        }
//    }
//
//    private void refreshRefreshableBars() {
//        for (final RefreshableBar bar : screen.getRefreshableBars()) {
//            bar.refresh();
//        }
//    }
//
//    private void refreshComboBoxes() {
//        for (final Box box : screen.getComboBoxes()) {
//            box.refresh();
//        }
//    }
//}
