package com.cos.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
	
	public static String youtube(String content) {

		content = "https://www.youtube.com/watch?v=D-c0smnjYjI";
		
		Document doc = Jsoup.parse(content);
		System.out.println(doc);
		Elements pTags = doc.select("a");

		return null;
	}
	
	
	public static String getContentPreview(String content) {

		Document doc = Jsoup.parse(content);
		Elements pTags = doc.select("p");

		for (Element pTag : pTags) {
			String text = pTag.text();
			if (text.length() > 0) {
				if (text.length() < 11) {
					return pTag.text();
					
				} else {
					return pTag.text().substring(0, 10) + "...";
				}
			}
		}
		return "내용 없음...";
	}
}
