package com.yash.currencyconvertor.bean;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class CurrencyConvertorBean
 */
@Stateless
public class CurrencyConvertorBean implements CurrencyConvertorBeanLocal {

    /**
     * Default constructor. 
     */
    public CurrencyConvertorBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public double convert(double val) {
		System.out.println("IN LOCAL " +val);
		val = val / 64 ;
		return val;
		
	}

}
