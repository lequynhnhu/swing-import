package com.app.importdata;

import java.io.File;

public interface IdataProvider {
	public abstract void readTxt(File f);
	public abstract void readExcel(File f);
	public abstract void start(File f);
}
