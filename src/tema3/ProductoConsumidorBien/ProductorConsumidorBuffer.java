package tema3.ProductoConsumidorBien;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ProductorConsumidorBuffer {
	private static final int BUFFER_SIZE = 10;
	private int[] datos = new int[BUFFER_SIZE];
	private int posInser = 0;
	private int posSacar = 0;
	private static Semaphore nHuecos;
	private static Semaphore nProductos;
	private static Semaphore excMutPosInser;
	private static Semaphore excMutPosSacar;

	public ProductorConsumidorBuffer() {
		this.datos = new int[BUFFER_SIZE];
		Arrays.fill(datos, -1);
		nHuecos = new Semaphore(BUFFER_SIZE);
		nProductos = new Semaphore(0);
		excMutPosInser = new Semaphore(1);
		excMutPosSacar = new Semaphore(1);
	}

	public void insertar(int dato) throws InterruptedException {
		nHuecos.acquire();
		excMutPosInser.acquire();
		datos[posInser] = dato;
		posInser = (posInser + 1) % datos.length;
		excMutPosInser.release();
		nProductos.release();
	}

	public int sacar() throws InterruptedException {
		nProductos.acquire();
		excMutPosSacar.acquire();
		int dato = datos[posSacar];
		datos[posSacar] = -1;// Sólo para mostrar que saca basura
		posSacar = (posSacar + 1) % datos.length;
		excMutPosSacar.release();
		nHuecos.release();
		return dato;
	}
}
