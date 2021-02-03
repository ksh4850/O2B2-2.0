package mini;

public class Application {
	public static void main(String[] args) {

		MemberDB memberDB = new MemberDB();
		memberDB.loadingDBMethod();
		
		for(Member m : MemberDB.listDB) {
			System.out.println(m);
		}
//		MemberDB.listDB.remove(7);
//		memberDB.informationChang();

		JFrame1 jf1 = new JFrame1();
		
	}



}
