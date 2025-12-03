package Asm;
public class Mem extends Instruction{
    public static enum Op { LD, ST };

    private int dest;
    private int sr;

    /**
     * Getter du registre à stocker ou de destination
     * @return numéro du registre à stocker ou de destination
     */
    public int getDest() {
        return dest;
    }

    /**
     * Setter du registre à stocker ou de destination
     * @param dest numéro du registre à stocker ou de destination
     */
    public void setDest(int dest) {
        this.dest = dest;
    }

    /**
     * Getter du registre d'adresse
     * @return numéro du registre d'adresse
     */
    public int getSr() {
        return sr;
    }

    /**
     * Setter du registre d'adresse
     * @param sr numéro du registre d'adresse
     */
    public void setSr(int sr) {
        this.sr = sr;
    }

    /**
     * Constructeur
     * @param label label de l'instruction
     * @param op type d'opération
     * @param dest numéro du registre à stocker ou de destination
     * @param sr numéro du registre d'adresse
     */
    public Mem(String label, Op op, int dest, int sr) {
        super(label,op.toString());
        this.dest = dest;
        this.sr = sr;
    }

    /**
     * Constructeur sans label
     * @param op type d'opération
     * @param dest numéro du registre à stocker ou de destination
     * @param sr numéro du registre d'adresse
     */
    public Mem(Op op, int dest, int sr) {
        super("",op.toString());
        this.dest = dest;
        this.sr = sr;
    }

    /** 
     * Conversion en String
     * @return String texte de l'instruction
     */
    public String toString() {
        return this.label+ (this.label==""?"":": ") + this.name + " R" + dest + " R" + sr + "\n";
    }
    
}