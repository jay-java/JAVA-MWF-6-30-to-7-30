package core;

class Data {
	int i;
	String name;
	double value;

	public Data() {
		System.out.println("default cons in data");
	}

	public Data(int i, String name, double value) {
		this.i = i;
		this.name = name;
		this.value = value;
		System.out.println("Constructor : i  = " + i + " name = " + name + " value = " + value);
	}
	public Data(Data d1) {
		this.i = d1.i;
		this.name= d1.name;
		this.value = d1.value;
	}

	public void call() {
		System.out.println("call in data class");
	}

	public void showdata() {
		System.out.println("function : i  = " + i + " name = " + name + " value = " + value);
	}
}


public class P010_Constructor {
	public static void main(String[] args) {
		Data d = new Data();
		d.call();
		d.i = 12;
		d.name = "java";
		d.value = 3.14;
		System.out.println(d.i);
		System.out.println(d.name);
		System.out.println(d.value);
		Data d1 = new Data(1, "java", 3.14);
		System.out.println("d1 data");
		d1.showdata();

		Data d2  = new Data(d1);
		System.out.println("d2 data");
		d2.showdata();
	}
}
