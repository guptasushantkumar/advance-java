package com.app.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TableTag extends SimpleTagSupport {

	private List<String> tableHeaders;

	private List<MovieSchedule> tableValues;

	public List<String> getTableHeaders() {
		return tableHeaders;
	}

	public void setTableHeaders(List<String> tableHeaders) {
		this.tableHeaders = tableHeaders;
	}

	public List<MovieSchedule> getTableValues() {
		return tableValues;
	}

	public void setTableValues(List<MovieSchedule> tableValues) {
		this.tableValues = tableValues;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		
		JspWriter out = this.getJspContext().getOut();
		//initValues();

		out.println("<table border=\"1\">");
		out.println("<tr>");
		for (String header : tableHeaders) {
			out.println("<th>" + header + "</th>");
		}
		out.println("</tr>");
		for (MovieSchedule ms : tableValues) {
			out.println("<tr>");
			out.println("<td>" + ms.getMovieName() + "</th>");
			out.println("<td>" + ms.getShowTimes() + "</th>");
			out.println("</tr>");
		}
		out.println("<table>");

	}

	private void initValues() {
		tableHeaders = new ArrayList<>();
		tableHeaders.add("Movie Name");
		tableHeaders.add("Show Time");

		tableValues = new ArrayList<>();
		tableValues.add(new MovieSchedule("Children of Heaven",
				"9:00, 11:30, 15:00, 17:30"));
		tableValues.add(new MovieSchedule("Erin Brokovich",
				"10:00, 12:30, 14:30, 16:30"));
		tableValues.add(new MovieSchedule("Naayagan",
				"9:30, 13:00, 17:00, 20:30"));
		tableValues
				.add(new MovieSchedule("Babel", "9:00, 11:30, 15:00, 17:30"));
		tableValues.add(new MovieSchedule("Jaane Bhi Do Yaaron",
				"9:30, 13:00, 17:00, 20:30"));
	}

}
