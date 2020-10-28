package com.javaeight.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeAPI {

	public static void main(String[] args) {
		
		LocalDate ldt =LocalDate.now();
		LocalDate firstDay_2021 = LocalDate.of(2021, 1, 1);
		System.out.println(ldt);
		System.out.println(firstDay_2021);
				
		
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(todayKolkata);

	}

}
