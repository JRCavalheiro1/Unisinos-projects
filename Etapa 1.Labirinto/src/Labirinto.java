import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

//Classe Labirinto
public class Labirinto {

	private char[][] labirinto;

	public char[][] criaLabirinto(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			String coluna = br.readLine();
			int qtdLinha = 0;
			
			//conta a quantidade de linhas do arquivo
			while(line != null) { 
				qtdLinha++;
				line = br.readLine();
			}
			
			int qtdColuna = coluna.length(); //armazena a quantidade de colunas de acordo com o tamanho da string lida no arquivo
			System.out.println(qtdLinha);
			
			labirinto = new char[qtdLinha][qtdColuna]; //inicializa o array com o tamanho das linhas e colunas pré-definidas
			
			br.close();
			
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String str = br.readLine();
			
			for(int x = 0; x < labirinto.length; x++) {
				str = br.readLine(); //percorre e lê cada linha do array

				for(int y = 0; y < labirinto[x].length; y++) {
						
					//charAt(y) pega cada caractere da string na posição atual (coluna y) e valida de acordo com o modelo no arquivo
						if(str.charAt(y) == 'E' ) { 
							labirinto[x][y] = 'E'; //cada posição do array recebe o mesmo valor que está no modelo.

						} else if(str.charAt(y) == 'X') {
							labirinto[x][y] = 'X';
							
						} else if(str.charAt(y) == 'D') {
							labirinto[x][y] = 'D';
						} else {
							labirinto[x][y] = ' ';
						}
					
					System.out.print(labirinto[x][y]); //imprime o labirinto
				}
				System.out.println();
			}

		}catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		return labirinto;
	}

	public boolean percorreLabirinto(char[][] labirinto) {
		return verificaLabirinto(labirinto, 0, 0);
	}
	
	private char saida = 'D';
	private boolean verificaLabirinto(char[][] labirinto, int x, int y) {
		
		if(x >= labirinto.length) {
			return false;
		}
		
		if(y >= labirinto[x].length) {	
			return verificaLabirinto(labirinto, x+1, 0);
		}

		if(labirinto[x][y] == saida) {
			System.out.println("O labirinto contém uma Saída!");
			return true;
		} 

		return verificaLabirinto(labirinto, x, y+1);
	}

	
}
