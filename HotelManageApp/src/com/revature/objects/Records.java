package com.revature.objects;

import com.revature.AccountPostgres;
import com.revature.UserNotFound;

public class Records {

	public void record(AccountPostgres acc, String userName) {
		String record="";
		try {
			record = acc.getUserDataByUsername(userName);
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("some of your previous records "+ record);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
