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
public class Nodo<T>{
    private T info;
    private Nodo<T> siguiente;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }
    
}
