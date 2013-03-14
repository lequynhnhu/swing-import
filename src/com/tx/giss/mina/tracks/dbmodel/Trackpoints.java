package com.tx.giss.mina.tracks.dbmodel;

/**
 * Trackpoints entity. @author MyEclipse Persistence Tools
 */

public class Trackpoints implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer trackpointId;
	private Integer trackid;
	private Integer longitude;
	private Integer latitude;
	private Integer time;
	private Float elevation;
	private Float accuracy;
	private Float speed;
	private Float bearing;
	private String sensor;
	private Integer offsetLon;
	private Integer offsetLat;
	private Integer userid;
	private String altitude;
	private String trackuuid;

	// Constructors

	/** default constructor */
	public Trackpoints() {
	}

	/** full constructor */
	public Trackpoints(Integer trackpointId, Integer trackid,
			Integer longitude, Integer latitude, Integer time, Float elevation,
			Float accuracy, Float speed, Float bearing, String sensor,
			Integer offsetLon, Integer offsetLat, Integer userid,
			String altitude, String trackuuid) {
		this.trackpointId = trackpointId;
		this.trackid = trackid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.time = time;
		this.elevation = elevation;
		this.accuracy = accuracy;
		this.speed = speed;
		this.bearing = bearing;
		this.sensor = sensor;
		this.offsetLon = offsetLon;
		this.offsetLat = offsetLat;
		this.userid = userid;
		this.altitude = altitude;
		this.trackuuid = trackuuid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTrackpointId() {
		return this.trackpointId;
	}

	public void setTrackpointId(Integer trackpointId) {
		this.trackpointId = trackpointId;
	}

	public Integer getTrackid() {
		return this.trackid;
	}

	public void setTrackid(Integer trackid) {
		this.trackid = trackid;
	}

	public Integer getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Float getElevation() {
		return this.elevation;
	}

	public void setElevation(Float elevation) {
		this.elevation = elevation;
	}

	public Float getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(Float accuracy) {
		this.accuracy = accuracy;
	}

	public Float getSpeed() {
		return this.speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Float getBearing() {
		return this.bearing;
	}

	public void setBearing(Float bearing) {
		this.bearing = bearing;
	}

	public String getSensor() {
		return this.sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public Integer getOffsetLon() {
		return this.offsetLon;
	}

	public void setOffsetLon(Integer offsetLon) {
		this.offsetLon = offsetLon;
	}

	public Integer getOffsetLat() {
		return this.offsetLat;
	}

	public void setOffsetLat(Integer offsetLat) {
		this.offsetLat = offsetLat;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAltitude() {
		return this.altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getTrackuuid() {
		return this.trackuuid;
	}

	public void setTrackuuid(String trackuuid) {
		this.trackuuid = trackuuid;
	}

}