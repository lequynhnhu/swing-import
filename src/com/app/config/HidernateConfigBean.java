package com.app.config;

public class HidernateConfigBean {
	private String password;
	private String username;
	private String dburl;
	private String showSql;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getShowSql() {
		return showSql;
	}
	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}
	
	
}
