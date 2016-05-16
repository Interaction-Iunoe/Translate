package edu.ut.inlab.service.impl;

import edu.ut.inlab.common.util.HttpRequestUtil;
import edu.ut.inlab.service.TranslateManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TranslateManagerImpl implements TranslateManager {
	
	private String key;

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String translate(String query, String source, String target) {
		query=HttpRequestUtil.urlEncode(query, "UTF-8");
		String url="https://www.googleapis.com/language/translate/v2?key="+key+"&q="+query+"&source="+source+"&target="+target;
		JSONObject result=JSONObject.fromObject(HttpRequestUtil.httpRequest(url));
		JSONObject data=JSONObject.fromObject(result.get("data"));
		JSONArray translations=JSONArray.fromObject(data.get("translations"));
		JSONObject translation=JSONObject.fromObject(translations.get(0));
		return translation.getString("translatedText");
	}

}
