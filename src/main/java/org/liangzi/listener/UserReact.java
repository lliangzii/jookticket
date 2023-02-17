package org.liangzi.listener;

import org.liangzi.Core;
import org.liangzi.configs.DefConfigs;
import org.liangzi.configs.GetConfig;
import org.liangzi.entity.Ticket;
import snw.jkook.JKook;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Category;
import snw.jkook.event.EventHandler;
import snw.jkook.event.Listener;
import snw.jkook.event.user.UserAddReactionEvent;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/2/17 14:05
 * @Version 1.0
 */

public class UserReact implements Listener {
    @EventHandler
    public void onUserReact(UserAddReactionEvent event){
        User user = event.getUser();
        String msg_id = event.getMessageId();
        Category category = JKook.getHttpAPI().getCategory(GetConfig.category());

        if(GetConfig.msg_id().equals(msg_id)) {
            Ticket ticket = new Ticket(Core.ticket_num,category,user);

            //向配置文件储存 ticket_num
            Core.ticket_num++;
            DefConfigs.getInstance().getConfig().set("ticket_num",Core.ticket_num);
            DefConfigs.getInstance().saveConfigs();
        }

    }
}
