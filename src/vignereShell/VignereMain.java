package vignereShell;

import java.util.Scanner;

public class VignereMain {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Escoge la opcion que desees\n1-Cifrado\n2-Descifrado\nEl cifrado es unicamente con valores"
				+ "letras del alfabeto ingles (sin contar la letra ñ)\n"); //Menu para seleccionar Cif/Des
		Scanner input=new Scanner(System.in);  //objetos para leer de teclado
		Scanner cadena=new Scanner(System.in);
		
		int opcion=input.nextInt(); //Guardar opcion seleccionada
		
		switch(opcion) {
			case 1: //Caso cifrado
				System.out.println("\nIngresa el texto a cifrar\n");
				String plain=cadena.next();
				plain=plain.toUpperCase();  //Convertir texto plano a mayusculas
				System.out.println("\nIngresa la clave\n");
				String clav=cadena.next();
				clav=clav.toUpperCase();  //Convertir clave a mayusculas
				Cifrado cipher=new Cifrado();
				String cifrado=cipher.CifrandoVignere(plain,clav); //LLamando metodo para cifrar con texto en claro y clave
				System.out.println("Tu texto cifrado es: "+cifrado); //Imprimiendo el mensaje cifrado
				break;
				
			case 2: //Caso descifrado
				System.out.println("\nIngresa el texto a descifrar");
				String descifrando=cadena.next();
				descifrando=descifrando.toUpperCase(); //Convertir texto cifrado a mayusculas
				System.out.println("\nIngresa la clave");
				String clavDes=cadena.next();
				clavDes=clavDes.toUpperCase(); // Convertir clave a mayusculas
				Descifrado decipher=new Descifrado();
				String descifradoComplete=decipher.DescifrandoVignere(descifrando, clavDes); //llamando metodo par acifrar con texto cifrado y clave
				System.out.println("\nTu texto descifrado es:" + descifradoComplete);//Imprimiendo el mensaje descifrado
				break;
		}
	}

}
