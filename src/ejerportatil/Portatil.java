package ejerportatil;

public class Portatil {

    static int contador = -1;
    private int identificador;

    private String marca;

    private String modelo;

    private int pantallaTamano;

    private int ram;

    private int capDiscoDuro;

    private char ssd;

    public Portatil(String marca, String modelo) {
        contador++;
        this.identificador = contador;
        this.marca = marca;
        this.modelo = modelo;
        this.ssd='f' ;
    }

    public Portatil(String marca, String modelo, char ssd) {
        contador++;
        this.identificador = contador;
        this.marca = marca;
        this.modelo = modelo;
        this.ssd = ssd;

    }

    public Portatil(String marca, String modelo, int pantallaTamano, int ram, int capDiscoDuro, char ssd) {
        contador++;
        this.identificador = contador;
        this.marca = marca;
        this.modelo = modelo;
        this.pantallaTamano = pantallaTamano;
        this.ram = ram;
        this.capDiscoDuro = capDiscoDuro;
        this.ssd = ssd;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPantallaTamano() {
        return this.pantallaTamano;
    }

    public void setPantallaTamano(int pantallaTamano) {

        this.pantallaTamano = pantallaTamano;
    }

    public int getRam() {
        return this.ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCapDiscoDuro() {
        return this.capDiscoDuro;
    }

    public void setCapDiscoDuro(int capDiscoDuro) {
        this.capDiscoDuro = capDiscoDuro;
    }

    public char getSsd() {
        return this.ssd;
    }

    public void setSsd(char ssd) {
        this.ssd = ssd;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {

        String prueba;

        if (pantallaTamano == 0 && ram == 0 && capDiscoDuro == 0 && ssd=='f'){
            prueba = "Los Portatiles registrados son: " +
                    "Identificador=" + identificador + '\'' +
                    "marca='" + marca + '\'' +
                    ", modelo='" + modelo
            ;
        } else if (pantallaTamano == 0 && ram == 0 && capDiscoDuro == 0) {
            prueba = "Los Portatiles registrados son: " +
                    "Identificador=" + identificador + '\'' +
                    "marca='" + marca + '\'' +
                    ", modelo='" + modelo +
                    ", ssd=" + ssd
                    ;
        } else {
            prueba  ="Los Portatiles registrados son: " +
                    "Identificador=" + identificador + '\'' +
                    "marca='" + marca + '\'' +
                    ", modelo='" + modelo + '\'' +
                    ", pantallaTamano=" + pantallaTamano +
                    ", ram=" + ram +
                    ", capDiscoDuro=" + capDiscoDuro +
                    ", ssd=" + ssd
            ;
        }


        return prueba;
    }

    public static char mostrarPortatiles(Portatil[] portatiles) {
        int i = 0;
        boolean salir = false;
        char opcionUsuario = 's';

        do {
            Portatil x;
            x = portatiles[i];
            if (x == null) {
                System.out.println("no hay datos mas datos que mostrar, Debes crear un portatil");
                opcionUsuario = Main.opcionNuevoRegistroPortatil();
                if (opcionUsuario == 'n') {

                    System.out.println("¿quieres visualizar algun dato?");
                    opcionUsuario = Teclat.llegirChar();
                    if (opcionUsuario == 'n') {
                        System.out.println("Adios");
                    }
                }
                salir = true;
            } else {
                System.out.println(i + "-" + x);
                i++;
            }

        } while (!salir);
        return opcionUsuario;
    }

    public static char mostrarPorIdentificador(Portatil[] portatiles) {


        int identi;
        boolean salir = false;
        char opcionUsuario;

        do {
            System.out.println("Indica el numero de Identificador que quieres buscar");
            identi = Teclat.llegirInt();
            Portatil x;
            x = portatiles[identi];

            if (x == null) {
                System.out.println("No hay Portatiles por ese identificador");
                opcionUsuario = Main.opcionNuevoRegistroPortatil();
                if (opcionUsuario == 'n') {

                    System.out.println("¿quieres visualizar algun dato?");
                    opcionUsuario = Teclat.llegirChar();
                    if (opcionUsuario == 'n') {
                        System.out.println("Adios");
                    }
                }
                salir = true;
            } else {
                System.out.println(x);

                System.out.println("¿Quieres buscar otro portatil?");
                opcionUsuario = Teclat.llegirChar();
                opcionUsuario = Character.toLowerCase(opcionUsuario);

                if (opcionUsuario == 'n') {

                    System.out.println("¿quieres visualizar algun dato?");
                    opcionUsuario = Teclat.llegirChar();
                    if (opcionUsuario == 'n') {
                        System.out.println("Adios");
                        salir=true;
                    }
                }
            }


        }  while (!salir) ;
        return opcionUsuario;
    }
}