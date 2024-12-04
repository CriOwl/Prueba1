package CCRusiaSlava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import CCRusiaSlava.AFD.ccAutomata;

public class ccSistema {
    private String[] ccusuario;
    private String ccclave;
    private ccUsuario usuario;
    private File ccarchivo;
    ArrayList<String> coordenas = new ArrayList<String>();

    public ccSistema() {
        setCcusuario(new String[] { "Paccha", "Carrillo" });
        setCcclave("1234");
        usuario = new ccUsuario();
        ccvalidar();
    }

    private void ccvalidar() {
        for (int intentos = 0; intentos < 3; intentos++) {
            usuario.ccingresarCredenciales();
            for (int indice = 0; indice < ccusuario.length; indice++) {
                if (usuario.getCcusuario().equalsIgnoreCase(ccusuario[indice])
                        && usuario.getCcclave().equalsIgnoreCase(ccclave)) {
                    cccoordenadas();
                }
            }
        }
        System.exit(0);
    }

    protected void setCcusuario(String[] ccusuario) {
        if (ccusuario == null || ccusuario.length == 0) {
            ccusuario = new String[] { "Sin_nombre" };
        }
        this.ccusuario = ccusuario;
    }

    protected void setCcclave(String ccclave) {
        if (ccclave == null || ccclave.isEmpty()) {
            ccclave = "S1l4v4Rus14";
        }
        this.ccclave = ccclave;
    }

    private void cccoordenadas() {
        System.out.println("Bienvenido " + usuario.getCcusuario().toUpperCase());
        leer_archivo();
        System.out.println("[+] Informacion");
        System.out.println(
                "* \t Nombre1: Cristhian Carrillo\n* \t Cedula:  1751375963 \n");
        System.out.println("COORDENADAS UCRANIANAS:");
        ccloading();
        System.out.println("\r" + "Loading|" + coordenas.get(0).replace(';', '|'));
        for (int index = 1; index < coordenas.size(); index++) {
            ccloading();
            System.out.println("\r" + "100%    " + coordenas.get(index).replace(';', '|'));
        }
        destruir_Coordenadas();
        System.exit(0);
    }

    private void leer_archivo() {
        ccarchivo = new File("CCArchivos\\Carrillo.csv");
        try {
            Scanner ccleer_archivo = new Scanner(ccarchivo);
            while (ccleer_archivo.hasNextLine()) {
                coordenas.add(ccleer_archivo.nextLine());
            }
            ccleer_archivo.close();

        } catch (IOException error) {
            System.out.println(error);
        }

    }

    private void ccloading() {
        String[] figuras_carga = { "Ooo", "oOo", "ooO", "oOo" };
        for (int carga = 0; carga < 100; carga++) {
            try {
                System.out.print("\r" + figuras_carga[carga % figuras_carga.length] + " " + carga + "%");
                Thread.sleep(50);
                carga++;
            } catch (Exception e) {
            }
        }
    }

    private void destruir_Coordenadas() {
        File coordenas_ucranianas = new File("CCArchivos\\ccCoordenadas_destruidas.csv");
        coordenas_ucranianas.delete();
        try {
            if (coordenas_ucranianas.createNewFile()) {
                FileWriter escritura = new FileWriter(coordenas_ucranianas);
                for (int index = 1; index < coordenas.size(); index++) {
                    if (ccAutomata.validar_palabra(coordenas.get(index).split(";")[6])) {
                        escritura.write(coordenas.get(index) + "\n");
                    }
                }
                escritura.close();
            }
            System.out.println("COORDENADAS UCRANIANAS DESTRUIDAS:");
            Scanner lectura = new Scanner(coordenas_ucranianas);
            while (lectura.hasNextLine()) {
                System.out.println(lectura.nextLine());
            }
            lectura.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
