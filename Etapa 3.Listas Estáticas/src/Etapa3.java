public class Etapa3{
    
    //verifica se uma expressão matemática contém os parenteses agrupados de forma correta
    
    //1º se o número de parenteses à esquerda e a direita é igual
    //2º se todo parentese aberto é seguido por um parentese fechado

    public boolean checkBrackets (Stack<Character> s1) throws UnderflowException{
        if(s1.isEmpty()) throw new UnderflowException();

        char [] elements = new char[s1.numElements()];

        char p1 = '(';
        int contp1 = 0;

        char p2 = ')';
        int contp2 = 0;

        int bot = s1.numElements()-1;

        //verifica se o primeiro elemento é um parentese fechado.
        if(s1.top() == p1) {
            contp1++; //contabiliza um parentese

            for(int i=0; i < elements.length; i++) {
                elements[i] = s1.pop(); //passa os elementos da pilha para um array. Fiz isso para verificar os parenteses na expressão. 
                if(elements[i] == p1) //contabiliza todos os parenteses na expressão
                    contp1++;
                if(elements[i] == p2)
                    contp2++;
            }

            if(elements[bot] == p2) {//verifica se a pilha é encerrada por um parentese fechado, satisfazendo a 2º regra.
                contp2++; 
                if(contp1 == contp2) {//verifica se a quantidade de parenteses é a mesma satisfazendo a 1º regra 
                return true;
                } 
            } 
        } 
        return false;
    }
}

    