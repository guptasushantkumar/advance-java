package com.app.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateOfBirthTag extends SimpleTagSupport {

	private String dayFieldName;

	private String monthFieldName;

	private String yearFieldName;

	private int startingYear;

	private int endingYear;

	private int defaultDay;

	private String defaultMonth;

	private int defaultYear;

	public enum Months {
		January, February, March, April, May, June, July, August, September, October, November, December
	};

	public String getDayFieldName() {
		return dayFieldName;
	}

	public void setDayFieldName(String dayFieldName) {
		this.dayFieldName = dayFieldName;
	}

	public String getMonthFieldName() {
		return monthFieldName;
	}

	public void setMonthFieldName(String monthFieldName) {
		this.monthFieldName = monthFieldName;
	}

	public String getYearFieldName() {
		return yearFieldName;
	}

	public void setYearFieldName(String yearFieldName) {
		this.yearFieldName = yearFieldName;
	}

	public int getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(int startingYear) {
		this.startingYear = startingYear;
	}

	public int getEndingYear() {
		return endingYear;
	}

	public void setEndingYear(int endingYear) {
		this.endingYear = endingYear;
	}

	public int getDefaultDay() {
		return defaultDay;
	}

	public void setDefaultDay(int defaultDay) {
		this.defaultDay = defaultDay;
	}

	public String getDefaultMonth() {
		return defaultMonth;
	}

	public void setDefaultMonth(String defaultMonth) {
		this.defaultMonth = defaultMonth;
	}

	public int getDefaultYear() {
		return defaultYear;
	}

	public void setDefaultYear(int defaultYear) {
		this.defaultYear = defaultYear;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = this.getJspContext().getOut();
		out.println("<select name=\"" + getDayFieldName() + "\">");
		for (int day = 1; day <= 31; day++) {
			out.println("<option>");
			out.println(day);
			out.println("</option>");
		}
		out.println("</select>");

		out.println("<select name=\"" + getMonthFieldName() + "\">");
		for (Months month : Months.values()) {
			out.println("<option value=\"" + (month.ordinal() + 1) + "\">");
			out.println(month);
			out.println("</option>");
		}
		out.println("</select>");
		
		out.println("<select name=\"" + getYearFieldName() + "\">");
		for (int year = getStartingYear(); year<= getEndingYear(); year++) {
			out.println("<option>");
			out.println(year);
			out.println("</option>");
		}
		out.println("</select>");
	}

}
