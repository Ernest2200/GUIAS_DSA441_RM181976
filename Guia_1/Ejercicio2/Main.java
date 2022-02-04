 import java.util.Scanner;
 public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        double nota;
        int i,mayores,menores;
        mayores=0;
        menores=0;
         for (i = 1; i <= 10; i++) {
             System.out.println ("Ingrese la nota  " +i);
            nota = teclado.nextDouble();
            if(nota>=7){
                mayores++;
            }else{
                menores++;
            }      
        }
         System.out.println("El número de notas mayores o iguales a 7 es : " + mayores);
         System.out.println("El número de notas menores a 7 es : " + menores );
    }
 }
