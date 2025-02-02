package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//<generics>
public class P022_List {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(12);
		list.add("java");
		list.add('c');
		list.add(false);
		list.add(34.34);
		list.add(null);
		list.add(12);
		list.add(3454334);
		System.out.println(list);
		list.add(34654);
		System.out.println(list);
		list.remove(5);
		System.out.println(list);
		list.add(0, "java tech");
		System.out.println(list);
		Iterator itr= list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
