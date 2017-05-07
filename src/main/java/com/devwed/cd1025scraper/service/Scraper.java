package com.devwed.cd1025scraper.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.devwed.cd1025scraper.model.Song;
import com.devwed.cd1025scraper.repository.SongDAO;
import com.devwed.cd1025scraper.util.DOMFetcher;

public class Scraper {
	
	public void scrapeSongs(int index) {
		
		SongDAO songDAO = new SongDAO();
		DOMFetcher domFetcher = new DOMFetcher();
		Document doc = domFetcher.fetch(index);
		Elements elements = doc.getElementById("content-main").getElementsByTag("tr");
		
		for (Element element : elements) {
			if(element != elements.get(0)){
				Elements song = element.children();
				String artist = song.get(1).text();
				String title = song.get(2).text();
				String datetimeString = song.get(3).text();	
				DateFormat format = new SimpleDateFormat("hh:mma MM/d/yyyy", Locale.ENGLISH);
				Date datetime = null;
				try {
					datetime = format.parse(datetimeString);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				System.out.println(artist);
				System.out.println(title);
				System.out.println(datetimeString);
				System.out.println(datetime);
				System.out.println("\n");
				
				Song songModel = new Song(artist, title, datetime);
				songDAO.addSong(songModel);
			}
			
		}
		
	}

}
