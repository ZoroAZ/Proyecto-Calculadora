/*
 * Proyecto Calculadora
 * Hecho por Sebastian Catano, Tom Cruz, Carlos Fuentes y Alexander Roman  * 
 */
package proyectocalculadora.RPN;

import java.util.StringTokenizer;
import proyectocalculadora.pila.*;
/**
 *
 * @author
 */
public class Conversion {
    
    private final String polinomio;

    public Conversion(String polinomio) {
        this.polinomio = polinomio;
    }
    
    
    public String aPosFija(){
        Pila<String> stack = new Pila();
        String posFija = "";
        boolean primero = true;
        StringTokenizer tokens = new StringTokenizer(polinomio);
        while(tokens.hasMoreTokens()){
            String dato = tokens.nextToken();
            if(primero){
                posFija = dato;
                primero = false;
            }else if("^".equals(dato)){
                stack.apilar(dato);
            }else if("*".equals(dato) || "/".equals(dato)){
                if(!stack.estaVacia()){
                    String cima = stack.getL().getInfo();
                    while(("^".equals(cima) || "*".equals(cima) || "/".equals(cima)) && !stack.estaVacia()){
                        posFija = posFija + " " + stack.desapilar();
                        if(!stack.estaVacia()){
                            cima = stack.getL().getInfo();
                        }
                    }
                }
                stack.apilar(dato);
            }else if("+".equals(dato) || "-".equals(dato)){
                if(!stack.estaVacia()){
                    String cima = stack.getL().getInfo();
                    while(("^".equals(cima) || "*".equals(cima) || "/".equals(cima) || "+".equals(cima) || "-".equals(cima)) && !stack.estaVacia()){
                        posFija = posFija + " " + stack.desapilar();
                        if(!stack.estaVacia()){
                            cima = stack.getL().getInfo();
                        }
                    }
                }
                stack.apilar(dato);
            }else if("(".equals(dato)){
                stack.apilar(dato);
            }else if(")".equals(dato)){
                String cima = stack.getL().getInfo();
                while(!"(".equals(cima)){
                    posFija = posFija + " " + stack.desapilar();
                    cima = stack.getL().getInfo();
                }
                stack.desapilar();
            }else{
                posFija = posFija + " " + dato;
            }
        }
        while(!stack.estaVacia()){
            posFija = posFija + " " + stack.desapilar();
        }
        return posFija;
    }
}
