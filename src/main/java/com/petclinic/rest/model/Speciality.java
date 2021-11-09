package com.petclinic.rest.model;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Speciality implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "specialities")
    private List<Vet> vet=new ArrayList<>();

    public Speciality(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Speciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vet> getVet() {
        return vet;
    }

    public void setVet(List<Vet> vet) {
        this.vet = vet;
    }
}
