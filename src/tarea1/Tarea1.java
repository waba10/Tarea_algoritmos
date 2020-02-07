                    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author HP PC
 */
public class Tarea1 {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ArrayList<Integer> number_one = new ArrayList<Integer>();
        ArrayList<Integer> number_two = new ArrayList<Integer>();        
        Random rand= new Random();
        int n1= rand.nextInt(10);
        int n2= rand.nextInt(10);
        for (int i = 0; i < 10; i++) {
            number_one.add(rand.nextInt(10));    
        }
        for (int i = 0; i < 10; i++) {
            number_two.add(rand.nextInt(10));  
        }
        int[] numeros = new int[11];//11 para la suma de 10, 101 para la de 100, 1001 para la de 1000
        int aux=11, aux2=0, aux3=0;       
        multiplicacion(number_one, number_two);  
        long inicio = System.currentTimeMillis();
        Thread.sleep(2000);
        for (int i = 9; i >= 0; i--) {//9 para lo de 10, 99 para lo de 100, 999 para lo de mil
            aux--;
            int resultado_suma= number_one.get(i)+number_two.get(i);
            suma(resultado_suma,aux,numeros);
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        
        System.out.print("La respuesta de la suma es: ");
        for (int i = 0; i < 11; i++) {//Aplica lo mismo que para la línea 33
            System.out.print(numeros[i]);
        }
        System.out.println("");
        System.out.println("La suma se tardó " + tiempo +" segundos");
    }    
    static void multiplicacion(ArrayList<Integer> number_one, ArrayList<Integer> number_two)throws InterruptedException{
        System.out.println(number_one);
        System.out.println(number_two);
        int multiplicacion=0;
        int aux=20, aux2=0;
        int[] numeros = new int[20]; //20 para la multiplicacion de dos números de 10 cifras,200 para números de 100 cifras y 2000 para números de 100 cifras 
        long inicio2 = System.currentTimeMillis();
        Thread.sleep(2000);      
        for (int i = 9; i >= 0; i--) {//aplica lo mismo que para la línea 38
            aux--;
            aux2=aux;
            for (int j = 9; j >= 0; j--) {//aplica lo mismo que para la línea 38
                multiplicacion= number_one.get(i)*number_two.get(j);
                suma(multiplicacion, aux2 ,numeros);
                aux2--;
            }           
        }
        long fin2 = System.currentTimeMillis();
        double tiempo = (double) ((fin2 - inicio2)/1000);
        System.out.print("La respuesta de la multiplicación es: ");
        for (int i = 0; i < 20; i++) { //aplica lo mismo que para la línea 58  
            System.out.print(numeros[i]);
        }
        System.out.println("");
        System.out.println("La multiplicación se tardó " + tiempo +" segundos");
    }
    static void suma(int valor, int aux, int numeros[]){
            int  aux2=aux, aux3=0;     
            int residuo=0, division=0;             
                if(numeros[aux2]+valor>9){
                    residuo=(numeros[aux2]+valor)%10;
                    division=(numeros[aux2]+valor)/10;
                    numeros[aux2]=residuo;
                    aux3=aux2-1;        
                    if(numeros[aux3]+division>9){
                        int carry=numeros[aux3]+division;
                        int residuo2=carry%10;
                        division=(carry)/10;
                        numeros[aux3]=residuo2;
                        aux3=aux3-1;
                        numeros[aux3]+=division;
                         while(numeros[aux3]>9){
                            int residuo3= numeros[aux3]%10;
                            division=numeros[aux3]/10;
                            numeros[aux3]=residuo3;
                            aux3=aux3-1;
                            numeros[aux3]+=division;
                         }
                    }
                    else{
                        numeros[aux2-1]=numeros[aux2-1]+division;
                    }
                }
                else{
                    numeros[aux2]+=valor;
                }
        }   
}
