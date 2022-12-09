import java.io.Serializable;

public class DetalleVenta implements Serializable {
  private int cantidad;
  private float subtotal;
  private Producto producto;

  Leer leer = new Leer();

  public DetalleVenta(Producto producto) {
    this.producto = new Producto(producto);

    capturar();

    inicializar();
  }

  private void inicializar() {
    subtotal = cantidad * producto.getPrecio();
  }

  public void mostrar() {
    System.out.println("Identificador : " + producto.getIdentificador());
    System.out.println("Nombre : " + producto.getNombre());
    System.out.println("Precio : " + producto.getPrecio());
    System.out.println("Cantidad : " + cantidad);
    System.out.println("Subtotal : " + subtotal);
  }

  public void capturar() {
    System.out.print("Cantidad : ");
    while ((cantidad = leer.unInt()) < 1)
      System.out.print("[~] No puede ser menos de uno, ingrese la cantidad nuevamente: ");

  }

  public String toString() {
    return cantidad + " " + producto.getNombre() + " " + subtotal;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setSubtotal(Float subtotal) {
    this.subtotal = subtotal;
  }

  public Float getSubtotal() {
    return subtotal;
  }

  public void setProducto(Producto producto) {
    this.producto = new Producto(producto);
  }

  public Producto getProducto() {
    return producto;
  }
}
