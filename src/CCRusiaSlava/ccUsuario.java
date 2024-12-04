package CCRusiaSlava;

public class ccUsuario {
    private String ccusuario;
    private String ccclave;
    public String getCcusuario() {
        return ccusuario;
    }
    public void setCcusuario(String ccusuario) {
        if(ccusuario.isEmpty()||ccusuario==null){
            ccusuario="Anonimo";
        }
        this.ccusuario = ccusuario;
    }
    public String getCcclave() {
        return ccclave;
    }
    public void setCcclave(String ccclave) {
        if(ccclave.isEmpty()||ccclave==null){
            ccclave=" ";
        }
        this.ccclave = ccclave;
    }
    public void ccingresarCredenciales(){
        System.out.print("Ingrese su usuario: ");
        setCcusuario(ccUtilitario.ccteclado.nextLine());
        System.out.print("\nIngrese su clave: ");
        setCcclave(ccUtilitario.ccteclado.nextLine());
    }

}
