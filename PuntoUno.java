import java.util.Scanner;

public class PuntoUno {
    public static void main(String[] args)
    {
        int termino = 0;
        int entrada = 0;
        try {
            System.out.println("Ingrese una entrada (entero)");
            Scanner lectura = new Scanner (System.in);
            entrada = lectura.nextInt();
            System.out.println("Ingrese un termino (entero)");
            termino = lectura.nextInt();
        }catch (Exception e) {
            throw new RuntimeException("Error leyendo los numeros, verifique que tenga el formato indicado");
        }
        int salida = suma(entrada,termino);
        System.out.println("Esta es la suma Acumulada "+salida);
    }

    public static int suma(int entrada, int termino){

        String acumulador = "";
        int conversion = 0;
        int sumaAcumulada = 0;
        for(int i=0;i<termino;i++){
            acumulador = entrada+acumulador;
            conversion = Integer.parseInt(acumulador);
            sumaAcumulada = conversion+sumaAcumulada;
        }
        return sumaAcumulada;
    }

}



