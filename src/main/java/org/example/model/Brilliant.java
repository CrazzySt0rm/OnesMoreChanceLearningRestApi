package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "brilliant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brilliant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String weight;

    @ManyToOne(fetch = FetchType.EAGER)
    public Cat cat;

}
