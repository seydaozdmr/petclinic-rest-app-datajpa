package com.petclinic.rest.service.map;

import java.util.*;

public abstract class AbstractMapServiceWithAdaptor<T extends Object,ID extends Long> {
    MapServiceAdaptor<T,ID> adaptor;
    protected Map<Long,T> myDataSource=new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(myDataSource.values());
    }

    T findById(ID id){
        return myDataSource.get(id);
    }

    T save(T elem){
        if(elem!=null){
            if(adaptor.findId(elem)==null){
                elem=adaptor.setId(elem,getNextId());
            }
            myDataSource.put(adaptor.findId(elem),elem);
        }else {
            throw new RuntimeException("Object cannot be null");
        }
        return elem;
    }

    void deleteById(Long id){
        myDataSource.remove(id);
    }

    void delete(T elem){
        myDataSource.entrySet().removeIf(longTEntry -> longTEntry.getValue().equals(elem));
    }


    private Long getNextId(){
        Long nextId=null;

        try{
            nextId= Collections.max(myDataSource.keySet()) + 1 ;
        }catch (NoSuchElementException e){
            nextId=1L;
        }
        return nextId;
    }

}
