package tema2;

import java.util.Random;

public class Ejercicio3ClienteServidor1Peticion {
    static volatile boolean hayPeticion;
    static volatile boolean hayRespuesta;
    static volatile double recurso;

    public static void cliente() {
        new Thread(() -> {
            System.out.println("Soy el cliente: Hago peticion");
            hayPeticion = true;
            while (!hayRespuesta) {
            }
            System.out.println("Numero obtenido del servidor: " + recurso);
            hayRespuesta = false;
        }, "Cliente").start();
    }

    public static void servidor() {
        new Thread(() -> {
            while (!hayPeticion) {
            }
            System.out.println("Soy el servidor: Hay peticion");
            System.out.println("Soy el servidor: Mandando el numero...");
            recurso = new Random().nextDouble();
            hayRespuesta = true;
            hayPeticion = false;
        }, "Servidor").start();
    }

    public static void main(String[] args) {
        hayPeticion = false;
        hayRespuesta = false;
        cliente();
        servidor();
    }
}