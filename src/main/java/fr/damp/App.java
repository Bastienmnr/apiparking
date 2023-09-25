package fr.damp;

public class App {
    
    public static void main(String[] args) {

      Vehicule vehicule1 = new Vehicule("ABc-123");
      vehicule1.changerImmatriculation("DCE-456");
      System.out.println(vehicule1.getImmatriculation());

      Parking parking1 = new Parking(500);
      parking1.ajouterVehiculeAutorise("DCE-123");
    }
    
}
