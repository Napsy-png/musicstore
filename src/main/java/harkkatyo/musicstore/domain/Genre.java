package harkkatyo.musicstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import harkkatyo.musicstore.domain.LP;


@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="genre")
	private List<LP> LPs;
	
	public Genre() {
		super();
		
	}
	public Genre(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setLPs(List<LP> LPs){
		this.LPs = LPs;
	}

}
