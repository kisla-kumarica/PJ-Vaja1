public class Podjetje implements Searchable {
    String ime;
    String davcna_st;
    String maticna_st;
    boolean je_davcni_zavezanec;

    public Podjetje(String ime, String davcna_st, String maticna_st, boolean je_davcni_zavezanec) {
        this.ime = ime;
        this.davcna_st = davcna_st;
        this.maticna_st = maticna_st;
        this.je_davcni_zavezanec = je_davcni_zavezanec;
    }
@Override
public boolean search(String str)
{
    return ime.contains(str)||davcna_st.contains(str)||maticna_st.contains(str);
}

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDavcna_st() {
        return davcna_st;
    }

    public void setDavcna_st(String davcna_st) {
        this.davcna_st = davcna_st;
    }

    public String getMaticna_st() {
        return maticna_st;
    }

    public void setMaticna_st(String maticna_st) {
        this.maticna_st = maticna_st;
    }

    public boolean isJe_davcni_zavezanec() {
        return je_davcni_zavezanec;
    }

    public void setJe_davcni_zavezanec(boolean je_davcni_zavezanec) {
        this.je_davcni_zavezanec = je_davcni_zavezanec;
    }
}
