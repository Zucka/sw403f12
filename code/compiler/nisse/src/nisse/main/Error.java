package nisse.main;

public class Error {

	static String[][] ErrorList = new String[1000][3];
	static int Slidenr = 0;
	static int Errors = 0;
	
	public static void MakeError(String Type, String Value){
		ErrorList[Errors][0] = Integer.toString(Slidenr);
		ErrorList[Errors][1] = Type;
		ErrorList[Errors][2] = Value;
		Errors++;
	}
	public static void PrintErrors(){
		int i = 0;
		System.out.println("                ERROR LIST               ");
		System.out.println("_________________________________________");
		System.out.println("| Slidenr. :: Type of error ::   Value  |");
		if (Errors == 0){
		System.out.println("|          NO ERRORS WERE FOUND         |");
		System.out.println("|_______________________________________|");
		}
		else {
			while (i<Errors){
				System.out.print("| " + ErrorList[i][0] + " :: ");
				System.out.print(ErrorList[i][1] + " :: ");
				System.out.print(ErrorList[i][2] + " |\n");
				i++;
			}
			System.out.println("|_______________________________________|");
		}

	}
}
