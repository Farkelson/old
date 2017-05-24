package assignment9;

import java.util.Comparator;

public class TaskComparator implements Comparator<SystemTask>{

	@Override
	public int compare(SystemTask o1, SystemTask o2) {
		if(o1.getPriorityGroup() > o2.getPriorityGroup()){
			return 1;
		}
		else if(o1.getPriorityGroup() < o2.getPriorityGroup()){
			return -1;
		}
		else {
			if(o1.getPriorityLevel() > o2.getPriorityLevel()){
				return 1;
			}
			else if(o1.getPriorityLevel() < o2.getPriorityLevel()){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
}
