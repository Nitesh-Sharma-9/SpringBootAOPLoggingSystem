package com.decimal.aop.aspect;

import static com.decimal.logger.LogManager.GENERAL_LOGGER;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.decimal.model.Account;

@Aspect
@Component
public class AccountServiceAspect {

	@Before(value = "execution(* com.decimal.service.impl.AccountServiceImpl.addAccount(..)) && args(account,..)&& @annotation(auditable) ")
	public void beforeAdvice(JoinPoint joinPoint,Account account,Auditable auditable){
		System.out.println("Before method:"+joinPoint.getSignature());
		System.out.println("Audit destination:"+ auditable.value());
		String message="Account Holder Name : "+account.getAccountHolderName()+" is apply to create the account";
		GENERAL_LOGGER.info(message);
	}

	@After(value = "execution(* com.decimal.service.impl.AccountServiceImpl.addAccount(..)) && args(account,..)&& @annotation(auditable) ")
	public void afterAdvice(JoinPoint joinPoint,Account account,Auditable auditable){
		System.out.println("After method:"+joinPoint.getSignature());
		System.out.println("Audit destination:"+auditable.value());
		String message="Account created for ->"+" Account Number:"+account.getAccountNumber() + " Account Holder Name : "+account.getAccountHolderName();
		GENERAL_LOGGER.info(message);
	}

}
