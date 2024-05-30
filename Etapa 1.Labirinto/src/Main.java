
public class Main {
	
	public static void main (String[] args) {
		
		Labirinto lab = new Labirinto();
		String fileName = "src/molde.txt"; //lê o nome do arquivo
		
		char[][] labirinto = lab.criaLabirinto(fileName);
		
		lab.percorreLabirinto(labirinto);
	
	}
}
