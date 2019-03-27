import java.util.Date;
import java.util.List;

public class Racun implements Searchable {
    private static int idmax=0;
    private int id;
    private Date datum;
    private List<Artikel> artikli;
    private List<Integer> kolicine;
    private double znesek;
    private String EAN;

    private String izdajatelj;
    private String davcna_st_podjetja;

    public Racun( List<Artikel> artikli, List<Integer> kolicine ,String izdajatelj, String davcna_st_podjetja)
    {
        this.datum =new Date();
        this.artikli = artikli;
        this.kolicine = kolicine;
        id=idmax;
        idmax++;
        generateEAN();
        calcZnesek();
        this.izdajatelj=izdajatelj;
        this.davcna_st_podjetja=davcna_st_podjetja;
    }

    @Override
    public boolean search(String str)
    {
        for (var artikel:artikli)
            if(artikel.search(str))
                return true;

        return EAN.contains(str)||izdajatelj.contains(str)||davcna_st_podjetja.contains(str);
    }
@Override
public String toString()
{
    String ret=izdajatelj+"\n";
     ret+=datum+"\n";
    ret+="Ime artikla\t\tKos\n";
    for(int i = 0;i<artikli.size();i++)
    {
        ret+=artikli.get(i).getIme()+"\t"+kolicine.get(i)+"\n";
    }
     ret+="-----------------------\n";
    ret+="Znesek:"+znesek+"\n";
    ret+="-----------------------\n";
    ret+="davcna stevilka podjetja:"+davcna_st_podjetja+"\n";
    ret+="EAN:"+EAN+"\n";

    return ret;

}
    public String getIzdajatelj() {
        return izdajatelj;
    }

    public void setIzdajatelj(String izdajatelj) {
        this.izdajatelj = izdajatelj;
    }

    public String getDavcna_st_podjetja() {
        return davcna_st_podjetja;
    }

    public void setDavcna_st_podjetja(String davcna_st_podjetja) {
        this.davcna_st_podjetja = davcna_st_podjetja;
    }


    private void generateEAN()
    {
        EAN="0";
        for(int i = 0;i<12;i++)
            EAN+=(int)(Math.random()*10);

    }
    public String getEAN()
    {
        return EAN;
    }

    private void calcZnesek()
    {
        znesek=0;
        for(int i = 0;i<artikli.size();i++)
            znesek+=artikli.get(i).getCena()*kolicine.get(i);
    }
    public int getId() {
        return id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<Artikel> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikel> artikli) {
        this.artikli = artikli;
        calcZnesek();
    }

    public List<Integer> getKolicine() {
        return kolicine;
    }

    public void setKolicine(List<Integer> kolicine) {
        this.kolicine = kolicine;
        calcZnesek();
    }

    public double getZnesek() {
        return znesek;
    }

}

