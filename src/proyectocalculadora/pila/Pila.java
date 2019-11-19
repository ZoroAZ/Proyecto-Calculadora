/*
 * Proyecto Calculadora
 * Hecho por Sebastian Catano, Tom Cruz, Carlos Fuentes y Alexander Roman  * 
 */
package proyectocalculadora.pila;
/**
 *
 * @author 
 * @param <T>
 */
public class Pila<T> {
    private Nodo<T> L;
    
    public Pila(){
        this.L = null;
    }

    public Nodo<T> getL() {
        return L;
    }
    
    public void apilar(T dato){
        Nodo n = new Nodo();
        n.setInfo(dato);
        if(L == null){
            n.setSiguiente(null);
        }else{
            n.setSiguiente(L);
        }
        L = n;
    }
    
    public T desapilar(){
        T dato = L.getInfo();
        L = L.getSiguiente();
        return dato;
    }
    
    public boolean estaVacia(){
        boolean respuesta = false;
        if(L == null){
            respuesta = true;
        }
        return respuesta;
    }
  
}
