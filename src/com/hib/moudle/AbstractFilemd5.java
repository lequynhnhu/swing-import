package com.hib.moudle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractFilemd5 entity provides the base persistence definition of the
 * Filemd5 entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractFilemd5 implements java.io.Serializable {

	// Fields

	private String id;
	private String filename;
	private String md5;

	// Constructors

	/** default constructor */
	public AbstractFilemd5() {
	}

	/** minimal constructor */
	public AbstractFilemd5(String id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractFilemd5(String id, String filename, String md5) {
		this.id = id;
		this.filename = filename;
		this.md5 = md5;
	}

	// Property accessors
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "filename", length = 100)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "md5", length = 100)
	public String getMd5() {
		return this.md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}