
package Entidades;


public class tipohabitacion {
    
    private String categoria;
    private int camassimples;
    private int camasdobles;

    public tipohabitacion(String categoria, int camassimples, int camasdobles) {
        this.categoria = categoria;
        this.camassimples = camassimples;
        this.camasdobles = camasdobles;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCamassimples() {
        return camassimples;
    }

    public void setCamassimples(int camassimples) {
        this.camassimples = camassimples;
    }

    public int getCamasdobles() {
        return camasdobles;
    }

    public void setCamasdobles(int camasdobles) {
        this.camasdobles = camasdobles;
    }

    
    
    
    
    
    
    
}
