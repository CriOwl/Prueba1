package CCRusiaSlava.AFD;


public  class  ccAutomata {
    private static int e = -1, d = 25;
    private static final int[][] matriz_transicion = {
            // a b c d t -
            { 1, e, e, e, e, e },
            { e, 2, e, e, e, e },
            { e, e, 3, e, e, e },
            { e, e, e, 4, e, d },
            { e, e, e, e, 5, e },
            { e, e, e, e, 5, d },};
    private static final String alfabeto = "abcdt-";
    public ccAutomata(){
        
    }
    public static boolean validar_palabra(String palabra){
        int estado=0;
        palabra=palabra+"-";
        palabra.toCharArray();
        for (int filas = 0; filas < palabra.length(); filas++) {
            for (int columnas = 0; columnas < alfabeto.length(); columnas++) {
                if(palabra.toCharArray()[filas]==(alfabeto.toCharArray()[columnas])){
                    estado=matriz_transicion[estado][columnas];
                }
                if(estado==-1){
                    return false;
                }
            }
        }
        return true;
    }
}
