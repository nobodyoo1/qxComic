package com.comic.bean;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import com.comic.pojo.TbComic;
import com.comic.pojo.TbPicture;
import com.comic.pojo.TbUser;

public class MyUtils {
	public static void addPrefixforUser(TbUser user){
		String oldstr = user.getUserimage();
		user.setUserimage(MyConstants.URL_PREFIX + oldstr);
	}
	
	public static void addPrefixforCimic(TbComic comic){
		String oldstr = comic.getComiccover();
		comic.setComiccover(MyConstants.URL_PREFIX + oldstr);
	}
	public static void addPrefixforComics(List<TbComic> list){
		for(int i = 0; i < list.size(); i++){
			addPrefixforCimic(list.get(i));
		}
	}
	public static void addPrefixforComics(TbComic[] comics){
		addPrefixforComics(Arrays.asList(comics));
	}
	
	public static void addPrefixforPic(TbPicture pic){
		String oldstr = pic.getPictureurl();
		pic.setPictureurl((MyConstants.URL_PREFIX + oldstr));
	}
	public static void addPrefixforPics(List<TbPicture> list){
		for(int i = 0; i < list.size(); i++){
			addPrefixforPic(list.get(i));
		}
	}
	public static void addPrefixforPics(TbPicture[] pics){
		addPrefixforPics(Arrays.asList(pics));
	}
	
	public static void writeJsonStr(HttpServletResponse response,String jsonStr) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		out.write(jsonStr);
		out.flush();
		out.close();
	}
	
	public static <T> List<T> selectByPage(List<T> oldList,Integer page,MyConstants.ConsType type){
		int constant;
		List<T> result = new ArrayList<T>();
		switch (type) {
		case COMICS:
			constant = MyConstants.COMICS_PER_PAGE;
			break;
		case ITEMS:
			constant = MyConstants.ITEMS_PER_PAGE;
			break;
		case PICS:
			constant = MyConstants.PICS_PER_PAGE;
			break;
		default:
			constant = MyConstants.DEFAULT_PER_PAGE;
			break;
		}
		page = (page == null || page < 1) ? 1 : page;
		int fromIndex = constant * (page-1);
		int toIndex = constant * page;
		toIndex = toIndex > oldList.size() ? oldList.size() : toIndex;
		for(int i = fromIndex; i < toIndex; i++){
			result.add(oldList.get(i));
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static <T> T[] selectByPage(T[] oldArray,Integer page,MyConstants.ConsType type){
		List<T> result = selectByPage(Arrays.asList(oldArray), page, type);
		T[] newArray = (T[]) Array.newInstance(oldArray.getClass().getComponentType(), 0);
		return result.toArray(newArray);
	}
	
	/** 
	 * 获得字符集编码类型 
	 * @param str  
	 * @return 返回字符编码类型 
	 */  
	public static String getCharEncode(String str){  
	    String charEncode = "GB2312";  
	    try {  
	        if(str.equals(new String(str.getBytes(charEncode),charEncode))){  
	            return charEncode;  
	        }  
	    } catch (UnsupportedEncodingException e) {  
	    }  
	    charEncode = "GBK";  
	    try {  
	        if(str.equals(new String(str.getBytes(charEncode),charEncode))){  
	            return charEncode;  
	        }  
	    } catch (UnsupportedEncodingException e) {  
	    }  
	    charEncode = "ISO-8859-1";  
	    try {  
	        if(str.equals(new String(str.getBytes(charEncode),charEncode))){  
	            return charEncode;  
	        }  
	    } catch (UnsupportedEncodingException e) {  
	    }  
	    charEncode = "UTF-8";  
	    try {  
	        if(str.equals(new String(str.getBytes(charEncode),charEncode))){  
	            return charEncode;  
	        }  
	    } catch (UnsupportedEncodingException e) {  
	    }  
	    return "";  
	}  
	public static String transcodeToGBK(String str){  
	    return transcode(str,"GBK");  
	}  
	public static String transcodeToUTF_8(String str){  
	    return transcode(str,"UTF-8");  
	}  
	public static String transcode(String str,String charEncode){  
	    if(null==charEncode||"".equals(charEncode)){  
	        charEncode = "UTF-8";  
	    }  
	    String temp = "";  
	    try {  
	        String code = getCharEncode(str);  
	        temp = new String(str.getBytes(code),charEncode);  
	    } catch (UnsupportedEncodingException e) {  
	    }  
	    return temp;  
	}
	public static String getRandomImagePath(){
		File dir = new File(MyConstants.IMAGE_LOCATION);
		File[] images = dir.listFiles();
		int random = new Random().nextInt(images.length);
		return images[random].getName();
	}
}
