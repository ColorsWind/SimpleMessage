package com.brageast.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class JsonMessage {
	private int i = 0;
	//终于TMD不报错了0.0这日了狗的数组
	//private TextComponent[] msg = new TextComponent[] {};
	private List<TextComponent> msg = new ArrayList<TextComponent>();
	
	public List<TextComponent> getMsg() {
		return msg;
	}
	public JsonMessage() {
		
	}
	public JsonMessage(String s) {
		this.msg.add(new TextComponent(s.replace("&", "§")));
	}
	public JsonMessage append(String s) {
		i++;
		this.msg.add(new TextComponent(s.replace("&", "§")));
		return this;
	}
	//
	public JsonMessage append(JsonMessage jm) {
		if(jm == null) return this;
//		System.out.println(jm);
		i = i + jm.getMsg().size();
		msg.addAll(jm.getMsg());
		return this;
	}
	public JsonMessage setClickEvent(ClickEvent.Action a, String s) {
		this.msg.get(i).setClickEvent(
					new ClickEvent(a, s.replace("&", "§"))
				); 
		return this;
	}
	public JsonMessage setHoverEvent(HoverEvent.Action a, String s) {
		this.msg.get(i).setHoverEvent(
				new HoverEvent(
						a, new ComponentBuilder(s.replace("&", "§"))
						.create() 
				) 
		);
		return this;
		
	}
	public JsonMessage say(Player p) {
		TextComponent[] m = msg.toArray(new TextComponent[msg.size()]);
		p.spigot().sendMessage(m);
		return this;
	}
}
