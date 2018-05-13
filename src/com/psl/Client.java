
/* 
   You can use System.out.println for debugging purposes, e.g.
   System.out.println("this is a debug message");
*/

package com.psl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

	public static int findRemCust(int saletime, int cust, int[] custArr){
		int allotedPersons=0;
		int validPerson=0;
		int indexOfNegativePerson=0;
		int finalSaleTime=saletime;
		int currentTime=0;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<cust;i++){
			if(custArr[i]<0){
				indexOfNegativePerson=i;
				break;
			}
		}
		
		Arrays.sort(custArr);
		
		for(int i=0;i<custArr.length;i++) {
			if(!(custArr[i]<0))
				list.add(custArr[i]);				
		}

		if(indexOfNegativePerson!=0)
			list.add(indexOfNegativePerson, -1);

		System.out.println(list+" SaleTime : "+finalSaleTime);
		
		for(int i: list){
			if(i < 0 || (i > finalSaleTime))
				break;
			validPerson++;
		}
		
		System.out.println("Valid Person in the queue are  : "+validPerson);
		for(int arrTime : list) {
			System.out.println("-------For person arriving at : "+ arrTime+" -------");
			if(arrTime<0){
				System.out.println("Invalid time encountered");
				break;
			}
			if(arrTime < currentTime)
				arrTime = currentTime;
			currentTime = (arrTime + 3);
			if(finalSaleTime==0 || currentTime > finalSaleTime) {
				System.out.println("Sale is over");
				break;
			}
			allotedPersons++;
			System.out.println("Current time : "+currentTime);
			System.out.println("Remaining time : "+(finalSaleTime - currentTime));
		}
		return validPerson - allotedPersons;
	}
	public static void main(String args[])
	{
	    /*
	        You can use Console input as well with the help of Scanner or BufferedReader classes.
		Please provide input data in Input box on right side of window.
	    */
//		int saletime=10, cust=8;       
//		int custArr[]={1, 4, 6, 8, 9, 10, 11, 12};
//		int saletime=60, cust=5;       
//		int custArr[]={10, 30, 60, 50, 40};
//	    int saletime=15, cust=5;       
//	    int custArr[]={7, -1, 10, 11, 12};
	    int saletime=18, cust=5;       
	    int custArr[]={12, 18, -1, 10, 7};
		
	   System.out.println(findRemCust(saletime,cust,custArr));
	}

}



