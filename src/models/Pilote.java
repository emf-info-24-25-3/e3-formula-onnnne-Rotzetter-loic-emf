package models;

public class Pilote {
    public static final int NOMBRE_PNEUSENRESERVE = 16;
    private String nom;
    private String nationalite;
    private int nombreDePoints;
    private int nombreDeCources;
    private int nombreDeVictoires;
    private int nombreDePodiums;
    private Pneu[] pneusEnReserve;
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        nombreDePoints = 0;
        nombreDeCources = 0;
        nombreDeVictoires = 0;
        nombreDePodiums = 0;
        voiture = null;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        nombreDePoints = 0;
        nombreDeCources = 0;
        nombreDeVictoires = 0;
        nombreDePodiums = 0;
        pneusEnReserve = new Pneu[0];
        this.voiture = voiture;
    }

    public boolean deposerPneusEnReserve(Pneu pneu) {
        boolean reussi = false;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneusEnReserve[i] = pneu;
                reussi = true;
            }
        }
        return reussi;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu retour = null;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getType() == type) {
                retour = pneusEnReserve[i];
                pneusEnReserve[i] = null;
                break;
            }
        }
        return retour;
    }

    public int compterNombreDePneusEnReserveType(TypePneu type) {
        int compte = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getType() == type) {
                compte++;
            }
        }
        return compte;
    }

    public int getNombrePneusEnReserve() {
        int compte = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                compte++;
            }
        }
        return compte;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        int taille = 0;
        int index = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                taille++;
            }
        }
        Pneu[] copy = new Pneu[taille];
        for (int i = 0; i < copy.length; i++) {
            if (pneusEnReserve[i] != null) {
                copy[index] = pneusEnReserve[i];
                index++;
            }
        }
        return copy;
    }

    public String pressionMoyenneDesPneusEnReserveFormate() {
        double moyenne = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            moyenne += pneusEnReserve[i].getPression();
        }
        String result = "" + moyenne;
        return result;
    }

    public int supprimePneusDePressionInferieur(double pression) {
        int compte = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getPression() < pression) {
                pneusEnReserve[i] = null;
                compte++;
                break;
            }
        }
        return compte;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        boolean reussi = false;

        if (pneus != null) {
            if (pneus.length > pneusEnReserve.length - getNombrePneusEnReserve()) {
                int index = 0;
                for (int i = 0; i < pneusEnReserve.length; i++) {
                    if (index > pneus.length) {
                        break;
                    } else {
                        pneusEnReserve[i] = pneus[index];
                        index++;
                        reussi = true;
                    }
                }
            }
        }
        return reussi;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombreDePoints() {
        return nombreDePoints;
    }

    public void setNombreDePoints(int nombreDePoints) {
        this.nombreDePoints = nombreDePoints;
    }

    public int getNombreDeCources() {
        return nombreDeCources;
    }

    public void setNombreDeCources(int nombreDeCources) {
        this.nombreDeCources = nombreDeCources;
    }

    public int getNombreDeVictoires() {
        return nombreDeVictoires;
    }

    public void setNombreDeVictoires(int nombreDeVictoires) {
        this.nombreDeVictoires = nombreDeVictoires;
    }

    public int getNombreDePodiums() {
        return nombreDePodiums;
    }

    public void setNombreDePodiums(int nombreDePodiums) {
        this.nombreDePodiums = nombreDePodiums;
    }

    @Override
    public String toString() {
        String resultat = "Pilot: " + nom + " (" + nationalite + ")\n";
        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();
            resultat += "-> Voiture " + nomEquipe + "(" + numero + ")\n";
            resultat += "-> Points: " + nombreDePoints + "\n";
            resultat += "-> Courses: " + nombreDeCources + "\n";
            resultat += "-> Victoires: " + nombreDeVictoires + "\n";
            resultat += "-> Podiums: " + nombreDePodiums + "\n";
        } else {
            resultat += "-> Pas de voitures assignée.\n";
        }
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "-> Pneus en réserve: " + type + "\n";
            }
        }
        return resultat;
    }
}
