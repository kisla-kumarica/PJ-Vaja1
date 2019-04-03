import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Racun implements Searchable {
    private static int idmax=0;
    private int id;
    private Artikli artikli;
    private Date datum;
    private double znesek;

    private String izdajatelj;
    private String davcna_st_podjetja;
    double popust=0;

    public Racun(Artikli artikli,String izdajatelj, String davcna_st_podjetja, String kupon)
    {
        this.datum =new Date();
        id=idmax;
        idmax++;
        this.artikli=artikli;
        calcZnesek();
        if(kupon!=null)
            applyCoupon(kupon);
        this.izdajatelj=izdajatelj;
        this.davcna_st_podjetja=davcna_st_podjetja;
    }
    private void applyCoupon(String kupon)
    {
        Calendar cal =Calendar.getInstance();
        cal.set(Integer.parseInt(kupon.substring(2,6)),Integer.parseInt(kupon.substring(6,8)),Integer.parseInt(kupon.substring(8,10)));
        if(cal.compareTo(Calendar.getInstance())>0)
            popust=Double.parseDouble(kupon.substring(10));
    }

    @Override
    public boolean search(String str)
    {
        for (var artikel:artikli.getArtikli())
            if(artikel.search(str))
                return true;

        return izdajatelj.contains(str)||davcna_st_podjetja.contains(str);
    }
@Override
public String toString()
{
    String ret=izdajatelj+"\n";
     ret+=datum+"\n";
    ret+="Ime artikla\t\tKos\tTeza\n";
    for(int i = 0;i<artikli.size();i++)
    {
        ret+=artikli.get(i).getIme()+"\t"+artikli.getKolicine(i)+"\t"+artikli.get(i).getTeza()+"\n";
    }
     ret+="-----------------------\n";
    ret+="Znesek:"+znesek+"\n";
    ret+="Popust:"+popust+"%\n";
    ret+="-----------------------\n";
    ret+="davcna stevilka podjetja:"+davcna_st_podjetja+"\n";

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





    private void calcZnesek()
    {
        znesek=0;
        for(int i = 0;i<artikli.size();i++)
            znesek+=artikli.get(i).getCena()*artikli.getKolicine(i);
        znesek*=(1+popust/100);

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


    public double getZnesek() {
        return znesek;
    }

}

