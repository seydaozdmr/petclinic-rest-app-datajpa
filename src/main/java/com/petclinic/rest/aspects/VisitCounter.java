package com.petclinic.rest.aspects;

import com.petclinic.rest.dto.VisitDto;
import com.petclinic.rest.model.Visit;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class VisitCounter {
    private Map<VisitDto,Integer> visitCounter=new HashMap<>();

    @Pointcut("execution(* com.petclinic.rest.service.VisitService.save(VisitDto)) && args(visit)")
    public void saving(VisitDto visit){}

    @Before("saving(visit)")
    public void countVisit(VisitDto visit){
        int currentCount=visitCounter.get(visit);
        visitCounter.put(visit,currentCount+1);
    }

    public int getVisitCount(VisitDto visit){
        return visitCounter.containsKey(visit) ? visitCounter.get(visit) : 0;
    }
}
