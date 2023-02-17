package org.liangzi.entity;

import snw.jkook.entity.Guild;
import snw.jkook.entity.Role;
import snw.jkook.entity.User;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.TextChannel;

/**
 * @Description
 * @Author liangzi
 * @Date 2023/2/17 14:07
 * @Version 1.0
 */

public class Ticket {
    int ticket_num;
    Category category;
    User user;
    Role role;
    TextChannel textChannel;
    Guild guild;

    public Ticket(int num){
        this.ticket_num = num;
    }
    public Ticket(int num,Category category,User user){
        this.ticket_num = num;
        this.category = category;
        this.user = user;
        this.guild = category.getGuild();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.guild = category.getGuild();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public TextChannel getTextChannel() {
        return textChannel;
    }

    /**
     *创建Ticket频道与TicketUser角色
     */
    public void createTicket(){
        //创建TicketUser角色
        this.role = guild.createRole("Ticket-"+ticket_num);
        user.grantRole(this.role);

        //创建Ticket频道
        this.textChannel = guild.createTextChannel("Ticket-"+ticket_num,category);

        //设置权限：仅 "TicketUser"（角色）可见Ticket频道
        textChannel.updatePermission(0,0,2048);
        textChannel.updatePermission(role,6144,0);

    }

    public void deleteTicket(){
        //撤销TicketUser角色
        user.revokeRole(this.role);

        //删除TicketUser角色
        role.delete();

        //删除Ticket频道
        textChannel.delete();
    }

    /**
     *检查某个频道是否是一个Ticket，返回布尔值
     */
    public boolean checkTicket(TextChannel textChannel){
        return (textChannel == this.textChannel);
    }
    public boolean checkTicket(User user, TextChannel textChannel){
        return (user == this.user && textChannel == this.textChannel);
    }

}
