import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = "";
        int horas = 0;
        float valor = 0;
        System.out.println("Digite seu nome: ");
        name = input.next();
        System.out.println("Digite o total de horas trabalhadas: ");
        horas = Integer.parseInt(input.next());
        System.out.println("Digite o valor pago por hora: ");
        valor = Float.parseFloat(input.next());
        System.out.println("Valor pago total: R$"+valor*horas);
    }
}
