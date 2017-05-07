package com.devwed.cd1025scraper.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "song")
public class Song {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
	private String artist;
	private String song;
	@Temporal(TemporalType.TIMESTAMP)
	@Id
	private Date datetime;
	
	public Song () {}
	
	public Song (String artist, String song, Date datetime) {
		this.artist = artist;
		this.song = song;
		this.datetime = datetime;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
