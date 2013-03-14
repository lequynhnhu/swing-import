package com.hib.moudle;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MapData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "map_data", catalog = "map")
public class MapData extends AbstractMapData implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MapData() {
	}

	/** minimal constructor */
	public MapData(String address) {
		super(address);
	}

	/** full constructor */
	public MapData(String east, String north, String name, String address,
			String phone, String city, String township, String datatype,
			String num, String content, Timestamp dateAdded, String eastNew,
			String northNew, Integer dataType, Integer comType, String code,
			String type) {
		super(east, north, name, address, phone, city, township, datatype, num,
				content, dateAdded, eastNew, northNew, dataType, comType, code,
				type);
	}

}
