package com.yash.currencyconvertor.bean;

import javax.ejb.Local;

@Local
public interface CurrencyConvertorBeanLocal {
	
	public double convert(double value_Rs_$);

}
