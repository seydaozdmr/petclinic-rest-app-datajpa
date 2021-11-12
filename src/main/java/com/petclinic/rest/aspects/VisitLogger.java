package com.petclinic.rest.aspects;

import com.petclinic.rest.logging.MyLogging;
import com.petclinic.rest.logging.MyLoggingImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class VisitLogger {
    @DeclareParents(value = "com.petclinic.rest.dto.VisitDto+",defaultImpl = MyLoggingImpl.class)
    public static MyLogging myLogging;
}
