import java.util.*;
public class Main {
    public static void crear_calendario(int citas[][], String
            dias_usados[][]){
        for (int i = 0; i < citas.length; i++) {
            for (int j = 0; j < citas[0].length; j++) {
                citas[i][j] = 0;
            }
        }
        for (int i = 0; i < dias_usados.length; i++) {
            for (int j = 0; j < dias_usados[0].length; j++) {
                dias_usados[i][j] = "*";
            }
        }
        for (int i = 0; i < citas.length; i++) {
            System.out.println("");
            for (int j = 0; j < citas[0].length; j++) {
                System.out.print(citas[i][j] + " ");
            }
        }
    }
    public static void rellenar_kilos_dia(int kilos, int
            citas[][]){
        for (int i = 0; i < citas.length; i++) {
            int dia_descanso;
            dia_descanso = (int)(Math.random()* 6+1);
            for (int j = 0; j < citas[0].length; j++) {
                if(j == dia_descanso){
                    citas[i][j] = -1;
                }else {
                    int kilossumados = (int) (Math.random() * 1000
                            + 1) + kilos;
                    citas[i][j] = kilossumados;
                }
            }
        }
        for (int i = 0; i < citas.length; i++) {
            System.out.println("");
            for (int j = 0; j < citas[0].length; j++) {
                System.out.print(citas[i][j] + " ");
            }
        }
    }
    public static float litros_aceite(char calidad, int
            kilosllevar){
        float litros = 0;
        switch (calidad){
            case 'S':
                litros = (float) (kilosllevar*0.28);
                break;
            case 'B':
                litros = (float) (kilosllevar*0.22);
                break;
            case 'R':
                litros = (float) (kilosllevar*0.15);
                break;
            case 'M':
                litros = (float) (kilosllevar*0.08);
                break;
            default:
                litros = -1;
        }
        return litros;
    }
    public static int dias_para_hacer_aceite(int kilosllevar, int
            citas[][], String dias_usados[][]){
        int cont = 0;
        for (int i = 0; i < citas.length; i++) {
            int num = 0;
            System.out.println("");
            for (int j = 0; j < citas[0].length; j++) {
                if(citas[i][j] == -1){
                    dias_usados[i][j] = "*";
                }else{
                    if (kilosllevar < citas[i][j]){
                        dias_usados[i][j] = "*";
                    }else{
                        dias_usados[i][j] = dia(num);
                        kilosllevar = kilosllevar-citas[i][j];
                        cont++;
                        num++;
                    }
                }
            }
        }
        System.out.println(cont);
        for (int i = 0; i < dias_usados.length; i++) {
            System.out.println("");
            for (int j = 0; j < dias_usados[0].length; j++) {
                System.out.print(dias_usados[i][j] + " ");
            }
        }
        return cont;
    }
    public static String dia(int num){
        String dia = "";
        switch (num){
            case 0:
                dia = "Lunes";
                break;
            case 1:
                dia = "Martes";
                break;
            case 2:
                dia = "Miercoles";
                break;
            case 3:
                dia = "Jueves";
                break;
            case 4:
                dia = "Viernes";
                break;
            case 5:
                dia = "Sabado";
                break;
            case 6:
                dia = "Domingo";
                break;
        }
        return dia;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int citas[][] = new int[4][7];
        String dias_usados[][] = new String[4][7];
        int kilos;
        int kilosllevar;
        char calidad;
        System.out.println("*******************************************");
        crear_calendario(citas, dias_usados);
        System.out.println("\n*******************************************"
        );
        System.out.println("Ingrese el numero de kilos que la almazara puede procesar: ");
        kilos = sc.nextInt();
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        rellenar_kilos_dia(kilos, citas);
        System.out.println("\n*******************************************"
        );
        System.out.println("Introduce los kilos que quieres llevar a la almazara: ");
        kilosllevar = sc.nextInt();
        System.out.println("Indica la calidad de la oliva: ");
        calidad = sc.next().toUpperCase().charAt(0);
        System.out.println("Para la calidad"+calidad+"los litros que se van a extraer son: "+litros_aceite(calidad, kilosllevar));
        System.out.println("Los dias para realizar aceite son los siguientes: ");
        dias_para_hacer_aceite(kilosllevar, citas, dias_usados);
    }
}



