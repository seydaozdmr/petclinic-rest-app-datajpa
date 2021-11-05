package com.petclinic.rest.service.map;

import com.petclinic.rest.model.*;

public class MapServiceAdaptor <T extends Object,ID extends Long> {

    public Long findId(T elem){
        if(elem instanceof Person){
            return ((Person) elem).getId();
        }else if(elem instanceof Pet)
            return ((Pet) elem).getId();
        else if(elem instanceof PetType)
            return ((PetType)elem).getId();
        else if(elem instanceof Speciality)
            return ((Speciality)elem).getId();
        else if(elem instanceof Visit)
            return ((Visit)elem).getId();
        return -1L;
    }

    public T setId(T elem,Long id){
        if(elem instanceof Person){
            ((Person) elem).setId(id);
            return elem;
        }else if(elem instanceof Pet){
            ((Pet) elem).setId(id);
            return elem;
        }else if(elem instanceof PetType){
            ((PetType)elem).setId(id);
            return elem;
        }else if(elem instanceof Speciality){
            ((Speciality)elem).setId(id);
            return elem;
        }else if(elem instanceof Visit){
            ((Visit)elem).setId(id);
            return elem;
        }
        return elem;
    }
}
