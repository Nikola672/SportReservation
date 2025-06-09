package model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class SportCenter extends PanacheEntity {
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SportCenter(String name) {
		super();
		this.name = name;
	}

	public SportCenter() {
		super();
	}

	@Override
	public String toString() {
		return "SportCenter [name=" + name + "]";
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sc_id")
	private Set<Pitch> pitches;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sc_id")
	private Set<Bar> bars;
}
