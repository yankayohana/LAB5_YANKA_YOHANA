package lab5;

public class Validator {
	
	public static void verificaString(String string, String mensagem) throws Exception {
		if (string == null || string.equals("")) {
			throw new Exception(mensagem);
		}
		
	}
	
	public static void verificaCPF(String string, String mensagem) throws Exception {
		if (string.length() > 11 || string.length() < 11) {
			throw new Exception(mensagem);
		}
	}
	
	
}
