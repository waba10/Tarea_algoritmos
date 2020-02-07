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
    public static void main(String[] args) {
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
        
        suma(number_one, number_two);
    }
    static void suma(ArrayList<Integer> number_one, ArrayList<Integer> number_two){
            int[] numeros = new int[11];
            int aux=11, aux2=0, aux3=0;
            /*for (int i = 0; i < 20; i++) {
                numeros[i]=0;
            }*/
            System.out.println(number_one);
            System.out.println(number_two);
            int residuo=0, division=0;
            
            
            for (int i = 9; i >= 0; i--) {
                aux--;
                aux2=aux;
                int resultado_suma= number_one.get(i)+number_two.get(i);
                
                if(numeros[aux2]+resultado_suma>9){
                    residuo=(numeros[aux2]+resultado_suma)%10;
                    division=(numeros[aux2]+resultado_suma)/10;
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
                    numeros[aux2]+=resultado_suma;
                }
                
        }
        System.out.print("La respuesta es: ");
        for (int i = 0; i < 11; i++) {
            
            System.out.print(numeros[i]);
        }
        System.out.println("");
            
            
        }
    
}
