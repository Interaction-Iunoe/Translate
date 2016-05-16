package edu.ut.inlab.service;

public interface TranslateManager {
	
	/**
	 * 翻译
	 * @param query 查询语句
	 * @param source 源语言
	 * @param target 目标语言
	 * @return
	 */
	String translate(String query, String source, String target);

}
