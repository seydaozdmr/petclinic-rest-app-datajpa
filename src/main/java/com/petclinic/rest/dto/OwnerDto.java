package com.petclinic.rest.dto;


import com.petclinic.rest.model.Pet;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class OwnerDto extends PersonDto implements BaseDto {

    @NotBlank(message = "adres boş")
    public String address;
    @NotEmpty
    public String city;
    @NotNull
    public String telephone;
    public List<Pet> pets;

    public OwnerDto() {
    }

    public OwnerDto(String address, String city, String telephone, List<Pet> pets) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public OwnerDto(Long id, String name, String lastName, String address, String city, String telephone, List<Pet> pets) {
        super(id, name, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public OwnerDto(String name, String lastName, String address, String city, String telephone, List<Pet> pets) {
        super(name, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDto ownerDto = (OwnerDto) o;
        return Objects.equals(address, ownerDto.address) && Objects.equals(city, ownerDto.city) && Objects.equals(telephone, ownerDto.telephone) && Objects.equals(pets, ownerDto.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, telephone, pets);
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pets=" + pets +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
