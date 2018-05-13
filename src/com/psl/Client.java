
/* 
   You can use System.out.println for debugging purposes, e.g.
   System.out.println("this is a debug message");
*/

package com.psl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {

	public static int findRemCust(int saletime, int cust, int[] custArr){
		int allotedPersons=0;
		int validPerson=0;
		boolean IsFirstPerson=true;
		int indexOfNegativePerson=0;
		int finalSaleTime=saletime;
		
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
			System.out.println("For person with arrival time : "+arrTime);
			if(arrTime<0) {
				System.out.println("Invalid arrival time encountered ! Exiting");
				break;
			}
			if( arrTime > finalSaleTime || (arrTime + 3) > finalSaleTime) {
				System.out.println("Saletime over");
				break;
			}	
			if(IsFirstPerson){
				System.out.println("First person arrived");
				saletime -= (arrTime + 3);
				allotedPersons++;
				IsFirstPerson=false;
				System.out.println("Saletime : "+saletime+" & alloted Persons : "+allotedPersons);
				continue;
			}
			saletime -= 3;
			allotedPersons++;
			System.out.println("Saletime : "+saletime+" & alloted Persons : "+allotedPersons);
		}
		
		return (validPerson!=0 && (validPerson<allotedPersons)) ? validPerson - allotedPersons : 0;
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



