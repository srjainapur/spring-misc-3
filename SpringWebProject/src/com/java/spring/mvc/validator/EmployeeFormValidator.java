package com.java.spring.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java.spring.mvc.bean.Employee;

public class EmployeeFormValidator implements Validator {
	
	// which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "empId", "empId.required");
		
		Employee emp = (Employee) obj;
		if(emp.getEmpId() <=0){
			errors.rejectValue("empId", "negativeValue", new Object[]{"'empId'"}, "empId can't be negative");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
	}
}
