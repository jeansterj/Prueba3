package ejerportatil;

public class Main {

    public static void main(String[] args) {
        int opcion, opcionCreacion, limite=0,opcionVisualizacionDatos;
        boolean salir=false, salirCreacion=false, salirVisualizarDatos=false;
        char visualizarDatos;

        Portatil[] portatiles = new  Portatil[5];

        //mensaje de bienvenida

        mensajeBienvenida();

        //menu de opciones a realizar



       do {
           opcion=menuDeOpciones();
           switch (opcion){

               case 1:
                   //opcion 1 crean un portatil nuevo
                   //menu opciones de creacion

                   do {
                       opcionCreacion = menuDeOpcionesCreacion();
                       switch (opcionCreacion) {
                           case 1 -> {  // Crear solo con indicando marca y modelo
                               limite = creacion2Atributos(portatiles, limite);
                               salirCreacion = true;
                           }
                           case 2 -> {  // Crear solo con indicando marca, modelo y si tiene SSD
                               limite = creacion3Atributos(portatiles, limite);
                               salirCreacion = true;
                           }
                           case 3 -> {  // Crear indicando todos los datos
                               limite = creacionConTodosLosAtributos(portatiles, limite);
                               salirCreacion = true;
                           }
                           case 4 -> //Regresar al menu anterior
                                   salirCreacion = true;
                       }

                   } while (!salirCreacion);
                   break;
               case 2:
                   //opcion 2 mostrar los datatos del portatil
                   do {
                   opcionVisualizacionDatos = menuDeOpcionesVisualizacion();
                       switch (opcionVisualizacionDatos) {
                           case 1 -> {
                               visualizarDatos = Portatil.mostrarPortatiles(portatiles);
                               salirVisualizarDatos = true;
                               if (visualizarDatos == 'n') {
                                   salir = true;
                               }
                           }
                           case 2 -> {
                               visualizarDatos = Portatil.mostrarPorIdentificador(portatiles);
                               salirVisualizarDatos = true;
                               if (visualizarDatos == 'n') {
                                   salir = true;
                               }
                           }
                           case 3 -> salirVisualizarDatos = true;
                       }
                   } while (!salirVisualizarDatos);

                   break;
               case 3:   //opcion 4 salir
                   salir = true;
                   break;

           }
       } while (!salir);

    }

    private static int menuDeOpcionesVisualizacion() {

        int opcionVisualizacion;

        System.out.println("----------Menu de Visualizacion---------");
        System.out.println("1- Visualizar todos los datos");
        System.out.println("2- Visulizar un portatil por identificador");
        System.out.println("3- Regresar");
        opcionVisualizacion= Teclat.llegirInt();
        return opcionVisualizacion;


    }
    private static int creacionConTodosLosAtributos(Portatil[] portatiles, int limite) {

        String marca,modelo;
        int pantallaTamano,ram,capDiscoDuro;
        char eleccionUsuario,ssd;
        boolean salir;

        do {
            salir = false;


            System.out.println("Introduce una marca");
            marca = Teclat.llegirString();

            System.out.println("Introduce un modelo");
            modelo = Teclat.llegirString();

            System.out.println("Introduce el Tamaño de la Pantalla");
            pantallaTamano = Teclat.llegirInt();

            System.out.println("Introduce la capacidad de Ram");
            ram= Teclat.llegirInt();

            System.out.println("Introduce la Capacidad del Disco Duro");
            capDiscoDuro = Teclat.llegirInt();

            System.out.println("¿El portatil dispone de SSD?");
            ssd = Teclat.llegirChar();


            portatiles[limite] = new Portatil(marca, modelo,pantallaTamano,ram,capDiscoDuro,ssd);

            eleccionUsuario=opcionNuevoRegistroPortatil();

            if (eleccionUsuario == 'n') {
                salir = true;
            }

            if (limite == 5) {
                salir = true;
            }
            limite++;


        }while (!salir && limite < portatiles.length);
        return limite;
    }
    private static int creacion3Atributos(Portatil[] portatiles, int limite) {

        String marca,modelo;
        char eleccionUsuario,ssd;
        boolean salir;


        do {
            salir = false;

            System.out.println("Introduce una marca");
            marca = Teclat.llegirString();

            System.out.println("Introduce un modelo");
            modelo = Teclat.llegirString();

            System.out.println("¿El portatil dispone de SSD?");
            ssd = Teclat.llegirChar();


            portatiles[limite] = new Portatil( marca, modelo,ssd);

            eleccionUsuario=opcionNuevoRegistroPortatil();

            if (eleccionUsuario == 'n') {
                salir = true;
            }

            if (limite == 5) {
                salir = true;
            }
            limite++;

        }while (!salir && limite < portatiles.length);

        return limite;

    }
    public static char opcionNuevoRegistroPortatil() {
        char eleccionUsuario;
        System.out.println("¿Quieres introducir un portatil?");
        eleccionUsuario = Teclat.llegirChar();
        eleccionUsuario = Character.toLowerCase(eleccionUsuario);

        return eleccionUsuario;
    }
    private static int creacion2Atributos(Portatil[] portatiles, int limite) {

        String marca,modelo;
        char eleccionUsuario;
        boolean salir;


            do {
                salir = false;


                System.out.println("Introduce una marca");
                marca = Teclat.llegirString();

                System.out.println("Introduce un modelo");
                modelo = Teclat.llegirString();

                portatiles[limite] = new Portatil(marca, modelo);

                eleccionUsuario=opcionNuevoRegistroPortatil();


                if (eleccionUsuario == 'n') {
                    salir = true;
                }

                if (limite == 5) {
                    salir = true;
                }

                limite++;

            }while (!salir && limite < portatiles.length);

        return limite;
    }
    private static int menuDeOpcionesCreacion() {
        int opcionCreacion;

        System.out.println("----------Menu de Creacion de Portatil---------");
        System.out.println("1- Crear solo con indicando marca y modelo");
        System.out.println("2- Crear solo con indicando marca, modelo y si tiene SSD");
        System.out.println("3- Crear indicando todos los datos");
        System.out.println("4- Regresar");
        opcionCreacion= Teclat.llegirInt();
        return opcionCreacion;


    }
    public static void mensajeBienvenida() {

            System.out.println("Bienvenido al almacen de portatiles, selecciona la opcion de lo que desees realizar");

    }
    public static int menuDeOpciones(){
        int opcion;

            System.out.println("----------Menu Opciones---------");
            System.out.println("1- Crear Portatil");
            System.out.println("2- Vizualizar datos de portatiles");
            System.out.println("3- Salir");
            opcion= Teclat.llegirInt();
        return opcion;
        }

}