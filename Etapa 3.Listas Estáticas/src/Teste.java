import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Lê uma expressão matemática
        System.out.println("Digite uma expressão matemática. EX: (A + B)");
        String expressao = input.nextLine();

        char [] arrayExp = new char[expressao.length()];

        //armazena cada caractere da expressão num array
        for(int i=0; i < arrayExp.length; i++) {
            arrayExp[i] = expressao.charAt(i);
        }
        
        //Define a pilha de acordo com o tamanho da expressão 
        Stack<Character> pilha = new StaticStack<>(expressao.length());

        for(int i = arrayExp.length-1; i >= 0; i--) {
            pilha.push(arrayExp[i]); //trasfere cada elemento do array para a pilha
        }

        System.out.println();
        System.out.println("Pilha da expressão: ");
        System.out.println();
        
        //imprime a pilha
        System.out.print(pilha.toString());
        System.out.println();
        

        //instância um objeto para utilizar o método
        Etapa3 e3 = new Etapa3();
        System.out.print(e3.checkBrackets(pilha));
        
    }
}
