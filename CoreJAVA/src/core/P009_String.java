package core;
//immutable()
public class P009_String {
	public static void main(String[] args) {
		char c[] = { 'J', 'A', 'V', 'A' };
		System.out.println(c);
		String c1 = "java31245#$^%^^{}:";
		System.out.println(c1);
		String s1 = "java is best tech to learn";
		String s2 = "tech";
		System.out.println(s1.concat(s2));
		System.out.println(s1);
//		append -> StringBuffer & StringBuilder
		System.out.println(s1.length());
		System.out.println(s1.charAt(1));
		System.out.println(s1.contains("is besttech"));
		String s3 = "java";
		String s4 = "JAVA";
		System.out.println(s3.compareTo(s4));
		System.out.println(s3.compareToIgnoreCase(s4));
		System.out.println(s3.equals(s4));
		System.out.println(s3.equalsIgnoreCase(s4));
		String ss = "  ";
		System.out.println(ss.isBlank());
		System.out.println(ss.isEmpty());
	}
	
}
