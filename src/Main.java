
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Fiche fichero = new Fiche();
        String dni;
        int salario;

        // fichero.crearfichero("empleados");
        do {
            do {
                
                System.out.println("1. Dar de alta");
                System.out.println("2. Dar de baja");
                System.out.println("3. Modificar");
                System.out.println("4. Listar empleados, ordenado por DNI");
                System.out.println("5. Listar empleados, ordenados por orden de introducción");
                System.out.println("6. Salir");
                System.out.print("Elija opción [1-6]: ");
                opcion = Integer.parseInt(sc.nextLine());
            } while (opcion < 1 || opcion > 6);

            switch (opcion) {
                case 1:

                    fichero.alta(insertar());
                    //fichero.muestraemple(insertar());

                    break;
                case 2:
                    System.out.println("introduzca el dni que desea eliminar");
                    dni = sc.nextLine();
                    // fichero.baja(dni);
                    break;
                case 3:
                    System.out.println("introduzca el dni del empleado al que desea cambiar el salario ");
                    dni = sc.nextLine();
                    System.out.println("introduzca el nuevo salario");
                    salario = Integer.parseInt(sc.nextLine());
                    fichero.modificacion(salario, dni);
                    break;
                case 4:
                    fichero.lecturadni();
                    break;
                case 5:
                    fichero.lecturaordenada();
                    break;
            }

        } while (opcion > 5);

    }

    public static Empleado insertar() {
        Scanner sc = new Scanner(System.in);
        Calendar c = new GregorianCalendar();
        StringBuffer registro;
        String registros = "";
        String annioactual = Integer.toString(c.get(Calendar.YEAR));
        String empleado;
        String nombreyape = "";;
        Empleado emple = null;
        float salario = 0;
        byte provincia = 0;
        String provincias;
        char sexo = 'f';
        String dni = "";
        String sexos;
        String salarios;

        String años;
        int anio = 0;
        String meses;
        short mes = 0;
        String dias;
        short dia = 0;
        String tipoemples;
        char tipoemple = 'p';
        try {

            //hay que controlar el dni que introduce que sea valido
            do {
                System.out.print("Introduzca DNI: ");
                dni = sc.nextLine();
            } while (dni.length() > 9);
            registro = new StringBuffer(dni);
            registro.setLength(30);

            dni = registro.toString();

            do {
                System.out.print("Introduzca Nombre y Apellidos: ");
                nombreyape = sc.nextLine();
            } while (nombreyape.length() > 30);
            registro = new StringBuffer(nombreyape);
            registro.setLength(30);

            //este es el nombre y apellidos del empleado que ocupa 30caracteres si o si
            empleado = registro.toString();

            do {
                System.out.print("Introduzca M:Mujer H:Hombre: ");
                sexos = sc.nextLine();
                sexos = sexos.toUpperCase();
                sexo = sexos.charAt(0);
            } while (sexo != 'M' && sexo != 'H');

            do {
                System.out.print("Introduzca Salario: ");
                salarios = sc.nextLine();
                salario = Float.parseFloat(salarios);
            } while (salario <= 0 || salario >= 10000);

            //probablemente esto lo tengamos que cambiar pero de mientras lo voy a pillar como un int de 4
            do {
                System.out.print("Introduzca Año de contratación: ");
                años = sc.nextLine();
                anio = Integer.parseInt(años);
                //obviametne es con date y el 2016 seria fecha actual de hoy...
            } while (anio > Integer.parseInt(annioactual));

            do {
                System.out.print("Introduzca Mes de contratación: ");
                meses = sc.nextLine();
                mes = Short.parseShort(meses);
                //obviametne es con date 
            } while (mes < 1 || mes > 12);

            do {
                System.out.print("Introduzca Día de contratación: ");
                dias = sc.nextLine();
                dia = Short.parseShort(dias);
                //obviametne es con date 
            } while (dia < 1 || dia > 31);

            do {
                System.out.print("Introduzca Tipo de empleado [C/D/F]: ");
                tipoemples = sc.nextLine();
                tipoemples = tipoemples.toUpperCase();
                tipoemple = tipoemples.charAt(0);
            } while (tipoemple != 'C' && tipoemple != 'F' && tipoemple != 'D');

            do {
                System.out.print("Introduzca Número de Provincia [1-8]: ");
                provincias = sc.nextLine();
                provincia = Byte.parseByte(provincias);
            } while (provincia < 1 || provincia > 8);

            // do{
            //  }while(!"s".equals(continuar) && !"N".equals(continuar) && !"s".equals(continuar) && !"n".equals(continuar));
        } catch (NumberFormatException p) {
            System.err.println("Error de Casteo");
        }

        emple = new Empleado(nombreyape, sexo, salario, anio, mes, dia, tipoemple, provincia);

        return emple;

    }

}
