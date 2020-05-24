package harkkatyo.musicstore.domain;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class LP {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, artist;
	private int year;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="genreid")
	Genre genre; 
	
	public LP() {
		super();
	}
	
	
	public LP( String title, String artist, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
	

	}


	public LP(String title, String artist, int year, Genre genre) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.genre = genre;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "LP [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + "]";
	}
}
