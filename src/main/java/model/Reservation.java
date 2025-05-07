package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public LocalDateTime startTime;
    @Column(nullable = false)
    public LocalDateTime endTime;

    @ManyToOne
	@JoinColumn(name = "pitch_id", nullable = false)
	private Pitch pitch;

    @ManyToMany
    @JoinTable(name = "reservation_user",
        joinColumns = @JoinColumn(name = "reservation_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> users;
}
