
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Fiche fichero = null;
        String dni;
        int salario;
        
        fichero.crearfichero("Empleados");
        
        do {
            do {
                System.out.println("Elija una opcion");
                System.out.println("1. dar de alta");
                System.out.println("2. dar de baja");
                System.out.println("3. modificar");
                System.out.println("4. listar empleados, ordenado por DNI");
                System.out.println("5. listar empleados, ordenados por orden de introduccion");
                System.out.println("6. salir");
                opcion = Integer.parseInt(sc.nextLine());
            } while (opcion < 1 || opcion > 6);

            switch (opcion) {
                case 1:

                    insertar();

                    break;
                case 2:
                    System.out.println("introduzca el dni que desea eliminar");
                    dni = sc.nextLine();
                    fichero.baja(dni);
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
        String nombreyape;
        Empleado emple = null;
        try {
            String dni;
            //hay que controlar el dni que introduce que sea valido
            do {
                System.out.print("Introduzca DNI: ");
                dni = sc.nextLine();
            } while (dni.length() > 9);
            registro = new StringBuffer(dni);
            registro.setLength(30);

            dni = registro.toString();

            do {
                System.out.print("Introduzca el nombre y el apellido: [Máx 30 Caracteres]");
                nombreyape = sc.nextLine();
            } while (nombreyape.length() > 30);
            registro = new StringBuffer(nombreyape);
            registro.setLength(30);

            //este es el nombre y apellidos del empleado que ocupa 30caracteres si o si
            empleado = registro.toString();

            char sexo;
            String sexos;
            do {
                System.out.println("Introduzca M/H m:mujer h:hombre");
                sexos = sc.nextLine();
                sexos = sexos.toUpperCase();
                sexo = sexos.charAt(0);
            } while (sexo != 'M' && sexo != 'H');

            float salario;
            String salarios;
            do {
                System.out.println("Introduzca el salario del empleado:");
                salarios = sc.nextLine();
                salario = Float.parseFloat(salarios);
            } while (salario <= 0 || salario >= 10000);

            //probablemente esto lo tengamos que cambiar pero de mientras lo voy a pillar como un int de 4
            String años;
            int anio;

            do {
                System.out.println("Introduzca el año de contratacion del empleado:");
                años = sc.nextLine();
                anio = Integer.parseInt(años);
                //obviametne es con date y el 2016 seria fecha actual de hoy...
            } while (anio > Integer.parseInt(annioactual));

            String meses;
            short mes;
            do {
                System.out.println("Introduzca el mes de contratacion  del empleado:");
                meses = sc.nextLine();
                mes = Short.parseShort(meses);
                //obviametne es con date 
            } while (mes < 1 || mes > 12);

            String dias;
            short dia;
            do {
                System.out.println("Introduzca el dia de contratacion del empleado:");
                dias = sc.nextLine();
                dia = Short.parseShort(dias);
                //obviametne es con date 
            } while (dia < 1 || dia > 31);

            String tipoemples;
            char tipoemple;
            do {
                System.out.println("Introduzca el tipo de empleado:(C,F,D)");
                tipoemples = sc.nextLine();
                tipoemples = tipoemples.toUpperCase();
                tipoemple = tipoemples.charAt(0);

            } while (tipoemple != 'C' && tipoemple != 'F' && tipoemple != 'D');

            String provincias;
            byte provincia;
            do {
                System.out.println("Introduzca el numero de la provincia en la que trabaja");
                provincias = sc.nextLine();
                provincia = Byte.parseByte(provincias);

            } while (provincia < 1 || provincia > 8);

            // do{
            //  }while(!"s".equals(continuar) && !"N".equals(continuar) && !"s".equals(continuar) && !"n".equals(continuar));
            emple = new Empleado(nombreyape, sexo, salario, anio, mes, dia, tipoemple, provincia);

        } catch (NumberFormatException p) {
            System.out.println(" ha habido algun fallo en la casteo de algun numero");
        } finally {
            return emple;
        }

    }

}
