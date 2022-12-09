public class Cliente extends Persona {
  private String identificador;
  private int puntos;
  private Leer leer = new Leer();
  private Id id = new Id();

  public Cliente() {
    super();
    inicializar();
  }

  public Cliente(Persona p) {
    super(p);

    inicializar();
  }

  private void inicializar() {
    identificador = id.alfanumerico();
    puntos = 0;
  }

  @Override
  public void mostrar() {
    super.mostrar();

    System.out.println("Puntos : " + puntos);
    System.out.println("Identificador : " + identificador);
  }

  @Override
  public boolean buscar(String s) {
    return (puntos + identificador).indexOf(s) != -1
        ? true
        : super.buscar(s);
  }

  @Override
  public void modificar() {
    while (true) {
      System.out.println("\n1) Nombre 2) Género 3) Teléfono 4) Correo");
      System.out.println("5) Dirección 6) Puntos 0) Cancelar");
      System.out.print("Indique una opción : ");
      int opcion = leer.unIntEnRango(6) + 1;

      if (opcion == 0)
        return;

      System.out.print("Introduzca el nuevo valor : ");
      leer.unString();
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
          correo = leer.toString();
          break;
        case 5:
          direccion = leer.toString();
          break;
        case 6:
          puntos = leer.unInt();
          break;
      }
    }
  }

  @Override
  public void capturar() {
    super.capturar();
  }

  public boolean equals(String identificador) {
    return this.identificador.equals(identificador);
  }

  public String toString() {
    return nombre;
  }

  @Override
  public boolean is(String nombre) {
    return "Cliente".equals(nombre);
  }

  public void setPuntos(int puntos) {
    this.puntos = puntos;
  }

  public int getPuntos() {
    return puntos;
  }

}