package com.example.xportacus;

public class RutinasModel {
    String rutinas_nombres;
    String descrip_rutinas;
    int image;
    int video;

    public RutinasModel(String titulos_de_video, String descrip_rutinas, int image, int video) {
        this.rutinas_nombres = titulos_de_video;
        this.descrip_rutinas = descrip_rutinas;
        this.image = image;
        this.video = video;
    }

    public String getTitulos_de_video() {
        return rutinas_nombres;
    }

    public String getDescrip_rutinas() {
        return descrip_rutinas;
    }

    public int getImage() {
        return image;
    }

    public int getVideo() {return  video;}
}
