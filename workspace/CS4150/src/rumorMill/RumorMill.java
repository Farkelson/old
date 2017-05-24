package rumorMill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

public class RumorMill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		StringBuilder retString = new StringBuilder();

		// Vertices
		int numStudents = Integer.parseInt(s.nextLine());
		ArrayList<LinkedList<Object>> students = new ArrayList<LinkedList<Object>>();
		HashMap <Object, Integer> studentIndex = new HashMap <Object, Integer>();
		ArrayList<Boolean> toldStudents = new ArrayList<Boolean>();
		for(int i=0; i < numStudents; i++){
			String student = s.nextLine();
			students.add(new LinkedList<Object>());
			studentIndex.put(student, i);
			toldStudents.add(false);
		}

		// Edges
		int numFriendships = Integer.parseInt(s.nextLine());
		for(int i=0; i < numFriendships; i++){
			String[] friendship = s.nextLine().split(" ");
			students.get(studentIndex.get(friendship[0])).add(friendship[1]);
			students.get(studentIndex.get(friendship[1])).add(friendship[0]);
		}

		// Start Breadth-first from this vertex
		int reports = Integer.parseInt(s.nextLine());
		for(int i=0; i < reports; i++){
			String startStudent = s.nextLine();
			retString.append(startStudent);
			ArrayList<Object> nextStudents = new ArrayList<Object>();
			nextStudents.add(startStudent);
			toldStudents.set(studentIndex.get(startStudent), true);
			ArrayList<Object> sortBeforeAdd = new ArrayList<Object>();
			while(nextStudents.size() != 0){
				for(int k = 0; k < nextStudents.size(); k++){
					for(int j=0; j < students.get(studentIndex.get(nextStudents.get(k))).size(); j++){
						Object testStudent = students.get(studentIndex.get(nextStudents.get(k))).get(j);
						if(toldStudents.get(studentIndex.get(testStudent)) == false){
							toldStudents.set(studentIndex.get(testStudent), true);
							sortBeforeAdd.add(testStudent);
							nextStudents.add(testStudent);
						}
					}
					nextStudents.remove(nextStudents.get(k));
					k--;
				}
				Collections.sort(sortBeforeAdd, new Comparator<Object>() {
					public int compare(Object v1, Object v2) {
						return v1.toString().compareTo(v2.toString());
					}
				});
				if(!sortBeforeAdd.isEmpty()){
					String addThis = sortBeforeAdd.toString().replaceAll("\\[", " ").replaceAll(",", "").replaceAll("]", "");
					retString.append(addThis);
				}
				sortBeforeAdd.clear();
			}

			while(toldStudents.contains(false)){
				int indexGet = toldStudents.indexOf(false);
				for(Entry<Object, Integer> testThis: studentIndex.entrySet()){
					if(testThis.getValue() == indexGet){
						sortBeforeAdd.add(testThis.getKey());
						toldStudents.set(indexGet, true);
						break;
					}
				}
			}
			Collections.sort(sortBeforeAdd, new Comparator<Object>() {
				public int compare(Object v1, Object v2) {
					return v1.toString().compareTo(v2.toString());
				}
			});
			String addThis = sortBeforeAdd.toString().replaceAll("\\[", " ").replaceAll(",", "").replaceAll("]", "");
			retString.append(addThis);

			//Print then wipe
			System.out.println(retString);
			retString.delete(0, retString.length());
			for (int j = 0; j < toldStudents.size(); j++) {
				toldStudents.set(j, false);
			}
			nextStudents.clear();
		}
	}
}
