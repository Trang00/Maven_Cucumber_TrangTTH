package stepDefinitions;

import java.util.Random;

public class ShareContextData {
	public static String LOGIN_PAGE_URL, USER_ID, PASSWORD, CUSTOMER_ID, ACCOUNT_ID;
	public static String EMAIL_ShareContext=+randomNumber()+"@gmail.com";
	public static int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999);
		return number;
	}
}
