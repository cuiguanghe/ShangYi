package cn.com.shangyi.common.util;

import java.io.File;

public class BaseModel {
	private File picFile;
	private String imgUrl;
	private String picFileFileName;

	/**
	 * @return the picFileFileName
	 */
	public String getPicFileFileName() {
		return picFileFileName;
	}

	/**
	 * @param picFileFileName
	 *            the picFileFileName to set
	 */
	public void setPicFileFileName(String picFileFileName) {
		this.picFileFileName = picFileFileName;
	}

	/**
	 * @return the picFile
	 */
	public File getPicFile() {
		return picFile;
	}

	/**
	 * @param picFile
	 *            the picFile to set
	 */
	public void setPicFile(File picFile) {
		this.picFile = picFile;
	}

	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param imgUrl
	 *            the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
