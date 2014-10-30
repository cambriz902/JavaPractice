package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class SecretSantaGenerator {

	public static HashMap<String,String> matcher(String[] people){
		if(people == null || people.length < 2){
			return null;
		}
		ArrayList<String> peopleList = new ArrayList<String>();
		HashMap<String,String> pairing = new HashMap<String,String>();
		Random ran = new Random();
		int randomPerson;
		String firstPerson;
		String lastPerson = "";
		for( int i = 0; i < people.length; i++){
			peopleList.add(people[i]);
		}
		randomPerson = (int) ran.nextInt(peopleList.size());
		firstPerson = peopleList.get(randomPerson);
		peopleList.remove(randomPerson);
		while(peopleList.size() != 0){
			randomPerson = ran.nextInt(peopleList.size());
			if(pairing.size() == 0){
				pairing.put(firstPerson,peopleList.get(randomPerson));
			} else {
				pairing.put(lastPerson, peopleList.get(randomPerson));
			}
			lastPerson = peopleList.get(randomPerson);
			peopleList.remove(randomPerson);
		}
		pairing.put(lastPerson,firstPerson);
		return pairing;
	}
	
	public static void printHashMap(HashMap<String,String> map){
		if(map == null || map.size() ==0){
			return;
		}
		Iterator<String> keySet = map.keySet().iterator();
		String person;
		while(keySet.hasNext()){
			person = keySet.next();
			System.out.println("Santa = "  + person + " person = " + map.get(person));
		}
	}
}
