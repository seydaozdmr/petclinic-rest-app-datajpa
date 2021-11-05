package com.petclinic.rest.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vet_specialities",joinColumns = @JoinColumn(name="vet_id"),inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities=new HashSet<>();

    public Vet(Long id, String name, String lastName, Set<Speciality> specialities) {
        super(id, name, lastName);
        if(specialities!=null){
            this.specialities = specialities;
        }

    }

    public Vet(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Vet() {
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public void addSpeciality(Speciality speciality){
        this.specialities.add(speciality);
    }
}
