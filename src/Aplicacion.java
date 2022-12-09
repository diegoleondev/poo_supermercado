public class Aplicacion {

    public static void main(String[] args) throws Exception {

        System.out.println("Panel de Direccion - Bodega Aurrera");
        Supermercado supermercado = new Supermercado("Bodega Aurrera", "Morelia");

        while (true) {
            switch (menu()) {
                case 11:
                    supermercado.mostrarPersonas("Cliente");
                    break;
                case 12:
                    supermercado.capturarPersona("Cliente");
                    break;
                case 13:
                    supermercado.buscarPersona("Cliente");
                    break;
                case 14:
                    supermercado.modificarPersona("Cliente");
                    break;
                case 15:
                    supermercado.eliminarPersona("Cliente");
                    break;
                case 21:
                    supermercado.mostrarPersonas("Empleado");
                    break;
                case 22:
                    supermercado.capturarPersona("Empleado");
                    break;
                case 23:
                    supermercado.buscarPersona("Empleado");
                    break;
                case 24:
                    supermercado.modificarPersona("Empleado");
                    break;
                case 25:
                    supermercado.eliminarPersona("Empleado");
                    break;
                case 31:
                    supermercado.mostrarPersonas("Proveedor");
                    break;
                case 32:
                    supermercado.capturarPersona("Proveedor");
                    break;
                case 33:
                    supermercado.buscarPersona("Proveedor");
                    break;
                case 34:
                    supermercado.modificarPersona("Proveedor");
                    break;
                case 35:
                    supermercado.eliminarPersona("Proveedor");
                    break;
                case 41:
                    supermercado.mostrarProductos();
                    break;
                case 42:
                    supermercado.capturarProducto();
                    break;
                case 43:
                    supermercado.buscarProducto();
                    break;
                case 44:
                    supermercado.modificarProducto();
                    break;
                case 45:
                    supermercado.eliminarProducto();
                    break;
                case 51:
                    supermercado.mostrarVentas();
                    break;
                case 52:
                    supermercado.capturarVenta();
                    break;
                case 53:
                    supermercado.buscarVenta();
                    break;
                case 54:
                    supermercado.modificarVenta();
                    break;
                case 55:
                    supermercado.eliminarVenta();
                    break;
                case 999:
                    supermercado.guardar();
                    return;
            }
        }
    }

    public static int menu() throws Exception {
        Leer leer = new Leer();

        System.out.println("\nMenú Principal");
        System.out.println("1) Cliente 2) Empleado 3) Proveedor 4) Producto 5) Venta 6) Compra 0) Cancelar");
        System.out.print("Opción : ");

        int opccion = (leer.unIntEnRango(6) + 1) * 10;
        if (opccion == 0)
            return 999;

        System.out.println("\nMenú Principal > Submenú");
        System.out.println("1) Mostrar 2) Agregar 3) Buscar 4) Modificar 5) Eliminar 0) Cancelar");
        System.out.print("Acción : ");

        int accion = leer.unIntEnRango(5) + 1;
        if (accion == 0)
            return 888;

        return opccion + accion;
    }
}
