import java.util.Scanner;
 public class Main {
    public static void main(String[] ar) {
        Scanner teclado = new Scanner (System.in);
        int impares, pares,numero;
        String salir = " ";
        pares = 0;
        impares = 0;
        do {
            System.out.println("Ingrese un número : ");
            numero = teclado.nextInt() ;
            if (numero%2== 0) {
                 pares++;
            }else{
                impares++;
            }
            System.out.println ("¿Desea finalizar el programa? (s/n): ");
             salir = teclado.next();
         } while (!salir.equalsIgnoreCase("S") || !salir.equalsIgnoreCase("s"));
             System.out.println ("La cantidad de números pares es: " + pares);
             System.out.println ("La cantidad de números impares es: " + impares);
    }
 }