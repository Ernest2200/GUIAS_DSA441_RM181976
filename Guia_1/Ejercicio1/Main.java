import java.util.Scanner;
public class Main{
    public static void main (String [] args) {
        Scanner teclado = new Scanner (System.in);
        float num1,num2;
        System.out.println("Programa para verificar que 2 números son divisbles entre sí.");
        System.out.println("Ingrese el primer valor:");
        num1 = teclado.nextFloat ();
        System.out.println("Ingrese el segundo valor:");
        num2 = teclado.nextFloat ();
        if (num1%num2==0) {
             System.out.println ("El número " +num1 + "es divisible por "+num2);
        }else{
                 System.out.println ("El número " +num1 + "no es divisible por "+num2);
        }
    }
}