package ru.gb.software_architecture.homework.sem1.store3D.models;

import java.util.ArrayList;
import java.util.List;

public class PoligonalModel {


    private List<Poligon> poligons;

    private List<Texture> textures;

    public List<Poligon> getPoligons() {
        return poligons;
    }

    public List<Texture> getTextures() {
        return textures;
    }

    public PoligonalModel(List<Poligon> poligons) {
        this.poligons = poligons;
    }

    public PoligonalModel(List<Poligon> poligins, List<Texture> textures) {
        this.poligons = poligins;
        this.textures = textures;
    }
}
