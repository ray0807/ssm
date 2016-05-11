/**
 * Project Name:jrx
 * File Name:BlueMobiConstants.java
 * Package Name:cn.bluemobi.jrx.core.util
 * Date:2015�?7�?13日上�?10:25:41
 * Copyright (c) 2015, bluemobi.cn All Rights Reserved.
 *
*/
package com.balloon.constant;

import javax.servlet.http.HttpServletRequest;

import com.balloon.utils.PropertiesUtils;

/**
 * Description: <br/>
 * Date: 2015�?7�?13�? 上午10:25:41 <br/>
 * 
 * @author hut
 * @version
 * @see
 */
public class Constants {

	public final static int FAIL = 1;// 失败

	public final static int SUCCESS = 0;// 成功

	// private static final HashMap<String, String> sqlMap = new HashMap<String,
	// String>();

	static {

		SITE_NAME = PropertiesUtils.getProperty("SITE_NAME");
		THEME = PropertiesUtils.getProperty("THEME");
		IMG_CONTEXT_PATH = PropertiesUtils.getProperty("IMG_CONTEXT_PATH");
		IMG_REAL_PATH = PropertiesUtils.getProperty("IMG_REAL_PATH");
		// 初始化查询语�?
		// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// Document document;
		// try {
		// URL url = BlueMobiConstants.class.getResource("/mapper");
		// File file = new File(url.getFile());
		// File[] xmls = file.listFiles();
		// for (File xml : xmls) {
		// DocumentBuilder db = dbf.newDocumentBuilder();
		// document = db.parse(new FileInputStream(xml));
		// Element root = document.getDocumentElement();
		// NodeList sqls = root.getElementsByTagName("sql");
		// for (int i = 0; i < sqls.getLength(); i++) {
		// Element ele = (Element) sqls.item(i);
		// sqlMap.put(ele.getAttribute("id"), ele.getTextContent());
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	// 网站�?
	public static final String SITE_NAME;

	// 网站主题风格
	public static final String THEME;

	// 图片服务path
	public static final String IMG_CONTEXT_PATH;

	// 图片实际硬盘地址
	public static final String IMG_REAL_PATH;

	public static final String DEFAULT_AVATAR = "avatar/default.jpg";

	/**
	 * 获取项目在磁盘上面的物理路径
	 */
	public static final String WEB_SITE_ROOT_PATH = Constants.class.getResource("/").getPath().replaceAll("%20", " ")
			.substring(0, Constants.class.getResource("/").getPath().replaceAll("%20", " ").indexOf("WEB-INF"));

	/**
	 * 获取项目在磁盘上面的物理路径
	 */
	public static final String WEB_CLASSPATH = Constants.class.getResource("/").getPath().replaceAll("%20", " ");

	/**
	 * 图片文件格式限制
	 */
	public static final String[] IMAGE_FORMAT_ARRAY = new String[] { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };// 全站中引用的图片格式

	/**
	 * 图片限制大小 文件的极限大小，以字节为单位�?0为不限制�?1MB:1*1024*1024
	 */
	public static final int IMAGE_SIZE_LIMIT = 1 * 1024 * 1024;

	/**
	 * 判断图片格式是否正确
	 * 
	 * @param type
	 * @return
	 */

	// public static String getSql(String id) {
	// return sqlMap.get(id);
	// }

	public static String getImgDomain(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder(request.getScheme());
		sb.append("://").append(request.getServerName()).append(":");
		sb.append(request.getServerPort()).append("/").append(IMG_CONTEXT_PATH).append("/");
		return sb.toString();
	}

	/**
	 * 每个请求都要带authKey
	 */
	public static final String AUTH_KEY = "authKey";
	public static final String AUTH_KEY_TAG = "authkey_tag";
	public static final String AUTH_KEY_TOKEN = "authkey_token_21231313123131";

	public static final Object AUTH_KEY_DEFAULT = "213123131";

	public static final String AUTH_KEY_NOT_CORRECT = "authNotCorrect";
}
