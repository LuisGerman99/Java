import java.io.*;
import java.util.*;

public class Proyecto_Eq {

	public static Scanner sc = new Scanner(System.in);
	public static Scanner ld = new Scanner(System.in);
	static int i=0;

	public static void main (String args[]) {

		int[] Num = new int[100];
		String[] Nombre = new String[100];

		int op=0,j,k,f,mat,c;
		double pago;

			do {
				System.out.println("\nMENU DE OPCIONES (PARA SALIR DEL PROGRAMA INTRODUZCA EL VALOR 999)\n");
				System.out.println("ALTAS......1");
				System.out.println("BAJAS......2");
				System.out.println("CAMBIOS....3");
				System.out.println("REPORTES...4");
				System.out.println("SALIR....999");

				System.out.print("\nEscoja una opcion: ");
				op=sc.nextInt();

				switch(op) {

					case 1:
						if ( i < 100 ) {
							do {
								Altas(Num,Nombre);
								i++;
								if ( i < 100 ) {
									do {
										System.out.println("¿Desea continuar dando de alta a alumnos? (Introduzca 1 para SI y 0 para NO)");
										c=Continuar();
									}while(c<0||c>1);
								}
								else {
									c = 0;
								}
							}while(c==1 & i < 100);
						}

						if(i==100){
								System.out.println("\nYa no se pueden introducir más alumnos");
						}

						break;

					case 2:

						do {
							c=-1;
							if (i>0) {
								c=Bajas(Num,Nombre,c);
								do {
									f=sc.nextInt();
									if (f<0||f>2) {
										System.out.print("Esa opción no existe, por favor elija una entre 0 y 2");
									}
								}while(f<0&&f>2);
								if (f==1) {
									Eliminar(Num,Nombre,c);
									i--;
									System.out.println("LISTO");
									if (i>0) {
										System.out.println("¿Desea continuar dando de baja a alumnos? Introduzca 1 para SI y 0 para NO");
										c=Continuar();
									}
									else {
										System.out.println("Ya no se pueden dar de baja más alumnos");
									}
								}
								else if (f==0) {
									System.out.println("¿Desea continuar dando de baja a alumnos? Introduzca 1 para SI y 0 para NO");
									c=Continuar();
								}
							}
							else {
								System.out.println("No se encuentran dentro alumnos en el sistema, favor de ingresar alumnos");
								c=0;
							}
						}while(c==1&&i>0);

					break;

					case 3:
						do {
							c=-1;
							if (i>0) {
								Cambio(Num,Nombre,c);
								System.out.println("¿Desea continuar haciendo cambios? (Introduzca 1 para SI y 0 para NO)");
								f=Continuar();
							}
							else {
								System.out.println("No se encuentran alumnos dentro del sistema, favor de introducir alumnos");
								f=0;
							}
						}while(f==1);
					break;

					case 4:

						do {
							if (i>0) {
								Reporte(Num,Nombre);
								System.out.println("\n\n¿Desea continuar haciendo reportes? (Introduzca 1 para SI y 0 para NO)");
								do {
									f=Continuar();
								}while(f<0||f>1);
							}
							else {
								System.out.println("No se encuentran alumnos dentro del sistema, favor de introducir alumnos");
								f=0;
							}
						}while(f==1);

					break;

					default:

						if (op!=999) {
							System.out.println("Esa opción no existe, por favor elija una entre 1 y 4 o bien 999 para salir del programa");
						}
						else {
							System.out.println("\nHa finalizado la modificacion del sistema\n");
						}
				}
			}while(op!=999);
	}

	public static void Altas (int[] Num, String[] Nombre) {

		int j, si;

		if ( i >= 1 ) {

			do {
				si = 0;

				do {
					System.out.print("\nIngrese la matricula mayor que 0: ");
					Num[i] = sc.nextInt();
				}while(Num[i] <= 0);

				for ( j = 0; j < i & si != 1; j++ ) {
					if ( Num[j] == Num[i]) {
						si++;
					}
				}

				if ( si == 1 ) {
					System.out.println("Esta matricula no esta disponible");
				}

			}while( si == 1 );

			do {
				si = 0;
				System.out.print("Ingrese un nombre para esa matricula: ");
				Nombre[i] = ld.nextLine();

				for ( j = 0; j < i & si != 1; j++ ) {
					if ( Nombre[j].compareToIgnoreCase(Nombre[i]) == 0)  {
						si++;
					}
				}

				if ( si == 1 ) {
					System.out.println("Este nombre no esta disponible");
				}

			}while( si == 1 );

		}

		else {

			do {
				System.out.print("\nIngrese la matricula mayor que 0: ");
				Num[i] = sc.nextInt();
			}while(Num[i]<=0);

			System.out.print("Ingresa el nombre para la matricula: ");
			Nombre[i] = ld.nextLine();
		}
	}

	public static int Bajas (int[] Num,String[] Nombre,int c) {

		int f;

		do {
			c=-1;
			c=VerificarNum(Num,c);
		}while (c==-1);
		System.out.println("¿Desea dar de baja a "+Nombre[c]+" con el número "+Num[c]+" del sistema? Introduzca 1 para SI, 0 para NO y 2 para SALIR");

		return c;
	}

	public static void Eliminar (int[] Num,String[] Nombre, int c){

		if (c<99) {
			for (int j=c;j<i;j++) {
				Num[j]=Num[j+1];
				Nombre[j]=Nombre[j+1];
			}
		}
		else {
			Num[c]=0;
			Nombre[c]="";
		}

	}

