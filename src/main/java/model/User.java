package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(nullable = false)
	public String name;
	@Column(nullable = false)
	public String email;

	@ManyToMany(mappedBy = "users")
	public List<Reservation> reservations;
}