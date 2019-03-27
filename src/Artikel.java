import java.util.ArrayList;

public class Artikel implements Searchable {
    private String ime;
    private double cena;


    public Artikel(String ime, double cena, Davcna_stopnja stopnja)
    {
        this.ime = ime;
        this.cena = cena;
        this.stopnja=stopnja;
        addDDV();
    }

    @Override
    public boolean search(String str)
    {
        return ime.contains(str);
    }

    static boolean checkDigit(String crtna, int checkdgt)
    {
        ArrayList<Integer> temp=new ArrayList<Integer>();
        for(int i = 0;i<crtna.length();i++) {
            if((i+1)%2==0)
                temp.add(Character.getNumericValue(crtna.charAt(i))*3);
            else
                temp.add(Character.getNumericValue(crtna.charAt(i)));
        }
        int sum=0;
        for(int i: temp)
            sum+=i;
        return (sum+10-sum%10)-sum==checkdgt;
    }
    private void addDDV()
    {
        switch (stopnja) {
            case SPLOSNA:
                cena*=1.22;
                break;
            case ZNIZANA:
                cena*=1.095;
                break;
        }
    }


    public void setIme(String ime)
    {
        this.ime=ime;
    }
    public void setCena(double cena)
    {
        this.cena=cena;
    }
    public double getCena() {
        return cena;
    }
    public String getIme() {
        return ime;
    }
    static enum Davcna_stopnja { SPLOSNA, ZNIZANA}
    private Davcna_stopnja stopnja;
}
