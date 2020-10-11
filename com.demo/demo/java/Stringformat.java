package demo.java;

public class Stringformat {

		public static void main (String[] arg) {
			String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
			String DYNAMIC_HEADER_FOOTER_LINK = "//div[@class='%s']//a[text()='%s']";
			String DYNAMIC_COUNTRY_TEXT = "//td[text()='%s']//following-sibling::td[@data-key='total']";
			String DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL = "//td[@data-key='females' and text()='%s']/following-sibling::td"
					+ "[@data-key='country' and text()='%s']/following-sibling::td"
					+ "[@data-key='males' and text()='%s']/following-sibling::td"
					+ "[@data-key='total' and text()='%s']";
			
			clickToFooterLink(DYNAMIC_FOOTER_LINK, "Search");
			clickToFooterLink(DYNAMIC_FOOTER_LINK, "Blog");
			clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "header", "Computers");
			clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "header", "Electronics");
			clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "footer", "Recently viewed products");
			clickToFooterLink(DYNAMIC_COUNTRY_TEXT, "Afghanistan");
			
			clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "12253515", "AFRICA", "12599691", "24853148");

		}
		
//		public static void clickToFooterLink(String locator, String pageName) {
//			locator = String.format(locator, pageName);
//			System.out.println("Click with 1 param" + locator);
//
//		}
//		
//		public static void clickToFooterLink(String locator, String headerOrFooter,String pageName) {
//			locator = String.format(locator, headerOrFooter, pageName);
//			System.out.println("Click with 2 param" + locator);
//
//		}
//		
//		public static void clickToFooterLink(String locator, String females, String country, String males, String total) {
//			locator = String.format(locator, females, country, males, total);
//			System.out.println("Click with 4 param" + locator);
//		}
		
		public static void clickToFooterLink(String locator, String...values) {
			locator = String.format(locator, (Object[])values);
			System.out.println("Click with n param: " + locator);
		}
	
		
		
}
