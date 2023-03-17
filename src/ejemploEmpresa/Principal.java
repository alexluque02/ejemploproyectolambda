package ejemploEmpresa;

import java.util.ArrayList;
import java.util.List;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		
		int menu, edad;
		String dni, nombre;
		double horas, porc, sueldo;
		List <Trabajador> lista = new ArrayList <Trabajador> ();
		Oficina o=new Oficina(lista);
		
		
		System.out.println("Bienvenidos al programa de gestión");
		System.out.println("¿Qué porcentaje extra cobra un Gerente?");
		porc=Leer.datoDouble();
		
		o.agregar(new Trabajador("012", "Alex", 23, 170));
		o.agregar(new Trabajador("013", "Zaira", 34, 143));
		o.agregar(new Gerente("014", "Fran", 62, 121, porc));
		o.agregar(new Trabajador("015", "Roberto", 21, 89));
		o.agregar(new Trabajador("016", "Alberto", 54, 180));
		o.agregar(new Gerente("017", "Pepe", 64, 210, porc));
		
		do {
			System.out.println("1. Añadir Empleados\n"
					+ "2. Mostrar Lista de Empleados\n"
					+ "3. Mostrar empleado\n"
					+ "4. Editar horas trabajadas del Empleado\n"
					+ "5. Calcular Sueldo de un Empleado\n"
					+ "6. Mostrar Empleados al borde de jubilarse\n"
					+ "7. Mostrar el empleado mayor\n"
					+ "8. Mostrar Lista ordenada\n"
					+ "9. Mostrar si es mayor de 60");
			menu=Leer.datoInt();
			
			switch(menu) {
			case 1:
				System.out.println("Diga el dni del empleado");
				dni=Leer.dato();
				System.out.println("Diga el nombre del empleado");
				nombre=Leer.dato();
				System.out.println("Introduzca la edad");
				edad=Leer.datoInt();
				System.out.println("Indique las horas que ha trabajado este mes");
				horas=Leer.datoDouble();
				o.agregar(new Trabajador(dni, nombre, edad, horas));
				break;
			case 2:
				o.mostrar();
				break;
			case 3:
				System.out.println("Diga el dni");
				dni=Leer.dato();
				o.mostrarEmpleado(o.findByDni(dni));
				break;
			case 4:
				System.out.println("Diga Dni");
				dni=Leer.dato();
				System.out.println("Diga el número nuevo de horas");
				horas=Leer.datoDouble();
				o.editHoras(o.findByDni(dni), horas);
				break;
			case 5:
				System.out.println("Diga el dni");
				dni=Leer.dato();
				System.out.println("Diga cuánto cobra la hora este empleado");
				sueldo=Leer.datoDouble();
				System.out.printf("El sueldo de un empleado es: %.2f€\n", o.calcularSueldoUnEmpleado(o.findByDni(dni), sueldo));
				break;
			case 6:
				System.out.println(o.listarMayores());
				break;
			case 7:
				System.out.println(o.comprobarMayor());
				break;
			case 8:
				o.mostrarOrdenado();
				o.mostrar();
				break;
			case 9:
				System.out.println("Diga el Dni del empleado");
				dni=Leer.dato();
				if(o.comprobarMayoresSesenta(o.findByDni(dni))) {
					System.out.println("¡Está apuntito!");
				}else {
					System.out.println("Aún le queda");
				}
			}
		}while(menu!=0);
		
		System.out.println("Gracias por utilizar nuestro programa");

	}

}
