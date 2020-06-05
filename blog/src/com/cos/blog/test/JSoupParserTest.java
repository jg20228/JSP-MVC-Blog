package com.cos.blog.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;



public class JSoupParserTest {

	@Test
	public void html파서() {
		String content = "<p>fdsafdsa</p>";
		Document doc = Jsoup.parse(content);
		
		System.out.println(doc.toString());
	
	}
}
