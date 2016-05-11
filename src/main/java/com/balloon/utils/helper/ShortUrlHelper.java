package com.balloon.utils.helper;

/**
 * 鐢熸垚鐭綉鍧�骞惰繑鍥�
 * 
 * @author: Jerri
 * @date: 2014骞�3鏈�22鏃ヤ笅鍗�9:58:54
 */
public class ShortUrlHelper {

//	/**
//	 * 鐢熸垚鐭綉鍧�瀛楃涓诧紙宸茬粡鍘婚櫎"http://dwz.cn/"锛�
//	 */
//	public static String createShortUrl(String longUrl) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("url", "http://www.sina.com/"+longUrl);
//		String a = JsonHelper.getJsonObjByPost("http://dwz.cn/create.php", map);
//		a = (JSON.parseObject(a)).getString("tinyurl").replace("http://dwz.cn/", "");
//		return a;
//	}
//	
//
//	/**
//	 * 鐢熸垚鐭綉鍧�瀛楃涓�
//	 */
//	public static String unShortUrl(String shortUrl) {
//		try {
//			JsonHelper.getJsonObjString("http://dwz.cn/"+shortUrl, "UTF-8");
//			return "";
//		} catch (Exception e) {
//			String a = e.toString();
//			return a.substring(a.indexOf("http://www.sina.com/") + 20);
//		}
//	}
}