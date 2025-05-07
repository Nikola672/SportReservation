package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pitch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String type;

    @ManyToOne
	@JoinColumn(name = "sportCenter_id", nullable = false)
	private SportCenter sportCenter;

    @OneToMany(mappedBy = "pitch")
    public List<Reservation> reservations;
}
