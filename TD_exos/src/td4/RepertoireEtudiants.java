package td4;

/**
 * Cr�ation et gestion du tableau contenant les �tudiants
 * @author Florian Hauwelle
 * @author Ewan Cereza
 * @version JDK 17.0.1
 */
public class RepertoireEtudiants {
    
    private final int nbMax;
    private int nbE = 0;
    private Etudiant etudiants[];
    
    /**
     * Initialisation du tableau avec sa taille max
     * @param nbMax taille max du tableau
     */
    public RepertoireEtudiants(int nbMax) {
        if (nbMax <= 0) {
            this.nbMax = 1;
        }
        else {
            this.nbMax = nbMax;
        }
        this.etudiants = new Etudiant[nbMax];
    }
    
    /**
     * V�rifie la possibilit� d'ajout dans le tableau + association de l'objet
     * en param�tre � l'indice suivant dans le tableau
     * @param e objet �tudiant
     * @return si l'ajout a fonctionn� ou non
     */
    public boolean ajouteEtudiant(Etudiant e) {
        if (this.nbE >= nbMax) {
            return false;
        }
        else {
            etudiants[this.nbE] = e;
            this.nbE ++;
            return true;
        }
    }
    
    /**
     * Getter du nombre d'�tudiants dans le tableau
     * @return nombre d'�tudiants dans le r�pertoire/tableau
     */
    public int getNbEtudiant() { return this.nbE ; }
    
    /**
     * Parcours le tableau jusqu'� trouver le num�ro �tudiant pass� en param�tre
     * @param numeroEtu le num�ro �tudiant recherch�
     * @return le nom de l'�tudiant s'il est dans le tableau
     */
    public String getNom(int numeroEtu) {
        int i = 0;
        
        while(i < this.nbE && this.etudiants[i].getNumero() != numeroEtu) { i++ ; }
        
        if(i == this.nbE) {
            return null;
        }
        else {
            return etudiants[i].getNom();
        }
    }
    
    /**
     * 
     * @param nom
     * @return le num�ro d'�tudiant
     */
    public int getNumero(String nom) {
        int i = 0;
        
        while(i < this.nbE && !(this.etudiants[i].getNom().toLowerCase().equals(nom.toLowerCase()))) { i++ ; }
        
        if(i == this.nbE) {
            return -1;
        }
        else {
            return etudiants[i].getNumero();
        }
    }
    
    /**
     * Parcours le tableau jusqu'� trouver l'objet �tudiant � supprimer 
     * @param e objet �tudiant
     * @return si la suppression a fonctionn� ou non
     */
    public boolean supprimeEtudiant(Etudiant e) {
        int i = 0;
        
        while (i < this.nbE && this.etudiants[i].getNumero() != e.getNumero()) { i++ ; }
        
        if(i == nbE) {
            return false;
        }
        else {
            for(int j = i; j < this.nbE - 1; j++) {
                this.etudiants[j] = this.etudiants[j+1];
            }
            nbE--;
            return true;
        }
    }
    
}
