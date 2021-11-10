package com.petclinic.rest.dto;

import java.time.LocalDate;
import java.util.Objects;

public class VisitDto implements BaseDto{
    public Long id;
    public LocalDate date;
    public String description;
    public PetDto pet;

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
        VisitDto visitDto = (VisitDto) o;
        return Objects.equals(id, visitDto.id) && Objects.equals(date, visitDto.date) && Objects.equals(description, visitDto.description) && Objects.equals(pet, visitDto.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, pet);
    }
}
