
public class MainClass {

	public static void main(String[] args) {
		
		Frog frog = new MainClass().new Frog();
		
		System.out.println(frog.toString());
		System.out.println(new Object());
		System.out.println(new Object());
		System.out.println(new Object());
		
	}

	class Frog {
		
		@Override
		public String toString() {
			
			return  "bla bla";
		}
		
	}
}
