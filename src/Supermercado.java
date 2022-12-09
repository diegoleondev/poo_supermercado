import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
  private String nombre;
  private String direccion;

  private Persona[] personas = new Persona[500];
  private int cPersonas = 0;
  private Producto[] productos = new Producto[500];
  private int cProductos = 0;
  private Venta[] ventas = new Venta[500];
  private int cVentas = 0;

  Leer leer = new Leer();
  Archivo archivo = new Archivo();

  public Supermercado(String nombre, String direccion) {
    this.nombre = nombre;
    this.direccion = direccion;

    inicializar();
  }

  public void inicializar() {
    cargar();
  }

  private Persona[] filtrarPersonas(String filter) {
    List<Persona> acomulador = new ArrayList<Persona>();
    for (Persona persona : personas) {
      if (persona == null)
        break;
      if (!persona.is(filter))
        continue;
      if (persona.isEliminada())
        continue;

      acomulador.add(persona);
    }

    Persona[] filtradas = new Persona[acomulador.size()];
    acomulador.toArray(filtradas);

    return filtradas;
  }

  private Persona seleccionarPersona(String filtro) {
    Persona[] personasFiltradas = filtrarPersonas(filtro);

    int contador = 1;
    for (Persona persona : filtrarPersonas(filtro)) {
      System.out.println((contador++) + ".- " + persona.toString());
    }
    System.out.println("0.- No seleccionar " + filtro);
    System.out.println("");
    System.out.print("Indique el " + filtro + " : ");

    int valor = leer.unIntEnRango(personasFiltradas.length);

    if (valor == -1)
      return null;

    return personasFiltradas[valor];
  }

  public void mostrarPersonas(String tipo) {
    System.out.println("\nMenú Principal > Submenú > Mostrar " + tipo + "(s)");
    for (Persona persona : filtrarPersonas(tipo)) {
      System.out.println("");
      persona.mostrar();
    }
  }

  public void capturarPersona(String tipo) {
    System.out.println("\nMenú Principal > Submenú > Agregar " + tipo);
    switch (tipo) {
      case "Cliente":
        personas[cPersonas++] = new Cliente();
        break;
      case "Empleado":
        personas[cPersonas++] = new Empleado();
        break;
      case "Proveedor":
        personas[cPersonas] = new Proveedor();
        break;
    }
  }

  public void buscarPersona(String tipo) {
    System.out.println("\nMenú Principal > Submenú > Buscar " + tipo);
    System.out.print("Ingrese valor a buscar : ");
    String valor = leer.unString();

    for (Persona persona : filtrarPersonas(tipo)) {
      if (!persona.buscar(valor))
        continue;

      System.out.println("");
      persona.mostrar();
    }
  }

  public void modificarPersona(String tipo) {
    System.out.println("\nMenú Principal > Submenú > Modificar " + tipo);

    Persona persona = seleccionarPersona(tipo);

    if (persona == null)
      return;

    persona.modificar();
  }

  public void eliminarPersona(String tipo) {
    System.out.println("\nMenú Principal > Submenú > Eliminar " + tipo);

    Persona persona = seleccionarPersona(tipo);

    if (persona == null)
      return;

    persona.eliminar();
  }

  private String[] getCategorias() {
    try {
      List<String> bufferList = new ArrayList<String>();

      FileReader fileTarget = new FileReader("./db/categorias.ponyfile");
      BufferedReader bReader = new BufferedReader(fileTarget);

      String linea;

      while ((linea = bReader.readLine()) != null)
        bufferList.add(linea);
      bReader.close();

      String[] bufferArray = new String[bufferList.size()];
      bufferList.toArray(bufferArray);

      return bufferArray;
    } catch (FileNotFoundException e) {
      System.out.println("¡El fichero no existe!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return null;
  }

  private String seleccionarCategoria() {
    String[] CATEGORIAS = getCategorias();

    System.out.println("\nCategorías : ");
    int i = 1;
    for (String cat : CATEGORIAS) {
      System.out.print((i++) + ") " + cat + " ");
      if (i % 4 == 0)
        System.out.println("");
    }
    System.out.print("\nIndique la Categoría: ");
    int valor;

    while ((valor = leer.unIntEnRango(CATEGORIAS.length)) == -1) {
      System.out.print("No puede dejar este campo vacío, vuelva a seleccionar : ");
    }

    return CATEGORIAS[valor];
  }

  private Producto[] getProductosValidos() {
    List<Producto> lista = new ArrayList<Producto>();

    for (Producto producto : productos) {
      if (producto == null)
        break;
      if (producto.isEliminada())
        continue;

      lista.add(producto);
    }

    Producto[] filtrados = new Producto[lista.size()];
    lista.toArray(filtrados);

    return filtrados;
  }

  private Producto[] getProductosFiltradosPorCategoria() {
    List<Producto> listaFiltrados = new ArrayList<Producto>();

    String categoria = seleccionarCategoria();

    for (Producto producto : getProductosValidos()) {
      if (!producto.buscar(categoria))
        continue;
      listaFiltrados.add(producto);
    }

    Producto[] AregloFiltrados = new Producto[listaFiltrados.size()];
    listaFiltrados.toArray(AregloFiltrados);

    return AregloFiltrados;
  }

  private Producto[] getProductosFiltradosPorMenu() {
    System.out.println("\n¿Cómo quieres listar los productos? ");
    System.out.println("1) Todos los productos. ");
    System.out.println("2) Productos de una Categoría. ");
    System.out.println("0) Cancelar.");
    System.out.print("Opccion: ");
    int opccionListado = leer.unIntEnRango(2);

    if (opccionListado == -1)
      return null;

    return opccionListado == 0 ? getProductosValidos() : getProductosFiltradosPorCategoria();

  }

  private Producto seleccionarProducto() {
    Producto[] productosFiltrados = getProductosFiltradosPorMenu();

    if (productosFiltrados == null)
      return null;

    int i = 1;
    System.out.println("\nProductos: ");
    for (Producto producto : productosFiltrados)
      System.out.println((i++) + ".- " + producto.toString());
    System.out.println("0.- Cancelar");

    System.out.print("Seleccione un producto : ");
    int valor = leer.unIntEnRango(productosFiltrados.length);

    if (valor == -1)
      return null;

    return productosFiltrados[valor];
  }

  public void mostrarProductos() {
    System.out.println("\nMenú Principal > Submenú > Mostrar Producto(s)");
    Producto[] productosFiltrados = getProductosFiltradosPorMenu();

    if (productosFiltrados == null) {
      System.out.println("[~] No hay nada que mostrar. ");
      return;
    }

    for (Producto producto : productosFiltrados) {
      System.out.println("");
      producto.mostrar();
    }
  }

  public void capturarProducto() {
    System.out.println("\nMenú Principal > Submenú > Agregar Producto");
    productos[cProductos++] = new Producto();
  }

  public void buscarProducto() {
    System.out.println("\nMenú Principal > Submenú > Buscar Producto");
    System.out.print("Ingrese valor a buscar : ");
    String valor = leer.unString();

    for (Producto producto : getProductosValidos()) {
      if (!producto.buscar(valor))
        continue;

      System.out.println("");
      producto.mostrar();
    }
  }

  public void modificarProducto() {
    Producto producto = seleccionarProducto();

    if (producto == null)
      return;

    producto.modificar();
  }

  public void eliminarProducto() {
    Producto producto = seleccionarProducto();

    if (producto == null)
      return;

    producto.eliminar();
  }

  private Venta[] getVentasValidas() {
    List<Venta> ventasFiltradas = new ArrayList<Venta>();

    for (Venta venta : ventas) {
      if (venta == null)
        break;
      if (venta.isEliminada())
        continue;

      ventasFiltradas.add(venta);
    }
    Venta[] arreglo = new Venta[ventasFiltradas.size()];

    ventasFiltradas.toArray(arreglo);

    return arreglo;
  }

  public void mostrarVentas() {
    for (Venta venta : getVentasValidas()) {
      System.out.println("");
      venta.mostrar();
    }
  }

  public void capturarVenta() {
    List<DetalleVenta> carrito = new ArrayList<DetalleVenta>();
    System.out.println("\nSeleccionar Cajero (necesario):");
    Empleado empleado = (Empleado) seleccionarPersona("Empleado");

    if (empleado == null) {
      System.out.println("[~] Saliendo.");
      return;
    }

    System.out.println("\nSeleccionar Cliente (opcional): ");
    Cliente cliente = (Cliente) seleccionarPersona("Cliente");

    System.out.print("\nSeleccionar productos (uno necesario):");
    Producto producto;

    do {

      while ((producto = seleccionarProducto()) != null) {
        DetalleVenta detalleVenta = new DetalleVenta(producto);

        carrito.add(detalleVenta);
      }

      if (carrito.size() != 0)
        break;

      System.err.println("[~] Este campo no puede estar vacío.");
    } while (true);

    System.out.println("");
    ventas[cVentas++] = new Venta(empleado, cliente, carrito);

  }

  public void buscarVenta() {
    System.out.println("\nMenú Principal > Submenú > Buscar Producto");
    System.out.print("Ingrese valor a buscar : ");
    String valor = leer.unString();

    for (Venta venta : getVentasValidas()) {
      if (!venta.buscar(valor))
        continue;

      System.out.println("");
      venta.mostrar();
    }
  }

  public void modificarVenta() {
    System.out.println("EN DESAROLLO");
  }

  public void eliminarVenta() {
    Venta[] ventasFiltradas = getVentasValidas();

    int i = 1;
    System.out.println("");
    for (Venta venta : ventasFiltradas) {
      System.out.println((i++) + ") " + venta.toString());
    }
    System.out.println("0.- Cancelar");

    System.out.print("Seleccione un producto : ");
    int valor = leer.unIntEnRango(ventasFiltradas.length);

    if (valor == -1)
      return;

    ventasFiltradas[valor].eliminar();
  }

  private Persona[] filtrarPersonas() {
    List<Persona> lista = new ArrayList<Persona>();

    for (Persona persona : personas) {
      if (persona == null)
        break;
      if (persona.isEliminada())
        continue;
      lista.add(persona);
    }

    Persona[] arreglo = new Persona[lista.size()];

    lista.toArray(arreglo);

    return arreglo;
  }

  public void guardar() {
    archivo.setObjetos(filtrarPersonas(), "./db/personas.ponyfile");
    archivo.setObjetos(getProductosValidos(), "./db/productos.ponyfile");
    archivo.setObjetos(getVentasValidas(), "./db/ventas.ponyfile");

    System.out.println("Información guardada");
  }

  private void cargar() {
    for (Object obj : archivo.getObjetos("./db/personas.ponyfile"))
      personas[cPersonas++] = (Persona) obj;
    for (Object obj : archivo.getObjetos("./db/productos.ponyfile"))
      productos[cProductos++] = (Producto) obj;
    for (Object obj : archivo.getObjetos("./db/ventas.ponyfile"))
      ventas[cVentas++] = (Venta) obj;
  }
}
