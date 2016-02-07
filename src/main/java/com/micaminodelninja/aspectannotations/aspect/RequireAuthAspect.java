package com.micaminodelninja.aspectannotations.aspect;

import com.micaminodelninja.aspectannotations.exceptions.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Daniel on 06-02-2016.
 */
@Aspect
@Component
public class RequireAuthAspect {

    @Autowired
    HttpServletRequest request;

    @Around("@annotation(com.micaminodelninja.aspectannotations.aspect.annotations.RequireAuth)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        String authValue = request.getHeader("Auth");

        if(authValue==null || !"kiwi".equals(authValue)){
            throw new UnauthorizedException();
        }

        return pjp.proceed();

    }

}
