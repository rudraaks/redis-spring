package com.rudra.aks.converter;

import org.springframework.core.convert.converter.Converter;

import com.rudra.aks.bo.UserBO;

public class UserBOConverter implements Converter<Object, String> {

	@Override
	public String convert(Object arg0) {
		UserBO user = (UserBO)arg0;
		return user.toString();
	}

}
