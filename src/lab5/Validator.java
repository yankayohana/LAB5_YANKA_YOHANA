package lab5;

public class Validator {
	
	public static void verificaString(String string, String mensagem) throws Exception {
		if (string == null || string.equals("")) {
			throw new Exception(mensagem);
		}
		
	}
	
}
