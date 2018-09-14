import java.util.LinkedList;
import java.util.Queue;

/*
 * I/O data
int cacheSize = 3;
String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", 
					"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
Returns : 50

int cacheSize = 3;
String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",
 					"Seoul", "Jeju", "Pangyo", "Seoul"};
Returns : 21

int cacheSize = 2;
String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
 					"SanFrancisco", "Seoul", "Rome", "Paris", 
 					"Jeju", "NewYork", "Rome"};
Returns : 60

int cacheSize = 5;
String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
 					"SanFrancisco", "Seoul", "Rome", "Paris", 
 					"Jeju", "NewYork", "Rome"};
Returns : 52

int cacheSize = 2;
String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
Returns : 16

int cacheSize = 0;
String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
Returns : 25


 */

public class Cache {

	void cache(int cacheSize, String[] cities) {
		int running_time = 0;
		Queue<String> list = new LinkedList<String>();
		String[] casted_cities = new String[cities.length];

		// 대소문자 구분이 없으므로 모두 소문자로 바꿈.
		for(int i=0;i<casted_cities.length;i++) {
			for(int j=0;j<cities[i].length();j++) {
				if(cities[i].charAt(j)<='Z'&&cities[i].charAt(j)>='A')
					casted_cities[i] += (char)(cities[i].charAt(j)+('a'-'A'));
				else
					casted_cities[i] += cities[i].charAt(j);
			}
		}

		for(int i=0;i<casted_cities.length;i++) {
			if(!list.contains(casted_cities[i])) {
				if(list.size()==cacheSize) {
					list.poll();
					list.add(casted_cities[i]);
				}else {
					list.add(casted_cities[i]);
				}
				running_time+=5;
			}else {
				list.remove(casted_cities[i]);
				list.add(casted_cities[i]);
				running_time++;
			}
		}
		
		System.out.println(running_time);
	}

	public static void main(String[] args) {
		int cacheSize = 5;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA",
		 					"SanFrancisco", "Seoul", "Rome", "Paris", 
		 					"Jeju", "NewYork", "Rome"};
		new Cache().cache(cacheSize, cities);
	}

}
