public class Proveedor extends Persona {
  private String rpc;
  private String rfc;
  private Leer leer = new Leer();

  public Proveedor() {
    super();
  }

  @Override
  public void mostrar() {
    super.mostrar();

    System.out.println("RFC : " + rfc);
    System.out.println("RPC : " + rpc);
  }

  @Override
  public boolean buscar(String s) {
    return (rfc + rpc).indexOf(s) != -1
        ? true
        : super.buscar(s);
  }

  @Override
  public void modificar() {
    while (true) {
      System.out.println("\n1) Nombre 2) Género 3) Teléfono 4) Correo");
      System.out.println("5) Dirección 6) RFC 7) RPC 0) Cancelar");
      System.out.print("Indique una opción : ");
      int opcion = leer.unIntEnRango(7) + 1;

      if (opcion == 0)
        return;

      System.out.print("Introduzca el nuevo valor : ");
      switch (opcion) {
        case 1:
          nombre = leer.unString();
          break;
        case 2:
          genero = leer.unChar();
          break;
        case 3:
          telefono = leer.unString();
          break;
        case 4:
          correo = leer.unString();
          break;
        case 5:
          direccion = leer.unString();
          break;
        case 6:
          rfc = leer.unString();
          break;
        case 7:
          rpc = leer.unString();
      }
    }
  }

  @Override
  public void capturar() {
    Leer leer = new Leer();
    super.capturar();

    System.out.print("RFC : ");
    rfc = leer.unString();

    System.out.print("RPC : ");
    rpc = leer.unString();
  }

  public boolean equals(String rfc) {
    return this.rfc.equals(rfc);
  }

  public String toString() {
    return nombre;
  }

  @Override
  public boolean is(String nombre) {
    return "Proveedor".equals(nombre);
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public String getRfc() {
    return rfc;
  }

  public void setRpc(String rpc) {
    this.rpc = rpc;
  }

  public String getRpc() {
    return rpc;
  }
}
