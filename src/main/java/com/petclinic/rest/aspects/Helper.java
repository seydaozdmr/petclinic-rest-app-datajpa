package com.petclinic.rest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Helper {
    @Pointcut("execution(* com.petclinic.rest.service.VisitService.save(..))")
    public void saving(){}

    @Before("saving()")
    public void logBeforeSave(){
        System.out.println("saving visit..");
    }

    @Around("saving()")
    public void allSaving(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("Visit is saving");
            joinPoint.proceed();
            System.out.println("Visit is just saved");
        }catch (Throwable t){
            System.out.println("Visit couldn't saved");
        }
    }

    @Before("within(com.petclinic.rest.service..*)")
    public void applicationStart() {
        System.out.println("your application started");
    }
}
