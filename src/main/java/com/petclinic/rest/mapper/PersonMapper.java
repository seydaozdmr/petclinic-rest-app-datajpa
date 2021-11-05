package com.petclinic.rest.mapper;

import com.petclinic.rest.dto.BaseDto;
import com.petclinic.rest.dto.OwnerDto;
import com.petclinic.rest.dto.PersonDto;
import com.petclinic.rest.dto.VetDto;
import com.petclinic.rest.model.Owner;
import com.petclinic.rest.model.Person;
import com.petclinic.rest.model.Vet;
import org.mapstruct.Mapper;

public interface PersonMapper<T extends Person,DTO extends PersonDto> extends BasePageMapper<T, DTO> {
    Person toSource(PersonDto dto);

    PersonDto toDTO(Person source);

    Owner toSource(OwnerDto dto);

    OwnerDto toDTO(Owner source);

    Vet toSource(VetDto dto);

    VetDto toDTO(Vet source);

    default PersonDto toDto(Person person){
        if(person instanceof Owner){
            return this.toDTO((Owner) person);
        }else if (person instanceof Vet)
            return this.toDTO((Vet) person);
        else{
            return this.toDTO(person);
        }
    }

    default Person toSourceMap (PersonDto personDto){
        if(personDto instanceof OwnerDto)
            return this.toSource((OwnerDto) personDto);
        else if(personDto instanceof VetDto)
            return this.toSource((VetDto) personDto);
        else{
            return this.toSource(personDto);
        }

    }

}
