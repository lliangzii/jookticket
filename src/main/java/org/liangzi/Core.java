package org.liangzi;

import org.liangzi.configs.GetConfig;
import org.liangzi.entity.Ticket;
import org.liangzi.listener.UserReact;
import snw.jkook.JKook;
import snw.jkook.plugin.BasePlugin;

import java.util.ArrayList;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/2/17 13:57
 * @Version 1.0
 */

public class Core extends BasePlugin {
    public static Core plugin;
    public static ArrayList<Ticket> ticket_list = null;
    public static int ticket_num = GetConfig.ticket_num();
    //TODO 加载配置文件
    @Override
    public void onEnable() {
        plugin = this;

        getLogger().info("Jook-ticket 启动成功");

        JKook.getCore().getEventManager().registerHandlers(this, new UserReact());
    }

    @Override
    public void onDisable() {

        if (ticket_list != null) {
            getLogger().info("检查到有未关闭的Ticket");
            getLogger().info("Jook-ticket正在删除所有ticket。。。");
            for (Ticket ticket : ticket_list) {
                ticket.deleteTicket();
            }
        }

        getLogger().info("Jook-ticket 卸载成功");
    }



}
