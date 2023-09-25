package fr.damp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ParkingTest {

    @Test
    // contexte_methodeSousTest_resultat()
    public void vehiculesAutorisesVide_ajouterVehicukeAutorisé_devraitAjouterLeVehicule() {
        // AAA : Arrange (préparer), Act (agir), Assert (vérifier)

        // Arrange: Je mets en place mo test, notamment un instanciant et initialisant
        // le ou les objets concernés.

        Parking parking = new Parking(0);

        // Act: J'appelle la méthode qui est sous test

        parking.ajouterVehiculeAutorise("ABC-123");

        // Assert : je vérifie que tout s'est passé comme prévu

        assertEquals(1, parking.getTailleVehiculesAutorises(),
                "Je devrais avoir exactement un seul véhicule autorisé.");

        assertEquals("ABC-123", parking.getVehiculesAutorises().get(0), "L'immatriculation n'est pas correcte");

    }

    @Test
    // contexte_methodeSousTest_resultat()
    public void vehiculeAutoriseDansLaListe_AjouterLeMemeVehciuleAutorise_devraitNePasEtreAjoute() {

        Parking parking = new Parking(0);
        parking.ajouterVehiculeAutorise("ABC-123");

        parking.ajouterVehiculeAutorise("ABC-123");

        assertEquals(1, parking.getTailleVehiculesAutorises());

    }

    @Test
    // contexte_methodeSousTest_resultat()
    public void vehiculePasDansLaListe_AjouterUnVehiculeNouveau_devraitAjouterLeVehiculeDansLaListeDesVehiculesAutorises() {
        // AAA : Arrange (préparer), Act (agir), Assert (vérifier)

        // Arrange: Je mets en place mo test, notamment un instanciant et initialisant
        // le ou les objets concernés.

        Parking parking = new Parking(0);
        parking.ajouterVehiculeAutorise("ABC-123");

        // Act: J'appelle la méthode qui est sous test

        parking.ajouterVehiculeAutorise("ABC-124");

        // Assert : je vérifie que tout s'est passé comme prévu

        assertEquals(2, parking.getTailleVehiculesAutorises(),
                "Il devrait y avoir 2 véhicules dans VehiculeAutorise");

    }

    @Test
    // contexte_methodeSousTest_resultat()
    public void vehiculeAutorise_ouvrirPorte_devraitRentrer() {
        // AAA : Arrange (préparer), Act (agir), Assert (vérifier)

        // Arrange: Je mets en place mo test, notamment un instanciant et initialisant
        // le ou les objets concernés.

        Parking parking = new Parking(1);
        parking.ajouterVehiculeAutorise("ABC-123");

        // Act: J'appelle la méthode qui est sous test

        parking.enregistrementEntree("ABC-123");

        // Assert : je vérifie que tout s'est passé comme prévu

        assertEquals(1, parking.getTailleVehiculesStationnes(),
                "Le véhicule est rentré");

    }

    @Test
    // contexte_methodeSousTest_resultat()
    public void vehiculeAutoriseParkingPlein_ouvrirPorte_devraitRefuserEntree() {
        // AAA : Arrange (préparer), Act (agir), Assert (vérifier)

        // Arrange: Je mets en place mo test, notamment un instanciant et initialisant
        // le ou les objets concernés.

        Parking parking = new Parking(1);
        parking.ajouterVehiculeAutorise("ABC-123");
        parking.ajouterVehiculeAutorise("ABC-124");

        // Act: J'appelle la méthode qui est sous test
        parking.enregistrementEntree("ABC-123");
        parking.enregistrementEntree("ABC-124");

        // Assert : je vérifie que tout s'est passé comme prévu

        assertEquals(1, parking.getTailleVehiculesStationnes(),
                "Un seul véhicule est stationné");

    }

    @Test
    // contexte_methodeSousTest_resultat()
    public void dixCapacitéMaxSixVehiculeStationne_getTauxRemplissage_devraitAfficherZeroSix() {
        // AAA : Arrange (préparer), Act (agir), Assert (vérifier)

        // Arrange: Je mets en place mo test, notamment un instanciant et initialisant
        // le ou les objets concernés.

        Parking parking = new Parking(10);
        parking.ajouterVehiculeAutorise("ABC-123");
        parking.ajouterVehiculeAutorise("ABC-124");
        parking.ajouterVehiculeAutorise("ABC-125");
        parking.ajouterVehiculeAutorise("ABC-126");
        parking.ajouterVehiculeAutorise("ABC-127");
        parking.ajouterVehiculeAutorise("ABC-128");

        // Act: J'appelle la méthode qui est sous test
        parking.enregistrementEntree("ABC-123");
        parking.enregistrementEntree("ABC-124");
        parking.enregistrementEntree("ABC-125");
        parking.enregistrementEntree("ABC-126");
        parking.enregistrementEntree("ABC-127");
        parking.enregistrementEntree("ABC-128");

        // Assert : je vérifie que tout s'est passé comme prévu

        assertEquals(0.6, parking.getTauxRemplissage(),
                "60% du parking est remplis");

    }

    @Test
    // contexte_methodeSousTest_resultat()
    public void unCapacitéMaxDeuxVehiculeVeulentStationne_getTauxRemplissage_devraitAfficherUn() {
        // AAA : Arrange (préparer), Act (agir), Assert (vérifier)

        // Arrange: Je mets en place mo test, notamment un instanciant et initialisant
        // le ou les objets concernés.

        Parking parking = new Parking(1);
        parking.ajouterVehiculeAutorise("ABC-123");
        parking.ajouterVehiculeAutorise("ABC-124");

        // Act: J'appelle la méthode qui est sous test
        parking.enregistrementEntree("ABC-123");
        parking.enregistrementEntree("ABC-124");

        // Assert : je vérifie que tout s'est passé comme prévu

        assertEquals(1, parking.getTauxRemplissage(),
                "100% du parking est remplis donc le 2ème véhicule n'est pas rentré");

    }
}