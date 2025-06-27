package app;


import models.Pilote;
import models.Pneu;
import models.TypePneu;
import models.Voiture;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture voiture = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(voiture);
        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote pilote1 = new Pilote("Charles Leclerc", "Monégasque", voiture);
        pilote1.ajouterLotDePneus(null);
        pilote1.setNombreDeCources(16);
        pilote1.setNombreDePoints(65);
        pilote1.setNombreDeVictoires(3);
        pilote1.setNombreDePodiums(7);
        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(pilote1);
        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        // deposerPneuEnReserve() 5 fois de types différents
        Pneu pneu1 = new Pneu(TypePneu.DURE_BLANC, 1.5);
        Pneu pneu2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu pneu3 = new Pneu(TypePneu.TENDRE_ROUGE, 2);
        Pneu pneu4 = new Pneu(TypePneu.DURE_BLANC, 1.6);
        Pneu pneu5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);
        pilote1.deposerPneusEnReserve(pneu1);
        pilote1.deposerPneusEnReserve(pneu2);
        pilote1.deposerPneusEnReserve(pneu3);
        pilote1.deposerPneusEnReserve(pneu4);
        pilote1.deposerPneusEnReserve(pneu5);
        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        System.out.println(pilote1.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE));
        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.println(pilote1.getNombrePneusEnReserve());
        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        System.out.println(pilote1.getPneusEnReserveSansTrous());
        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne des
        // pneus
        System.out.println(pilote1.pressionMoyenneDesPneusEnReserveFormate());
        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.println(pilote1.compterNombreDePneusEnReserveType(TypePneu.DURE_BLANC));
        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu pneu6 = new Pneu(TypePneu.DURE_BLANC, 1.3);
        Pneu pneu7 = new Pneu(TypePneu.DURE_BLANC, 1.2);
        Pneu pneu8 = new Pneu(TypePneu.DURE_BLANC, 1.1);
        Pneu[] p1 = new Pneu[3];
        p1[0] = pneu6;
        p1[1] = pneu7;
        p1[2] = pneu8;
        System.out.println(pilote1.ajouterLotDePneus(p1));
        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        System.out.println(pilote1.supprimePneusDePressionInferieur(1.3));
        // ---------------------------------------------------------------------------------------

    }

}
