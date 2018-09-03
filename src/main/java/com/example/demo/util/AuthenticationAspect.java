package com.example.demo.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.exception.AuthenticationException;
import com.example.demo.repository.AuthenticationRepository;

@Aspect
@Component
public class AuthenticationAspect {

	AuthenticationRepository authenticationRepository;
	AuthenticationException authenticationException;

	public AuthenticationAspect(AuthenticationRepository authenticationRepository) {
		super();
		this.authenticationRepository = authenticationRepository;
	}

	@Around("execution(* com.example.demo.controller.*.*(..)) && args(token,..) && !execution(* com.example.demo.controller.AuthenticationController.loginAuthentication(..))")
	public Object methodException(ProceedingJoinPoint joinPoint, String token) throws Throwable {

		if (authenticationRepository.findByToken(token) == null) {
			throw new AuthenticationException("Error! Token not Found!");
		}

		return joinPoint.proceed();
	}
}
