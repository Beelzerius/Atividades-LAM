
import java.util.Scanner;

public class frag2 {
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a opção:");
        op = input.nextInt();
        switch(op)   {
            case 1:
                System.out.println("Opgao 1");
                break;
            case 2:
                System.out.println("OpOo 2");
                break;
            case 3:
                System.out.println("Opcao 3");
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }
}
