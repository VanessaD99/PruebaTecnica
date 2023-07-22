import java.util.*;

public class PuntoCuatro {
    public static void main(String[] args){
        Map<String, List<String>> groups = new HashMap<>();
        Map<String, List<Integer>> groupsStock = new HashMap<>();

        List<String> dairyProducts = new ArrayList<>();
        dairyProducts.add("Fairlife Milk");
        dairyProducts.add("Alta Dena Milk");
        dairyProducts.add("Queensland Butter");
        List<Integer> dairyStock = new ArrayList<>();
        dairyStock.add(28);
        dairyStock.add(36);
        dairyStock.add(50);
        List<String> cleaningProducts = new ArrayList<>();
        cleaningProducts.add("Lavaloza");
        cleaningProducts.add("Detergente");
        cleaningProducts.add("Limpia Vidrios");
        List<Integer> cleaningStock = new ArrayList<>();
        cleaningStock.add(40);
        cleaningStock.add(35);
        cleaningStock.add(29);
        List<String> grainProducts = new ArrayList<>();
        grainProducts.add("Arroz");
        grainProducts.add("Lenteja");
        grainProducts.add("Frijoles");
        List<Integer> grainStock = new ArrayList<>();
        grainStock.add(50);
        grainStock.add(48);
        grainStock.add(37);

        groups.put("dairy", dairyProducts);
        groups.put("cleaning", cleaningProducts);
        groups.put("grain", grainProducts);

        groupsStock.put("dairy", dairyStock);
        groupsStock.put("cleaning", cleaningStock);
        groupsStock.put("grain", grainStock);

        showMenu();
        Scanner lectura = new Scanner (System.in);
        
        System.out.print("Su opcion: ");

        int opcion = lectura.nextInt();
        while (opcion!=3) {
            switch(opcion) {
                case 1:
                    Scanner scanner = new Scanner (System.in);
                    System.out.print("Su opcion fue 1 ");
                    System.out.print("Por favor ingrese el grupo del producto (Nota: estos grupos son: dairy, cleaning y grain.) ");
                    String grupo = lectura.next();

                    System.out.print("Por favor ingrese la cantidad producto ");
                    Integer cantidad = lectura.nextInt();

                    System.out.print("Por favor ingrese el nombre del producto ");
                    String producto="";
                    producto += scanner.nextLine();

                    if("dairy".equals(grupo)){
                        addProduct(groups.get("dairy"), groupsStock.get("dairy"), producto, Integer.valueOf(cantidad));
                    } else if("cleaning".equals(grupo)){
                        addProduct(groups.get("cleaning"), groupsStock.get("cleaning"), producto, Integer.valueOf(cantidad));
                    } else if("grain".equals(grupo)){
                        addProduct(groups.get("grain"), groupsStock.get("grain"), producto, Integer.valueOf(cantidad));
                    }
                    break;
                case 2:
                    System.out.print("Su opcion fue 2 ");
                    System.out.println("");
                    showInventory(groups, groupsStock);
                    break;
            }

            System.out.println("");
            System.out.println("OPERACION FINALIZADA");
            System.out.print("=========================================================");
            System.out.print("=========================================================");
            System.out.println("");
            System.out.println("");
            showMenu();
            lectura = new Scanner (System.in);
            opcion = lectura.nextInt();
        }


    }

    public static void showMenu() {
        System.out.println("Sistema de inventario. Ingrese una opcion: ");
        System.out.println("----------------------------------------- ");
        System.out.println("1. Agregar producto ");
        System.out.println("2. Ver reporte de inventario ");
        System.out.println("3. Salir ");
    }
    public static void addProduct(List<String> products, List<Integer> stock, String producto, Integer cantidad){

        boolean existProduct = false;
        int indexP = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).toLowerCase().equals(producto.toLowerCase())) {
                existProduct = true;
                indexP = i;
                break;
            }
        }
        int i = indexP;
        if (existProduct) {
            stock.set(i, stock.get(i)+cantidad);
        } else {
            products.add(producto);
            stock.add(cantidad);
        }
    }

    public static void showInventory(Map<String, List<String>> groups, Map<String, List<Integer>> groupsStock) {
        System.out.println("");
        System.out.println("");


        for (String key : groups.keySet()) {
            System.out.println("********************************");
            System.out.println(key.toUpperCase());
            System.out.printf("%-50s %-9s%n", "Nombre", "Existencias");
            System.out.println("------------------------------");

            for (int i = 0; i < groups.get(key).size(); i++) {
                System.out.printf("%-50s %-9d%n", groups.get(key).get(i), groupsStock.get(key).get(i));
            }
        }

    }


}
