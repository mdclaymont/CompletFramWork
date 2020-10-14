package Guru;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Tf {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
	      DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
	      switch (day) {
	         case SATURDAY:
	            System.out.println("Weekend - Saturday");
	         case SUNDAY:
	            System.out.println("Weekend - Sunday");
	         default:
	            System.out.println("Not a Weekend");
	      }
	}	
	
	
	
}