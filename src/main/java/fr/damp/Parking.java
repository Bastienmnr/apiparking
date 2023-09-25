package fr.damp;

import java.util.ArrayList;

public class Parking {
    private int capaciteMaximale;
    private int nbPlacesDisponibles;
    private ArrayList<String> vehiculesAutorises;
    private ArrayList<String> vehiculesStationnes;

    public Parking(int capacite) {
        this.capaciteMaximale = capacite;
        nbPlacesDisponibles = this.capaciteMaximale;

        vehiculesAutorises = new ArrayList<>();
        vehiculesStationnes = new ArrayList<>();

    }

    public int getTailleVehiculesAutorises() {
        return vehiculesAutorises.size();
    }

    public int getTailleNbPlaceDisponible() {
        return nbPlacesDisponibles;
    }

    public int getTailleVehiculesStationnes() {
        return vehiculesStationnes.size();
    }

    public ArrayList<String> getVehiculesAutorises() {
        return vehiculesAutorises;
    }

    public boolean ajouterVehiculeAutorise(String immatriculation) {
        if (!vehiculesAutorises.contains(immatriculation)) {
            vehiculesAutorises.add(immatriculation);
            return true;
        } else {
            return false;
        }

    }

    public boolean enregistrementEntree(String immatriculation) {
        if (vehiculesAutorises.contains(immatriculation) && nbPlacesDisponibles != 0) {
            vehiculesStationnes.add(immatriculation);
            nbPlacesDisponibles = nbPlacesDisponibles - 1;
            return true;
        }
        return false;

    }

    public boolean enregistrementSortie(String immatriculation) {
        if (vehiculesAutorises.contains(immatriculation)) {

            nbPlacesDisponibles = nbPlacesDisponibles + 1;
            return true;
        }
        return false;

    }

    public double getTauxRemplissage() {

        return (double) vehiculesStationnes.size() / capaciteMaximale;
    }

}