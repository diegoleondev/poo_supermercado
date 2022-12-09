import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Venta implements Acciones, Serializable {
  private String folio;
  private String fecha;
  private String hora;
  private Cliente cliente;
  private Empleado empleado;
  private List<DetalleVenta> detallesVenta;
  private float total;
  private float efectivo;
  private float cambio;
  private boolean eliminada;

  private Leer leer = new Leer();
  private Archivo archivo = new Archivo();

  public Venta(Empleado empleado, Cliente cliente, List<DetalleVenta> detallesVenta) {
    this.empleado = empleado;
    this.cliente = cliente;
    this.detallesVenta = detallesVenta;

    inicializar();
    capturar();
  }

  private void inicializar() {
    Date date = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MMMM-yyyy", new Locale("es_ES"));
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss", new Locale("es_ES"));

    folio = crearFolio();
    fecha = formatoFecha.format(date);
    hora = formatoHora.format(date);
    total = calcularTotal();
    cambio = 0;
  }

  private float calcularTotal() {
    float acomulador = 0;
    for (DetalleVenta dv : detallesVenta) {
      acomulador += dv.getSubtotal();
    }

    return acomulador;
  }

  private String crearFolio() {
    String path = "./db/folio.ponyfile";

    String[] folio = archivo.getCadenas(path);

    int convertirFolio = Integer.parseInt(folio[0]);

    String[] nuevoFolio = { convertirFolio + 1 + "" };

    archivo.setCadenas(nuevoFolio, path);

    return nuevoFolio[0];
  }

  public void mostrar() {
    System.out.println("Folio: " + folio);
    System.out.println("Fecha: " + fecha);
    System.out.println("Hora: " + hora);
    System.out.println("Empleado: " + empleado.toString());
    System.out.println("Cliente: " + (cliente == null ? "No registrado" : cliente.getNombre()));
    System.out.println("Total: " + total);
    System.out.println("Efectivo: " + efectivo);
    System.out.println("Cambio: " + cambio);
    String format = "%-7s | %-15s | %-7s\n";

    System.out.printf(format, "Precio", "Nombre", "Total");
    for (DetalleVenta d : detallesVenta) {
      System.out.printf(format, d.getProducto().getPrecio(), d.getProducto().getNombre(), d.getSubtotal());
    }
  }

  public void capturar() {
    System.out.println("Total a Pagar: " + total);
    System.out.print("Efectivo: ");
    while ((efectivo = leer.unFloat()) < total) {
      System.out.print("Dinero insuficiente: ");
    }

    cambio = efectivo - total;
    System.out.println("Cambio: " + cambio);
  }

  public boolean buscar(String s) {
    return (folio + fecha + hora + total + efectivo + cambio).equals(s)
        ? true
        : cliente.buscar(s)
            ? true
            : empleado.buscar(s)
                ? true
                : false;
  }

  public void eliminar() {
    eliminada = true;
  }

  public String toString() {
    return folio + " " + fecha + " " + hora;
  }

  public void modificar() {
  }

  public boolean isEliminada() {
    return eliminada;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public String getFolio() {
    return folio;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getFecha() {
    return fecha;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public String getHora() {
    return hora;
  }

  public void setcliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
    this.detallesVenta = detallesVenta;
  }

  public List<DetalleVenta> getDetallesVenta() {
    return detallesVenta;
  }

  public void setTotal(float total) {
    this.total = total;
  }

  public float getTotal() {
    return total;
  }

  public void setEfectivo(float efectivo) {
    this.efectivo = efectivo;
  }

  public float getEfectivo() {
    return efectivo;
  }

  public void setCambio(float cambio) {
    this.cambio = cambio;
  }

  public float getCambio() {
    return cambio;
  }
}
