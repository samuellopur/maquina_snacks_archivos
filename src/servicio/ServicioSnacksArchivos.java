package servicio;

import dominio.Snack;

import java.io.File;
import java.io.FileWriter;
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

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Papas", 70.0));
        this.agregarSnack(new Snack("Refresco", 50.0));
        this.agregarSnack(new Snack("Sandwich", 120.0));
    }

    @Override
    public void agregarSnack(Snack snack) {
//        Para agregar un nuevo Snack en la lista
//        1. Se guarda en la memoria
        this.snacks.add(snack);
//        2. Se guarda en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
//            Graba información en la memoria
            salida.println(snack);
//            Graba información en el archivo
            salida.close();
        }catch (Exception e){
            System.out.println("Error al agregar snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {

    }

    @Override
    public List<Snack> getSnacks() {
        return null;
    }
}
