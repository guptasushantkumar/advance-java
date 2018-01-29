package com.util;

public class CalculateNetsal {

	private double netsal;

	public double getNetSal(double basicSal) {
		double da = 0;
		double hra = 0;
		double incTax = 0;
		double grossSal = 0;

		da = getDa(basicSal);
		hra = getHra(basicSal);

		grossSal = basicSal + da + hra;

		incTax = getIncTax(grossSal);

		netsal = grossSal - incTax;
		return netsal;
	}

	private double getDa(double basicSal) {
		
		double da = 0;
		try{
		if (basicSal >= 0 && basicSal <= 10000) {
			da = basicSal * .10;//(10 / 100);
		} else if (basicSal >= 10001 && basicSal <= 25000) {
			da = basicSal * .105;
		} else if (basicSal > 25000) {
			da = basicSal * .1075;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

	private double getHra(double basicSal) {
		double hra = 0;
		if (basicSal >= 0 && basicSal <= 10000) {
			hra = basicSal * .07;
		} else if (basicSal >= 10001 && basicSal <= 25000) {
			hra = basicSal * 0.0675;
		} else if (basicSal > 25000) {
			hra = basicSal * .06;
		}
		return hra;
	}

	private double getIncTax(double grossSal) {
		double incTax = 0;
		if (grossSal >= 0 && grossSal <= 10000) {
			incTax = 0;
		} else if (grossSal >= 10001 && grossSal <= 25000) {
			incTax = grossSal * .08;
		} else if (grossSal > 25000) {
			incTax = grossSal * .09;
		}
		return incTax;
	}

}
