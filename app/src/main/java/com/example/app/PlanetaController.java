package com.example.app;

import java.util.ArrayList;

public class PlanetaController {

    PlanetaDAO dao;

    public PlanetaController(){
        dao = new PlanetaDAO();
    }

    public void addPlaneta(Planeta planeta){

    }

    public ArrayList<Planeta> getPlaneta(){
        return dao.getPlanetas();
    }

    public ArrayList<String> getNomePlaneta(){
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta planeta : dao.getPlanetas()){
            nomes.add(planeta.nome);
        }
        return nomes;
    }
}
