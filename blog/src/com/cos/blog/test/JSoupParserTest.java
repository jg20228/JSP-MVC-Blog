package com.cos.blog.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JSoupParserTest {

	@Test
	public void youtube() {

		String content = "<a href https://www.youtube.com/watch?v=D-c0smnjYjI> </a>";
		//String content2 = "https://youtu.be/a9t_TpinIYc";
		Document doc = Jsoup.parse(content);
	
		System.out.println(doc);

		System.out.println("-----------");
		
		Elements els = doc.select("a");
		Element el = els.get(0);
		System.out.println(el);
		
		System.out.println("-----------");
		String value = el.toString();
		
		String[] test = value.split("v=");
		System.out.println(test[1]);
		String[] test2 = test[1].split(">");
		System.out.println(test2[0]);
	}
}
