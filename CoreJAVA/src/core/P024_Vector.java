package core;

import java.util.Enumeration;
import java.util.Vector;

public class P024_Vector {
	public static void main(String[] args) {
		Vector vr = new Vector();
		vr.add(12);
		vr.add("java");
		vr.add(234);
		vr.add('c');
		vr.add(false);
		vr.add(34.34);
		System.out.println(vr);
		Enumeration em = vr.elements();
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}
}
