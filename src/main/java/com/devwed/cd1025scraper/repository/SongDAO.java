package com.devwed.cd1025scraper.repository;

import org.hibernate.Session;

import com.devwed.cd1025scraper.model.Song;

public class SongDAO {

    public void addSong(Song song) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    
	    Song tempSong = new Song();
	    tempSong.setArtist(song.getArtist());
	    tempSong.setSong(song.getSong());
	    tempSong.setDatetime(song.getDatetime());
	     
	    //Save the employee in database
	    session.save(song);
        session.getTransaction().commit();
    }
	
}
