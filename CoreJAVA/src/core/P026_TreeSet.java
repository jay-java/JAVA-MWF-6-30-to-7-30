package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class P026_TreeSet {
	public static void main(String[] args) {
		Set set = new TreeSet();
		set.add(12);
		set.add(234);
		set.add(34654);
		set.add(-234534);
		set.add(-987);
		set.add(3441);
		set.add(0);
		System.out.println(set);
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
