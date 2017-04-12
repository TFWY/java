package com.sixth.sport.domain;

public class Guild {

	private Integer id;
	private String guildname;
	private String guildtime;
	private String guildcommon;
	private String  guildis;
	private String guildremark;
	
	public String getGuildremark() {
		return guildremark;
	}
	public void setGuildremark(String guildremark) {
		this.guildremark = guildremark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGuildname() {
		return guildname;
	}
	public void setGuildname(String guildname) {
		this.guildname = guildname;
	}
	public String getGuildtime() {
		return guildtime;
	}
	public void setGuildtime(String guildtime) {
		this.guildtime = guildtime;
	}
	public String getGuildcommon() {
		return guildcommon;
	}
	public void setGuildcommon(String guildcommon) {
		this.guildcommon = guildcommon;
	}
	public String getGuildis() {
		return guildis;
	}
	public void setGuildis(String guildis) {
		this.guildis = guildis;
	}

}
