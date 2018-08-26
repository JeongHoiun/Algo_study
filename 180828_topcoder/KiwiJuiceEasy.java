/* Top Coder p.65 KiwiJuice
 * 
 * I/O data
 * 0) 
 * * capacities = {20, 20}
 * * bottles = {5, 8}
 * * fromId = {0}
 * * toId = {1}
 * # return : {0, 13}
 * 
 * 1)
 * * capacities = {10, 10}
 * * bottles = {5, 8}
 * * fromId = {0}
 * * toId = {1}
 * # return : {3, 10}
 * 
 * 2)
 * * capacities = {30, 20, 10}
 * * bottles = {10, 5, 5}
 * * fromId = {0, 1, 2}
 * * toId = {1, 2, 0}
 * # return : {10, 10, 0}
 * 
 * 3) 
 * * capacities = {14, 35, 86, 58, 25, 62}
 * * bottles = {6, 34, 27, 38, 9, 60}
 * * fromId = {1, 2, 4, 5, 3, 3, 1, 0}
 * * toId = {0, 1, 2, 4, 2, 5, 3, 1}
 * # return : {0, 14, 65, 35, 25, 35}
 * 
 * 4)
 * * capacities = {700000, 800000, 900000, 1000000}
 * * bottles = {478478, 478478, 478478, 478478}
 * * fromId = {2, 3, 2, 0, 1}
 * * toId = {0, 1, 1, 3, 2}
 * # return : {0, 156956, 900000, 856956}
 * 
 */

import java.util.Scanner;

public class KiwiJuiceEasy {
	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for(int i=0;i<fromId.length;i++) {
			if(capacities[toId[i]]<=(bottles[fromId[i]]+bottles[toId[i]])) {
				bottles[fromId[i]] = bottles[fromId[i]]+bottles[toId[i]]-capacities[toId[i]]; 
				// from용량 = (form의 용량+to의 용량) - to의 수용량
				bottles[toId[i]] = capacities[toId[i]];	
					// to 용량 = Max
			}else if(bottles[fromId[i]]<capacities[toId[i]]+bottles[toId[i]]) {
				bottles[toId[i]] += bottles[fromId[i]]; // to용량 = to용량 + from 용량
				bottles[fromId[i]] = 0;	//from 용량 = 0
			}
		}
		return bottles;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 int[] capacities = {700000, 800000, 900000, 1000000};
		 int[] bottles = {478478, 478478, 478478, 478478};
		 int[] fromId = {2, 3, 2, 0, 1};
		 int[] toId = {0, 1, 1, 3, 2};
		 
		 int[] result = new KiwiJuiceEasy().thePouring(capacities, bottles, fromId, toId);
		 
		 for(int i=0;i<result.length;i++) {
			 System.out.print(result[i]+ " ");
		 }
		 System.out.println();
	}

}
