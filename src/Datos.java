public class Datos {
  public Datos() {
  }

  public String[] getCategorias() {
    String[] categorias = {
        "Pantallas, Audio e Instrumentos Musicales", "Hogar y Ferretería", "Farmacia y Cuidado de la Salud",
        "Ropa, Zapatos y Accesorio",
    };
    return categorias;
  }

  public Persona[] getPersonas() {
    Persona[] personas = {
        new Cliente("Diego Leon", "DILE678436", 'M', "445 379 4683", "di.le@gmail.com", "Av. Del Monte #1257"),
        new Cliente("Brayan Diaz", "BRDI7135843", 'M', "446 876 2489", "br.di@gmail.com", "Av. El Volvan #56A"),
        new Cliente("Angel Anincera", "ANNI5341284", 'M', "444 579 6517", "an.an@gmail.com", "Av. La Cascada #436B"),
        new Empleado("Miguel Angel", "MIAN463784", 'M', "443 446 7689", "mi.an@gmail.com", "Av. El Sol", "03/04/2013",
            "08/06/1998", "70456725", "Hermano 442 242 2356", "Caja", "Cajero", 4800.00f),
        new Empleado("Maria Gomez", "MAGO472193", 'F', "445 505 7685", "ma.go@gmail.com", "Av. Miguel Hidalgo",
            "05/03/2009", "06/09/1998", "64574831", "Hermano Saul 446 8793 5679", "Caja", "jefa", 5000.60f),
        new Empleado("Juan Perez", "JUPR472193", 'M', "445 505 7685", "ju.pz@gmail.com", "Av. La Loma", "05/03/2009",
            "06/09/1998", "64574831", "Hermano Saul 446 459 5779", "Caja", "cajero", 4800.00f),
        new Proveedor("Jose Juan", "JOJU", 'M', "445 6489 3246", "jo.ju@gmail.com", "Av. Calsada",
            "Fomento Económico Mexicano S.A.B. de C.V.,", "Femsa")
    };
    return personas;
  }

  public Producto[] getProductos() {
    Producto[] productos = {
        null
    };

    return productos;
  }
}

/*
 * 
 * Datos data = new Datos();
 * String[] folio = { "0" };
 * 
 * Archivo archivo = new Archivo();
 * archivo.setCadenas(folio, "./db/folioCompra.ponyfile");
 * archivo.setCadenas(folio, "./db/folioVenta.ponyfile");
 * archivo.setCadenas(data.getCategorias(), "./db/categorias.ponyfile");
 * archivo.setObjetos(data.getPersonas(), "./db/personas.ponyfile");
 * archivo.setObjetos(data.getProductos(), "./db/productos.ponyfile");
 */
/*
 * new Producto("Lavadora Samsung A678", "Secado rapido",
 * "Electrodomésticos y Línea Blanca", 5000.00f, 10),
 * new Producto("Lavadora LG A68+", "Secado rapido",
 * "Electrodomésticos y Línea Blanca", 5000.00f, 10),
 * new Producto("Samsung Galaxy S10", "8GB de RAM",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("Samsung Galaxy S9", "7GB de RAM",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("Samsung Galaxy S8", "6GB de RAM",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("Samsung Galaxy S7", "5GB de RAM",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("LG G12", "14 mega pixeles",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("LG G11", "13 mega pixeles",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("LG G10", "12 mega pixeles",
 * "Celulares, Cámaras y Casa Inteligente", 5000.00f, 10),
 * new Producto("Samsung T56", "80\"",
 * "Pantallas, Audio e Instrumentos Musicales", 5000.00f, 10),
 * new Producto("Samsung T55", "70\"",
 * "Pantallas, Audio e Instrumentos Musicales", 5000.00f, 10),
 * new Producto("Samsung T54", "50\"",
 * "Pantallas, Audio e Instrumentos Musicales", 5000.00f, 10),
 * new Producto("Samsung T53", "60\"",
 * "Pantallas, Audio e Instrumentos Musicales", 5000.00f, 10),
 * new Producto("LG C75", "100\"", "Pantallas, Audio e Instrumentos Musicales",
 * 5000.00f, 10),
 * new Producto("LG C74", "90\"", "Pantallas, Audio e Instrumentos Musicales",
 * 5000.00f, 10),
 * new Producto("LG C73", "80\"", "Pantallas, Audio e Instrumentos Musicales",
 * 5000.00f, 10),
 * new Producto("LG C72", "70\"", "Pantallas, Audio e Instrumentos Musicales",
 * 5000.00f, 10),
 * new Producto("Cama King Size", "Cama King Size comoda y confortable",
 * "Hogar y Ferretería", 5000.00f, 10),
 * new Producto("Comedor MOKK", "Comedor de 6 sillas", "Hogar y Ferretería",
 * 5000.00f, 10),
 * new Producto("Comedor MOKK", "Comedor de 4 sillas", "Hogar y Ferretería",
 * 5000.00f, 10),
 * new Producto("Sillon Kubik", "Sillon de 3 piezas", "Hogar y Ferretería",
 * 5000.00f, 10),
 * new Producto("Maceta", "Maceta de 1 pieza", "Hogar y Ferretería", 5000.00f,
 * 10),
 */