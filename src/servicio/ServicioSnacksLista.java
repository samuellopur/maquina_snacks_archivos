package servicio;

import dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements ServicioSnacks{
    private static final List<Snack> snacks;

//    Bloque static inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70.0));
        snacks.add(new Snack("Refresco", 50.0));
        snacks.add(new Snack("Queso", 120.0));
    }

    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
            System.out.println("""
                    -------------------------------
                    --- Snacks en el Inventario ---
                    -------------------------------""");
            System.out.println(inventarioSnacks);
        }
    }

    public List<Snack> getSnacks(){
        return snacks;
    }
}
