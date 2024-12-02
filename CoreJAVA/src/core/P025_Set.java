package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P025_Set {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(12);
		set.add('a');
		set.add("java");
		set.add(234534);
		set.add(false);
		set.add(34.34);
		set.add(12);
		System.out.println(set);
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
