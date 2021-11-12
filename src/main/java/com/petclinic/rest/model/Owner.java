package com.petclinic.rest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Owner extends Person{
    private String address;
    private String city;
    private String telephone;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner",orphanRemoval = true)
    private List<Pet> pets=new ArrayList<>();

    public Owner(Long id, String name, String lastName, String address, String city, String telephone, List<Pet> pets) {
        super(id, name, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets!=null){
            this.pets=pets;
        }
    }

    public Owner(String address, String city, String telephone, List<Pet> pets) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets!=null){
            this.pets=pets;
        }
    }

    public Owner() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    //@JsonManagedReference
//    public List<Pet> getPets() {
//        return pets;
//    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public boolean addPet(Pet pet){
        return this.pets.add(pet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(address, owner.address) && Objects.equals(city, owner.city) && Objects.equals(telephone, owner.telephone) && Objects.equals(pets, owner.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, telephone, pets);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
