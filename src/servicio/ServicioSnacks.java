package servicio;

import dominio.Snack;
import java.util.List;

public interface ServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List<Snack> getSnacks();
}
