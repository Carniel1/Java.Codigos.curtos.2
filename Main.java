//Recebe um valor de disco do usuário, e fala quais são as jogada para ganha no jogo torre de Hanói.

import java.util.Stack;
import java.util.Scanner;

public class Main{
	private static Stack<String> pilha = new Stack<String>();
	private static long numMov;
	private static void mover(int A, int B) {
            numMov++;
            System.out.println("[" + numMov + "]:" + A + " <-Para o pino-> " + B);
}

	public static void hanoi(int s) {

            int A = 1; 
            int B = 3; 
            int C = 2; 

            
	String comandoAtual = s + "," + A + "," + B + "," + C;
	pilha.push(comandoAtual);
        
            while (!pilha.empty()) {
            if (s > 1) {
            s--;
        String[] vetAux = comandoAtual.split(",");
            A = Integer.parseInt(vetAux[1]);
            B = Integer.parseInt(vetAux[2]);
            C = Integer.parseInt(vetAux[3]);

        comandoAtual = s + "," + A + "," + C + "," + B;

	pilha.push(comandoAtual);

} 
            else {

	comandoAtual = pilha.pop();

	String[] vetAux = comandoAtual.split(",");
            s = Integer.parseInt(vetAux[0]);
            A = Integer.parseInt(vetAux[1]);
            B = Integer.parseInt(vetAux[2]);
            C = Integer.parseInt(vetAux[3]);
        

	mover(A, B);

            if (s > 1) {
            s--;

            comandoAtual=s + "," + C + "," + B + "," + A;
            pilha.push(comandoAtual);
}
}
}
}
	public static void main(String[] args) {

            int s; 
            Scanner tcl = new Scanner(System.in);
            System.out.println("Digite o número de discos: ");
            s = tcl.nextInt();

        Main.hanoi(s);
            System.out.print("Fim de jogo!! ");
}
}