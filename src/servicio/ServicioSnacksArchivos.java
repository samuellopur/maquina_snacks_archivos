package servicio;

import dominio.Snack;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements ServicioSnacks{
    private final String NOMBRE_ARCHIVO = "snacks.txt";

//    Crear la lista de snacks
    private List<Snack> snacks = new ArrayList<>();

//    Constructor de clase
    public ServicioSnacksArchivos(){
//        Se crea el archivo sino existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe){
                //this.snacks = obtenerSnacks();
            }
            else {
//                Se crea el archivo sino existe
                var salida = new PrintWriter(new PrintWriter(archivo));
//                Guarda el archivo en disco
                salida.close();
                System.out.println("Se creo el archivo");
            }
        }catch (Exception e){
            System.out.println("Error al crear archivo: " + e.getMessage());
        }

//        Si el archivo es nuevo, se carga algunos snacks
        if (!existe)
            cargarSnacksIniciales();
    }

    @Override
    public void agregarSnack(Snack snack) {

    }

    @Override
    public void mostrarSnacks() {

    }

    @Override
    public List<Snack> getSnacks() {
        return null;
    }
}
