package org.liangzi;

import snw.jkook.JKook;
import snw.jkook.plugin.BasePlugin;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/2/17 13:57
 * @Version 1.0
 */

public class Core extends BasePlugin {
    public static Core plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getLogger().info("Jook-ticket 启动成功");

//        JKook.getCore().getEventManager().registerHandlers(this, new UserReact());
    }

    @Override
    public void onDisable() {
        getLogger().info("Jook-ticket 卸载成功");
    }
}
