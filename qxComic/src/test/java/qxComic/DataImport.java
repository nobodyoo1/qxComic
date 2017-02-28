package qxComic;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.comic.pojo.TbUser;

public class DataImport {

	public static void main(String[] args){
		TbUser tbUser = new TbUser();
		tbUser.setUsername("dfadf");
		tbUser.setUserid(123);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("success", tbUser);
		String str = JSON.toJSONString(map);
		System.out.println(str);
		
		JSONObject newMap = JSON.parseObject(str);
		TbUser user = JSON.parseObject((String)newMap.getString("success"), TbUser.class);
		System.out.println(user);
		String msg = JSON.parseObject((String)newMap.get("failure"), String.class);
		System.out.println(msg);
		
	}
}
