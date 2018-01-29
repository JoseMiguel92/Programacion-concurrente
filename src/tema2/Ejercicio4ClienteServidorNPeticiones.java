package tema2;

import java.time.Clock;
import java.util.Random;

public class Ejercicio4ClienteServidorNPeticiones {
    private static final int N = 5;
    private static volatile boolean hayPeticion;
    private static volatile boolean hayRespuesta;
    private static volatile double recurso;

    public static void cliente() {
        new Thread(() -> {
            for (int i = 0; i < N; i++) {
                System.out.println("Soy el cliente: Hago peticion");
                hayPeticion = true;
                while (!hayRespuesta) {
                }
                System.out.println("Numero obtenido del servidor: " + recurso);
                hayRespuesta = false;
            }
        }, "Cliente").start();
    }

    public static void servidor() {
        new Thread(() -> {
            for (int i = 0; i < N; i++) {
                while (!hayPeticion) {
                }
                System.out.println("Soy el servidor: Hay peticion");
                System.out.println("Soy el servidor: Mandando el numero...");
                recurso = new Random().nextDouble();
                hayRespuesta = true;
                hayPeticion = false;
            }
        }, "Servidor").start();
    }

    public static void main(String[] args) {
        hayPeticion = false;
        hayRespuesta = false;
        cliente();
        servidor();
    }
}