package com.comic.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MyConstants {
	static{
		InputStream in = MyConstants.class.getClassLoader().getResourceAsStream("constants.properties");
		Properties p = new Properties();
		try {
			p.load(in);;
		} catch (IOException e) {
			Logger logger = Logger.getLogger(MyConstants.class);
			logger.info("------------读取属性失败------------");
		}
		URL_PREFIX = p.getProperty("URL_PREFIX");
		SUC_FLAG = p.getProperty("SUC_FLAG");
		FAIL_FLAG = p.getProperty("FAIL_FLAG");
		COMICS_PER_PAGE = Integer.parseInt(p.getProperty("COMICS_PER_PAGE"));
		ITEMS_PER_PAGE = Integer.parseInt(p.getProperty("ITEMS_PER_PAGE"));
		PICS_PER_PAGE = Integer.parseInt(p.getProperty("PICS_PER_PAGE"));
		DEFAULT_PER_PAGE = Integer.parseInt(p.getProperty("DEFAULT_PER_PAGE"));
		IMAGE_LOCATION = MyUtils.transcodeToUTF_8(p.getProperty("IMAGE_LOCATION"));
	}

	public static final String URL_PREFIX;
	public static final String SUC_FLAG;
	public static final String FAIL_FLAG;
	
	public static final int COMICS_PER_PAGE;
	public static final int ITEMS_PER_PAGE;
	public static final int PICS_PER_PAGE;
	public static final int DEFAULT_PER_PAGE;
	
	public static final String IMAGE_LOCATION;
	
	public enum ConsType{
		COMICS,ITEMS,PICS;
	}
}
