package fr.msa.imsa.model;



public class Dossier {
    private String numsecu;
    private String typeDemarrage;
    
    

    public Dossier() {
    }

    
    public Dossier(String numsecu, String typeDemarrage) {
        this.numsecu = numsecu;
        this.typeDemarrage = typeDemarrage;
    }


    /**
     * @return String return the numsecu
     */
    public String getNumsecu() {
        return numsecu;
    }

    /**
     * @param numsecu the numsecu to set
     */
    public void setNumsecu(String numsecu) {
        this.numsecu = numsecu;
    }

    /**
     * @return String return the typeDemarrage
     */
    public String getTypeDemarrage() {
        return typeDemarrage;
    }

    /**
     * @param typeDemarrage the typeDemarrage to set
     */
    public void setTypeDemarrage(String typeDemarrage) {
        this.typeDemarrage = typeDemarrage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numsecu == null) ? 0 : numsecu.hashCode());
        result = prime * result + ((typeDemarrage == null) ? 0 : typeDemarrage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dossier other = (Dossier) obj;
        if (numsecu == null) {
            if (other.numsecu != null)
                return false;
        } else if (!numsecu.equals(other.numsecu))
            return false;
        if (typeDemarrage == null) {
            if (other.typeDemarrage != null)
                return false;
        } else if (!typeDemarrage.equals(other.typeDemarrage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dossier [numsecu=" + numsecu + ", typeDemarrage=" + typeDemarrage + "]";
    }

    
}
