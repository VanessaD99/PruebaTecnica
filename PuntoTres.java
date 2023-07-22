import java.util.*;

public class PuntoTres {

     public static void main(String[] args)
    {
        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese los numeros (enteros) de la lista (Nota: Ingrese una palabra o letra para finalizar)");
        List<Integer> inputList= new ArrayList<>();

        while(lectura.hasNextInt()){
            inputList.add(lectura.nextInt());
        }

        List<List<Integer>> listaAgrupada = agruparLista(inputList);
        System.out.println("La salida es: "+ listaAgrupada);
    }

    public static List<List<Integer>> agruparLista(List<Integer> inputList) {
         List<List<Integer>> listaAgrupada = new ArrayList<>();

         Map<Integer, Integer> contadorReps = new HashMap<>();

        for (Integer elemento :inputList) {
            if(contadorReps.get(elemento)==null) {
                contadorReps.put(elemento, 1);
            } else {
                contadorReps.put(elemento, contadorReps.get(elemento)+1);
            }
        }

        for (Integer key : contadorReps.keySet()) {
            List<Integer> elementos = new ArrayList<>();
            for (int i=0;i<contadorReps.get(key); i++) {
                elementos.add(key);
            }
            listaAgrupada.add(elementos);
        }
         return listaAgrupada;
    }

}