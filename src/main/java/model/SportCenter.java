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

    
    @OneToMany(mappedBy = "sportCenter", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Pitch> pitches;
    
    @OneToMany(mappedBy = "sportCenter", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Bar> bars;
}
