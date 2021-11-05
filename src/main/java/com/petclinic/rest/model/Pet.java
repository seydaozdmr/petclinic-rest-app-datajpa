package com.petclinic.rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;


    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name = "birth_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet",orphanRemoval = true)
    private Set<Visit> visits=new HashSet<>();

    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate localDate, Set<Visit> visits) {
        this.id = id;
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.localDate = localDate;
        if(visits!=null){
            this.visits=visits;
        }
    }

    public Pet() {
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

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

//    @JsonBackReference
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    //public Set<Visit> getVisits() {
//        return visits;
//    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petType=" + petType +
                ", owner=" + owner +
                ", localDate=" + localDate +
                ", visits=" + visits +
                '}';
    }
}