	public static void Cambio (int [] Num, String[] Nombre,int c) {

		int n,x;
		String nom;

		do {
			do {
				c=-1;
				c=VerificarNum(Num,c);
			}while(c==-1);
			System.out.println("¿Desea hacer cambios al nombre de "+Nombre[c]+" con el número "+Num[c]+" en el sistema? Introduzca 1 para SI y 0 para NO");
			do {
				x=sc.nextInt();
				if (x<0||x>1) {
					System.out.println("No se tiene esa opción, favor de ingresar un valor entre 0 y 1");
				}
			}while(x<0||x>1);
			if (x==0) {
				x=2;
			}
			else {
				x=0;
			}
		}while(x==1);
		if (x!=2) {
			do {
				System.out.println("Ingrese nuevo nombre del alumno(a)");
				nom=ld.nextLine();
				x=nom.compareToIgnoreCase(Nombre[c]);
				if (x==0) {
					System.out.println("No cambió el nombre, favor de ingresar uno diferente");
					System.out.println("Si desea CONTINUAR introduzca el valor de 1, por el contrario, introduzca cualquier valor");
					x=sc.nextInt();
				}
				else {
					Nombre[c]=nom;
					if (i>1) {
						x=VerificarNombre(Nombre,c);
					}
					else {
						x=1;
					}
				}
			}while(x>0);
		}

	}

	public static void Reporte (int[] Num, String[] Nombre) {

		int j, k, n, aux, acum = 0;
		double prom;
		String aux2;

		System.out.println("\n1.- Forma Ascendente por Matricula");
		System.out.println("2.- Forma Descendente con Matricula");
		System.out.println("3.- Forma Ascendente con Nombre");
		System.out.println("4.- Forma Descendente por Nombre");

		do {
			System.out.print("\nEscoja la opcion 1, 2, 3 o 4: ");
			n = sc.nextInt();

			if ( n != 1 & n != 2 & n!= 3 & n != 4)
				System.out.println("\nEl numero a seleccionar debe ser 1, 2, 3 o 4");

		}while( n != 1 & n !=2 & n != 3 & n != 4);

		switch ( n ) {

			case 1:
				for ( j = 1; j < i; j++ ) {
					for ( k = 0; k < ( i-1 ); k++ ) {
						if ( Num[k] > Num[k+1] ) {
							aux = Num[k];
							Num[k] = Num[k+1];
							Num[k+1] = aux;
							aux2 = Nombre[k];
							Nombre[k] = Nombre[k+1];
							Nombre[k+1] = aux2;
						}
					}
				}
				break;

			case 2:
				for ( j = 1; j < i; j++ ) {
					for ( k = 0; k < (i-1); k++ ) {
						if ( Num[k] < Num[k+1] ) {
							aux = Num[k];
							Num[k] = Num[k+1];
							Num[k+1] = aux;
							aux2 = Nombre[k];
							Nombre[k] = Nombre[k+1];
							Nombre[k+1] = aux2;
						}
					}
				}
				break;

			case 3:
				for ( j = 1; j < i; j++ ) {
					for ( k = 0; k < (i-1); k++ ) {
						if ( Nombre[k].compareToIgnoreCase(Nombre[k+1]) > 0) {
							aux2 = Nombre[k];
							Nombre[k] = Nombre[k+1];
							Nombre[k+1] = aux2;
							aux = Num[k];
							Num[k] = Num[k+1];
							Num[k+1] = aux;
						}
					}
				}
				break;

			case 4:
				for ( j = 1; j < i; j++ ) {
					for ( k = 0; k < (i-1); k++ ) {
						if ( Nombre[k].compareToIgnoreCase(Nombre[k+1]) < 0) {
							aux2 = Nombre[k];
							Nombre[k] = Nombre[k+1];
							Nombre[k+1] = aux2;
							aux = Num[k];
							Num[k] = Num[k+1];
							Num[k+1] = aux;
						}
					}
				}
				break;

		}

		for ( j = 0; j < i; j++ ) {
			acum = acum + Num[j];
			System.out.print("\n" + Num[j] + "  " + Nombre[j]);
		}

		prom = (double) acum / i;

		System.out.println("\n\nLa cantidad de alumnos es: " + i);
		System.out.println("La suma total de las matriculas es: " + acum);
		System.out.println("El promedio es: " + prom);

	}


	public static int VerificarNum (int[] Num, int c) {

		int n;
			do {
				System.out.println("Dar número de alumno(a) existente");
				n=sc.nextInt();
			}while(n<=0);
			for (int j=0;j<i;j++) {
				if (n==Num[j]) {
					c=j;
				}
			}
			if (c==-1) {
				System.out.println("Ese número de alumno(a) no existe, favor de intentar con otro");
			}
		return c;
	}

	public static int VerificarNombre (String[] Nombre, int c) {

		int m,n=0;

		for (int j=0;j<c;j++) {
			if (j!=c) {
				m=Nombre[c].compareToIgnoreCase(Nombre[j]);
				if (m==0) {
					n++;
				}
			}
		}
		if (n>0) {
			System.out.println("Ese nombre ya existe, favor de utilizar otro");
		}

		return n;

	}

	public static int Continuar () {

		int c;

		do {
			c=sc.nextInt();
			if (c<0||c>1) {
				System.out.println("No se tiene esa opcion, elija entre 0 y 1, por favor");
			}
		}while(c<0&&c>1);

		return c;
	}
}