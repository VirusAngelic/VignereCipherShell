package vignereShell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Cifrado {

	//Declaracion de ArrayList para operaciones
	private static HashMap<Character,Integer> VignereMapMayus;
	private static HashMap<Integer,Character> VignereMapIndex;
	private ArrayList<Integer> keyPlain;
	private ArrayList<Integer> keyClave;
	private ArrayList<Integer> resultForTabla;
	
	
	Cifrado(){ //Llenado de arraylist de tabla vignere por medio de contructor default
		Integer index=0;
		char letra;
		VignereMapMayus=new HashMap<Character,Integer>();
		VignereMapIndex = new HashMap<Integer,Character>();
		
		
		for(int i=65;i<91;i++){
			letra=(char)i;
			VignereMapMayus.put(Character.valueOf(letra),index); //LLenado de tabla de vignere por caracter
			VignereMapIndex.put(index, Character.valueOf(letra));  //Llenado de tabla de vignere por numero
			index++;
		}
	}
	
	public String CifrandoVignere(String plainText, String clave){
		String cifrado=""; //Cadena con el texto cifrado
		int iterador=0;
		keyPlain=new ArrayList<>(); //Instanciacion de nuevos ArrayList para operacion
		keyClave=new ArrayList<>();
		resultForTabla = new ArrayList<>();
		
		while(plainText.length()>clave.length()) { //Rellenado de clave para simetria con el texto a cifrar
			clave += clave.charAt(iterador);
			iterador++;
		}
		
		for (char letra : plainText.toCharArray()) {  //Busqueda del indice en el Mapa de vignere de cada caracter en la cadena
			keyPlain.add(VignereMapMayus.get(letra));		
		}
		
		for (char letra: clave.toCharArray()) { //Busqueda del indice en el Mapa de vignere de cada caracter en la cadena
			keyClave.add(VignereMapMayus.get(letra));
		}
		
		for(int i=0; i<keyPlain.size();i++) {  //Loop para determinar el modulo y el caracter correspondiente al resultado del modulo
			resultForTabla.add(keyPlain.get(i)+keyClave.get(i)); //Suma de posiciones de la tabla de vignere
			int modulo=resultForTabla.get(i)%26; //Modulo para determinar el caracter en la tabla de vignere
			resultForTabla.set(i,modulo); //Ingreso del modulo en nuevo arraylist
			
			cifrado+=VignereMapIndex.get(resultForTabla.get(i)); //Concatenacion de caracteres para formar el texto cifrado por medio de la tabla de vignere
			
			}
		
		
		
		
		return cifrado;
	}
	
	
}
