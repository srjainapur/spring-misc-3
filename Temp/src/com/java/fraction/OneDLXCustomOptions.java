package com.java.fraction;

public class OneDLXCustomOptions {

	private String id;
	private String optionValue;
	private String optionName;
	
	private String length;
	private String lengthFraction;
	private String width;
	private String widthFraction;
	private String height;
	private String heightFraction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	private String groupType;
	
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getLengthFraction() {
		return lengthFraction;
	}

	public void setLengthFraction(String lengthFraction) {
		this.lengthFraction = lengthFraction;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getWidthFraction() {
		return widthFraction;
	}

	public void setWidthFraction(String widthFraction) {
		this.widthFraction = widthFraction;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeightFraction() {
		return heightFraction;
	}

	public void setHeightFraction(String heightFraction) {
		this.heightFraction = heightFraction;
	}
	
	@Override
	public String toString() {
		return "Group Type :" + getGroupType() 
			 + "\nId : " + getId() 
			 + "\nOption Name " + getOptionName() 
			 + "\nOption Value : " + getOptionValue() 
			 + "\nLength : " + getLength()
			 + "\nLength Fraction " + getLengthFraction()
			 + "\nWidth : " + getWidth()
			 + "\nGroup Width Fraction : " + getWidthFraction()
			 + "\nGroup Height : " + getHeight()
			 +"\nGroup Height Fraction " + getHeightFraction();
	
	}
}
