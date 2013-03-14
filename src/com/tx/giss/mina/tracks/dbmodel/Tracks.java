package com.tx.giss.mina.tracks.dbmodel;

/**
 * Tracks entity. @author MyEclipse Persistence Tools
 */

public class Tracks implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer tracksId;
	private String name;
	private String description;
	private Integer stopId;
	private Integer startId;
	private Integer starttime;
	private Integer stoptime;
	private Integer numpoints;
	private Float totaldistance;
	private Integer totaltime;
	private Integer movingtime;
	private Integer minlat;
	private Integer maxlat;
	private Integer minlon;
	private Integer maxlon;
	private Float avgspeed;
	private Float avgmovingspeed;
	private Float maxspeed;
	private Float minelevation;
	private Float maxelevation;
	private Float elevationgain;
	private Float mingrade;
	private Float maxgrade;
	private String mapid;
	private String tableid;
	private Integer userid;
	private String icon;
	private String category;
	private String uuid;

	// Constructors

	/** default constructor */
	public Tracks() {
	}

	/** full constructor */
	public Tracks(Integer tracksId, String name, String description,
			Integer stopId, Integer startId, Integer starttime,
			Integer stoptime, Integer numpoints, Float totaldistance,
			Integer totaltime, Integer movingtime, Integer minlat,
			Integer maxlat, Integer minlon, Integer maxlon, Float avgspeed,
			Float avgmovingspeed, Float maxspeed, Float minelevation,
			Float maxelevation, Float elevationgain, Float mingrade,
			Float maxgrade, String mapid, String tableid, Integer userid,
			String icon, String category, String uuid) {
		this.tracksId = tracksId;
		this.name = name;
		this.description = description;
		this.stopId = stopId;
		this.startId = startId;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.numpoints = numpoints;
		this.totaldistance = totaldistance;
		this.totaltime = totaltime;
		this.movingtime = movingtime;
		this.minlat = minlat;
		this.maxlat = maxlat;
		this.minlon = minlon;
		this.maxlon = maxlon;
		this.avgspeed = avgspeed;
		this.avgmovingspeed = avgmovingspeed;
		this.maxspeed = maxspeed;
		this.minelevation = minelevation;
		this.maxelevation = maxelevation;
		this.elevationgain = elevationgain;
		this.mingrade = mingrade;
		this.maxgrade = maxgrade;
		this.mapid = mapid;
		this.tableid = tableid;
		this.userid = userid;
		this.icon = icon;
		this.category = category;
		this.uuid = uuid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTracksId() {
		return this.tracksId;
	}

	public void setTracksId(Integer tracksId) {
		this.tracksId = tracksId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStopId() {
		return this.stopId;
	}

	public void setStopId(Integer stopId) {
		this.stopId = stopId;
	}

	public Integer getStartId() {
		return this.startId;
	}

	public void setStartId(Integer startId) {
		this.startId = startId;
	}

	public Integer getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Integer starttime) {
		this.starttime = starttime;
	}

	public Integer getStoptime() {
		return this.stoptime;
	}

	public void setStoptime(Integer stoptime) {
		this.stoptime = stoptime;
	}

	public Integer getNumpoints() {
		return this.numpoints;
	}

	public void setNumpoints(Integer numpoints) {
		this.numpoints = numpoints;
	}

	public Float getTotaldistance() {
		return this.totaldistance;
	}

	public void setTotaldistance(Float totaldistance) {
		this.totaldistance = totaldistance;
	}

	public Integer getTotaltime() {
		return this.totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	public Integer getMovingtime() {
		return this.movingtime;
	}

	public void setMovingtime(Integer movingtime) {
		this.movingtime = movingtime;
	}

	public Integer getMinlat() {
		return this.minlat;
	}

	public void setMinlat(Integer minlat) {
		this.minlat = minlat;
	}

	public Integer getMaxlat() {
		return this.maxlat;
	}

	public void setMaxlat(Integer maxlat) {
		this.maxlat = maxlat;
	}

	public Integer getMinlon() {
		return this.minlon;
	}

	public void setMinlon(Integer minlon) {
		this.minlon = minlon;
	}

	public Integer getMaxlon() {
		return this.maxlon;
	}

	public void setMaxlon(Integer maxlon) {
		this.maxlon = maxlon;
	}

	public Float getAvgspeed() {
		return this.avgspeed;
	}

	public void setAvgspeed(Float avgspeed) {
		this.avgspeed = avgspeed;
	}

	public Float getAvgmovingspeed() {
		return this.avgmovingspeed;
	}

	public void setAvgmovingspeed(Float avgmovingspeed) {
		this.avgmovingspeed = avgmovingspeed;
	}

	public Float getMaxspeed() {
		return this.maxspeed;
	}

	public void setMaxspeed(Float maxspeed) {
		this.maxspeed = maxspeed;
	}

	public Float getMinelevation() {
		return this.minelevation;
	}

	public void setMinelevation(Float minelevation) {
		this.minelevation = minelevation;
	}

	public Float getMaxelevation() {
		return this.maxelevation;
	}

	public void setMaxelevation(Float maxelevation) {
		this.maxelevation = maxelevation;
	}

	public Float getElevationgain() {
		return this.elevationgain;
	}

	public void setElevationgain(Float elevationgain) {
		this.elevationgain = elevationgain;
	}

	public Float getMingrade() {
		return this.mingrade;
	}

	public void setMingrade(Float mingrade) {
		this.mingrade = mingrade;
	}

	public Float getMaxgrade() {
		return this.maxgrade;
	}

	public void setMaxgrade(Float maxgrade) {
		this.maxgrade = maxgrade;
	}

	public String getMapid() {
		return this.mapid;
	}

	public void setMapid(String mapid) {
		this.mapid = mapid;
	}

	public String getTableid() {
		return this.tableid;
	}

	public void setTableid(String tableid) {
		this.tableid = tableid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}