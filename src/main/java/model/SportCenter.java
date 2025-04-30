package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SportCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String location;

    @OneToMany(mappedBy = "sportCenter")
    public List<Pitch> pitches;
}
