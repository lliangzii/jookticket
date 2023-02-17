package org.liangzi.listener;

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
    //TODO：添加配置项：ticket_num
    int ticket_num = Integer.parseInt("config.ticket_num");
    @EventHandler
    public void onUserReact(UserAddReactionEvent event){
        User user = event.getUser();
        String msg_id = event.getMessageId();

        //TODO：添加配置项：category
        Category category = JKook.getHttpAPI().getCategory("config.category");

        //TODO：添加配置项：msg_id
        if("config.msg_id".equals(msg_id)) {
            Ticket ticket = new Ticket(ticket_num,category,user);
            ticket.createTicket();
            //TODO：向配置文件储存 ticket_num

            ticket_num++;
        }

    }
}
