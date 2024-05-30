import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        
        //Gera um tamanho aleatório de 1 a 100 para o array
        Candidato [] candidatos = new Candidato[(int)(Math.random() * 100 + 1)];
        
        //array que armazena 25 nomes aleatórios;
        String [] nomes = {"Alessandro", "Ana", "Armando", "Aline", "Antonio", 
        "Bernardo", "Bruno", "Bianca", "Barbara", "Beatriz",
        "Carolina", "Carlos", "Carla", "Caio", "Cesar", 
        "Daniela", "Denilson", "Davi", "Douglas", "Danilo", 
        "Evandro", "Everton", "Ellaine", "Eduardo", "Elisa"};

        for(int i=0; i < candidatos.length; i++) {
            
            //Define nomes, partidos e quantidade de intenções de voto aleatórios
            int j = ((int)(Math.random() * 24) + 1);
            String nome = nomes[j];
            
            String partido = "";
            String corpoPartido = "AEPBT";
            for(int y=0; y < 2; y++) {
                partido += corpoPartido.charAt((char)(Math.random() * corpoPartido.length()));
            }

            int intencoesVotos = (int)(Math.random()*1000 + 1);

            //A cada varrida no array, é armazenado um novo candidato com as propriedades geradas
            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }

        System.out.println();
        System.out.println("Candidatos organizados por ordem alfabetica");
        System.out.println();

        //primeiro ordena todo o array por nome em ordem alfabética
        ordenaCandidatosPorNome(candidatos);  
        for(int i=0; i < candidatos.length - 1; i++) {
            int j = i + 1;

            //ordena todos os candidatos do mesmo nome por intenções de voto
            if(candidatos[i].getNome().equals(candidatos[j].getNome())) {
                ordenaCandidatosPorVotos(candidatos);

                //se ouver candidatos com a mesma intenção de voto, esses, serão organizados por partido
                if(candidatos[i].getIntencoesVotos() == candidatos[j].getIntencoesVotos()) {
                    ordenaCandidatosPorPartido(candidatos);
                }
            }
        } 
        //ordena o array por nome novamente para limpar as modificações;
        ordenaCandidatosPorNome(candidatos);

        //imprime todos os candidatos armazenados
        for(int i=0; i < candidatos.length; i++) {
            System.out.println(candidatos[i].toString());
        }

        System.out.println();
        System.out.println();

        Scanner input = new Scanner(System.in);

       String resp;
        do {
            System.out.println("Digite o nome do candidato: ");
            String nomeCandidato = input.nextLine();
            
            //pesquisa o candidato de acordo com o nome informado pelo usuário
            System.out.println(pesquisaBinariaCandidatos(candidatos, nomeCandidato));   
            System.out.println();

            System.out.println("Deseja continuar pesquisando? S - N");
            resp = input.nextLine();  

        }while(resp.equalsIgnoreCase("S")); 
        
        
    }

    public static void ordenaCandidatosPorNome(Candidato [] candidatos) {
        //ordena os candidatos pelo nome em ordem alfabética utilizando inserção direta
        for(int i=1; i < candidatos.length; i++) {
            Candidato B = candidatos[i];
            int j = i - 1;
            while(j >= 0 && candidatos[j].getNome().compareTo(B.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = B;
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato [] candidatos) {
        //ordena os candidatos por votos (do maior para o menor) utilizando seleção direta
        int menor;
        for(int i=0; i < candidatos.length; i++) {
            menor = i;
                for(int j = i+1; j < candidatos.length; j++) {
                    if(candidatos[j].getIntencoesVotos() > candidatos[menor].getIntencoesVotos()) {
                        menor = j;
                    }
                }
                Candidato aux = candidatos[menor];
                candidatos[menor] = candidatos[i];
                candidatos[i] = aux; 
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato [] candidatos) {
        //ordena os candidatos por partido utilizando seleção direta, a ordenação ocorre por ordem alfabética
        int min = 0;
        for(int i=0; i < candidatos.length; i++ ) {
            min = i;
            for(int j = i + 1; j < candidatos.length; j++) {
                String B = candidatos[j].getPartido();
                if(candidatos[min].getNome().compareTo(B) < 0) {
                    min = j;
                }
                Candidato T = candidatos[i];
                candidatos[i] = candidatos[min];
                candidatos[min] = T;
            }
        }
    }

    public static String pesquisaBinariaCandidatos(Candidato [] candidatos, String arg) {
        //pesquisa o candidato de acordo com o nome (arg) que é recebido por parâmetro;

        //ao invés de rotornar um inteiro direto, o array retorna uma string contendo os dados do candidato e a posição dele
        //ou se não for encontrado, emite uma mensagem dizendo que o candidato não foi encontrado
        int inf = 0;
        int max = candidatos.length - 1;

        while(inf <= max) {
            int med = (inf + max) / 2;
            if(candidatos[med].getNome().equalsIgnoreCase(arg)) {
                
               return "Posição: " + med + " - " + candidatos[med].toString();
            } 
            else if(candidatos[med].getNome().compareTo(arg) < 0) {
                inf = med + 1;
            } else {
                max = med - 1;
            }
        }
        return "Seu candidato não foi encontrado! :( ";
    }
}
