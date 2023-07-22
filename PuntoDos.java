import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuntoDos {

    public static void main(String[] args){
    Scanner lectura = new Scanner (System.in);
    System.out.println("Ingrese los numeros (enteros) de la lista (Nota: Ingrese una palabra o letra para finalizar)");
    List<Integer> inputList= new ArrayList<>();

    while(lectura.hasNextInt()) {
        inputList.add(lectura.nextInt());
    }

    System.out.println("Este es el Array Inicial "+ inputList);
    List<Integer> outputList = validacionArrayList(inputList);
    System.out.println("Este es el Array Final" + outputList);

    }

    public static List<Integer> validacionArrayList(List<Integer> inputList){

        List<Integer> outputList= new ArrayList<>();

        for (Integer elementoArrayList: inputList) {
            int divisible5 = elementoArrayList%5;
            if(elementoArrayList<1000){
                if(divisible5==0 && elementoArrayList<600){
                    outputList.add(elementoArrayList);
                }
            }else {
                break;
            }
        }

        return outputList;
    }
}
