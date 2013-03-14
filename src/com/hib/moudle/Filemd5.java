package com.hib.moudle;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Filemd5 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "filemd5", catalog = "gopiao")
public class Filemd5 extends AbstractFilemd5 implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Filemd5() {
	}

	/** minimal constructor */
	public Filemd5(String id) {
		super(id);
	}

	/** full constructor */
	public Filemd5(String id, String filename, String md5) {
		super(id, filename, md5);
	}

}
