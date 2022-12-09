public class Empleado extends Persona {
  private String rfc;
  private String fechaAdmicion;
  private String fechaNacimiento;
  private String nSeguroSocial;
  private String personaContacto;
  private String departamento;
  private String posicion;
  private int salario;
  private Leer leer = new Leer();

  public Empleado() {
    super();
  };

  public Empleado(Persona persona, String rfc, String fechaAdmicion, String fechaNacimiento, String nSeguroSocial,
      String personaContacto, String departamento, String posicion, int salario) {
    super(persona);

    this.rfc = rfc;
    this.fechaAdmicion = fechaAdmicion;
    this.fechaNacimiento = fechaNacimiento;
    this.nSeguroSocial = nSeguroSocial;
    this.personaContacto = personaContacto;
    this.departamento = departamento;
    this.posicion = posicion;
    this.salario = salario;
  }

  @Override
  public void mostrar() {
    super.mostrar();

    System.out.println("RFC : " + rfc);
    System.out.println("Fecha de admision : " + fechaAdmicion);
    System.out.println("Fecha de nacimiento : " + fechaNacimiento);
    System.out.println("Número de seguro social : " + nSeguroSocial);
    System.out.println("Persona de contacto : " + personaContacto);
    System.out.println("Departamento : " + departamento);
    System.out.println("Posición : " + posicion);
    System.out.println("Salario : " + salario);
  }

  @Override
  public boolean buscar(String s) {
    return (rfc
        + fechaAdmicion
        + fechaNacimiento
        + nSeguroSocial
        + personaContacto
        + departamento
        + posicion
        + salario).indexOf(s) != -1
            ? true
            : super.buscar(s);
  }

  @Override
  public void modificar() {
    while (true) {
      System.out.println("\n1) Nombre 2) Género 3) Teléfono 4) Correo");
      System.out.println("5) Dirección 6) RFC 7) Fecha de admision 8) Fecha de nacimiento ");
      System.out.println("9) Número de seguro social 10) Persona de contacto");
      System.out.println("11) Departamento 12) Posición 13) Salario 0) Cancelar");
      System.out.print("Indique una opción : ");
      int opcion = leer.unIntEnRango(11) + 1;

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
          fechaAdmicion = leer.unString();
          break;
        case 8:
          fechaNacimiento = leer.unString();
          break;
        case 9:
          nSeguroSocial = leer.unString();
          break;
        case 10:
          personaContacto = leer.unString();
          break;
        case 11:
          departamento = leer.unString();
          break;
        case 12:
          posicion = leer.unString();
          break;
        case 13:
          salario = leer.unInt();
          break;
      }
    }
  }

  @Override
  public void capturar() {
    Leer leer = new Leer();

    super.capturar();

    System.out.print("RFC : ");
    rfc = leer.unString();

    System.out.print("Fecha de admision : ");
    fechaAdmicion = leer.unString();

    System.out.print("Fecha de nacimiento : ");
    fechaNacimiento = leer.unString();

    System.out.print("Número de seguro social : ");
    nSeguroSocial = leer.unString();

    System.out.print("Persona de contacto : ");
    personaContacto = leer.unString();

    System.out.print("Departamento : ");
    departamento = leer.unString();

    System.out.print("Posición : ");
    posicion = leer.unString();

    System.out.print("Salario : ");
    salario = leer.unInt();
  }

  public boolean equals(String rfc) {
    return this.rfc.equals(rfc);
  }

  public String toString() {
    return nombre;
  }

  @Override
  public boolean is(String nombre) {
    return "Empleado".equals(nombre);
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public String getRfc() {
    return rfc;
  }

  public void setFechaAdmicion(String fechaIngreso) {
    this.fechaAdmicion = fechaIngreso;
  }

  public String getFechaAdmicion() {
    return fechaAdmicion;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setNSeguroSocial(String nSeguroSocial) {
    this.nSeguroSocial = nSeguroSocial;
  }

  public String getNSeguroSocial() {
    return nSeguroSocial;
  }

  public void setPersonaContacto(String personaContacto) {
    this.personaContacto = personaContacto;
  }

  public String getPersonaContacto() {
    return personaContacto;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setPosicion(String cargo) {
    this.posicion = cargo;
  }

  public String getPosicion() {
    return posicion;
  }

  public void setSalario(int sueldo) {
    this.salario = sueldo;
  }

  public int getSalario() {
    return salario;
  }
}
