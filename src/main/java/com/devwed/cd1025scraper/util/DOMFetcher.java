package com.devwed.cd1025scraper.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DOMFetcher {
	
	public Document fetch(int index) {
		Document doc = null;
		try {
			doc = Jsoup.connect("http://cd1025.com/about/playlists/now-playing/?start=" + Integer.toString(index)).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
