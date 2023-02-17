package org.liangzi.configs;

import snw.jkook.config.file.FileConfiguration;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/2/17 18:40
 * @Version 1.0
 */

public class GetConfig {
    private GetConfig() {
    }

    public static int ticket_num() {
        return Integer.parseInt(getConfigs().getString("ticket_num"));
    }
    public static String category() {
        return getConfigs().getString("settings.category");
    }
    public static String msg_id() {
        return getConfigs().getString("settings.msg_id");
    }


    public static void reloadFiles() {
        DefConfigs.getInstance().reloadInfo();
    }

    public static FileConfiguration getConfigs() {
        return DefConfigs.getInstance().getConfig();
    }

}
