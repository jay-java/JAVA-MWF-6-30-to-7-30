package core;

abstract class RBI{
	abstract public void SA();
	abstract public void HL();
	abstract public void PL();
	public static void repoRate() {
		System.out.println("+-4%");
	}
}
class SBI extends RBI{

	@Override
	public void SA() {
		// TODO Auto-generated method stub
		System.out.println(" SBI SA : 6%");
	}

	@Override
	public void HL() {
		// TODO Auto-generated method stub
		System.out.println("SBI HL : 7%");
	}

	@Override
	public void PL() {
		// TODO Auto-generated method stub
		System.out.println("SBI PL : 8%");
	}
	
}
class JAVA extends RBI{

	@Override
	public void SA() {
		// TODO Auto-generated method stub
		System.out.println(" JAVA SA : 7%");
	}

	@Override
	public void HL() {
		// TODO Auto-generated method stub
		System.out.println("JAVA HL : 8%");
	}

	@Override
	public void PL() {
		// TODO Auto-generated method stub
		System.out.println("JAVA PL : 9%");
	}
	
}
public class P013_Abstraction {
	public static void main(String[] args) {
		JAVA j = new JAVA();
		j.HL();
		j.SA();
		j.PL();
		JAVA.repoRate();
		SBI s = new SBI();
		s.SA();
		s.HL();
		s.PL();
		SBI.repoRate();
		
	}
}