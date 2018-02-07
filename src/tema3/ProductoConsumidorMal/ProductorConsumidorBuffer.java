package tema3.ProductoConsumidorMal;

public class ProductorConsumidorBuffer {
    private static final int BUFFER_SIZE = 10;
    private int[] datos = new int[BUFFER_SIZE];
    private int posInser = 0;
    private int posSacar = 0;

    public ProductorConsumidorBuffer() {
        for (int i = 0; i < BUFFER_SIZE; i++) {
            this.datos[i] = -1; //Sólo para mostrar que saca basura
        }
    }

    public void insertar(int dato) {
        datos[posInser] = dato;
        posInser = (posInser + 1) % datos.length;
    }

    public int sacar() {
        int dato = datos[posSacar];
        datos[posSacar] = -1;//Sólo para mostrar que saca basura
        posSacar = (posSacar + 1) % datos.length;
        return dato;
    }
}
