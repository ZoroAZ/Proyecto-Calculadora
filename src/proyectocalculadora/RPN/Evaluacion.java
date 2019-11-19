/*
 * Proyecto Calculadora
 * Hecho por Sebastian Catano, Tom Cruz, Carlos Fuentes y Alexander Roman  * 
 */
package proyectocalculadora.RPN;

import java.util.StringTokenizer;
import proyectocalculadora.pila.Pila;

/**
 *
 * @author
 */
public class Evaluacion {
    
    private final String polinomio;

    public Evaluacion(String polinomio) {
        this.polinomio = polinomio;
    }
    
    public double resolucion(){
        Pila<Double> operandos = new Pila();
        StringTokenizer tokens = new StringTokenizer(polinomio);
        while(tokens.hasMoreTokens()){
            String dato = tokens.nextToken();
            if("+".equals(dato) || "-".equals(dato) || "*".equals(dato) || "/".equals(dato)  || "^".equals(dato)){
                double res = 0.0;
                double op1 = operandos.desapilar();
                double op2 = operandos.desapilar();
                if("+".equals(dato)){
                    res = op2 + op1;
                }else if("-".equals(dato)){
                    res = op2 - op1;
                }else if("*".equals(dato)){
                    res = op2 * op1;
                }else if("/".equals(dato)){
                    res = op2 / op1;
                }else{
                    res = Math.pow(op2, op1);
                }
                operandos.apilar(res);
            }else{
                operandos.apilar(Double.parseDouble(dato));
            }
        }
        return operandos.desapilar();
    }
}
