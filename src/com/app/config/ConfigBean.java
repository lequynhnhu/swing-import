package com.app.config;

public class ConfigBean {
	private String filepath;  //文件路径
	private String datetime;  //时间
	private String runtype;   //运行方式
	private String isFirstRun; 
	public String getIsFirstRun() {
		return isFirstRun;
	}
	public void setIsFirstRun(String isFirstRun) {
		this.isFirstRun = isFirstRun;
	}
	private long delay;
	private long period;
	public long getDelay() {
		return delay;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}
	public long getPeriod() {
		return period;
	}
	public void setPeriod(long period) {
		this.period = period;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getDatetime() {
		return datetime;
	}
	public String getRuntype() {
		return runtype;
	}
	public void setRuntype(String runtype) {
		this.runtype = runtype;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
}
