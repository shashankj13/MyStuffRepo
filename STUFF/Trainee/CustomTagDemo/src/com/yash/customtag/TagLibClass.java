package com.yash.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagLibClass extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String type;
	private String name ;
	private String value ;

	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public void setName(String name) {
		this.name = name;
	}



	


	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();
			
			out.println("<input type= "+type+" "+"name="+name+" "+"value="+ value+">");
			
			
		} catch (Exception ioException) {
			System.err.println("IO Exception");
			System.err.println("ioException.toString()");
		}
		return SKIP_BODY;
	}

}
