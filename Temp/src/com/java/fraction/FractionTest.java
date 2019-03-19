package com.java.fraction;

public class FractionTest {
	public static void main(String[] args) {
		String optionValue	= "3'' x 3'' x 1 1/4''";
		//String optionValue	= "3'' x 3''";
		//String optionValue	= "3''";
		OneDLXCustomOptions custOption = new OneDLXCustomOptions();
		
		custOption.setGroupType("12");
		custOption.setId("20");
		custOption.setOptionName(optionValue);
		custOption.setOptionValue(optionValue);
		
		FractionTest ft = new FractionTest();
		ft.setSizeDetails(optionValue, custOption);
		
		
		/*System.out.println("Group Type            " + custOption.getGroupType());
		System.out.println("Group Id              " + custOption.getId());
		System.out.println("Group Option Name     " + custOption.getOptionName());
		System.out.println("Group Option Value    " + custOption.getOptionValue());
		System.out.println("Group Length          " + custOption.getLength());
		System.out.println("Group Length Fraction " + custOption.getLengthFraction());
		System.out.println("Group Width           " + custOption.getWidth());
		System.out.println("Group Width Fraction  " + custOption.getWidthFraction());
		System.out.println("Group Height          " + custOption.getHeight());
		System.out.println("Group Height Fraction " + custOption.getHeightFraction());*/
		
		
		System.out.println(custOption);
		
	/*	String hightVal = "";
		String widthVal = "";
		String lengthVal = "";
		
		String[] options = optionValue.split("x");
		if(options != null && options.length > 0) {
			
			if(options != null && options.length > 0) {
				lengthVal = options[0];
				String[] lngt = lengthVal.trim().split(" ");
				if(lngt != null && lngt.length > 0) {
					System.out.println("Lenght " + lngt[0]);
				}
				if(lngt != null && lngt.length > 1) {
					System.out.println("Lenght Fraction " + lngt[1] );
				}
			}
			
			
			if(options != null && options.length > 1) {
				widthVal = options[1];
				String[] wdth = widthVal.trim().split(" ");
				if(wdth != null && wdth.length > 0) {
					System.out.println("Width " + wdth[0]);
				}
				
				if(wdth != null && wdth.length > 1) {
					System.out.println("Width Fraction " + wdth[1]);
				}
			}
			
			
			if(options != null && options.length > 2) {
				hightVal = options[2];	
				String[] hgt = hightVal.trim().split(" ");
				if(hgt != null && hgt.length > 0) {
					System.out.println("Heigh " + hgt[0]);
				}
				
				if(hgt != null && hgt.length > 1) {
					System.out.println("Height Fraction " + hgt[1]);
				}
			}
			
			//System.out.println(lengthVal + " " +  widthVal + " " + hightVal);
		}*/
	}
	
	public void setSizeDetails(String pOptionValue, OneDLXCustomOptions pCustOption) {

		if (pOptionValue != null) {
			pOptionValue = pOptionValue.replace("'", "");
			String[] options = pOptionValue.split(STRING_X);
			if (options != null && options.length > 0) {

				if (options != null && options.length > 0) {
					String lengthValue = options[0];
					String[] length = lengthValue.trim().split(EMPTY_SPACE);

					if (length != null && length.length > 0) {
						pCustOption.setLength(length[0]);
					}

					if (length != null && length.length > 1) {
						pCustOption.setLengthFraction(length[1]);
					}
				}

				if (options != null && options.length > 1) {
					String widthValue = options[1];
					String[] width = widthValue.trim().split(EMPTY_SPACE);
					if (width != null && width.length > 0) {
						pCustOption.setWidth(width[0]);
					}

					if (width != null && width.length > 1) {
						pCustOption.setWidthFraction(width[1]);
					}
				}

				if (options != null && options.length > 2) {
					String hightValue = options[2];
					String[] height = hightValue.trim().split(EMPTY_SPACE);

					if (height != null && height.length > 0) {
						pCustOption.setHeight(height[0]);
					}

					if (height != null && height.length > 1) {
						pCustOption.setHeightFraction(height[1]);
					}
				}
			}
		}
	}
	
	/** The property STRING_X */
	public static final String STRING_X = "x"; 
	
	/** The property EMPTY_SPACE */
	public static final String EMPTY_SPACE = " ";
	
	/** The property SINGLE_QUOTE */
	public static final String SINGLE_QUOTE = "'";
}
