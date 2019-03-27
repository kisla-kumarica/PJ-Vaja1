import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vaja1 {
    public static void main(String[] args)
    {
        List<Racun> a=new ArrayList<Racun>();
        List<Podjetje> podjetja=new ArrayList<>();
        podjetja.add(new Podjetje("podjetje1","45678148","5288427000 ",true));
        podjetja.add(new Podjetje("podjetje2","21321321","2364523000 ",true));
        podjetja.add(new Podjetje("podjetje3","43543553","2343243000 ",false));
        List<Artikel> artikli=new ArrayList<Artikel> (Arrays.asList(new Artikel("Jabolcni sok",1.09,Artikel.Davcna_stopnja.SPLOSNA),new Artikel("Pomaranča",.3,Artikel.Davcna_stopnja.ZNIZANA)));
        List<Integer> kolicine=new ArrayList<Integer>(Arrays.asList(2,9));
        List<Artikel> artikli2=new ArrayList<Artikel> (Arrays.asList(new Artikel("pomarancni sok",1.29,Artikel.Davcna_stopnja.SPLOSNA),new Artikel("Snickers",.89,Artikel.Davcna_stopnja.SPLOSNA)));
        List<Integer> kolicine2=new ArrayList<Integer>(Arrays.asList(1,3));
        List<Artikel> artikli3=new ArrayList<Artikel> (Arrays.asList(new Artikel("Mars",.69,Artikel.Davcna_stopnja.SPLOSNA),new Artikel("bela štruca",1.29,Artikel.Davcna_stopnja.SPLOSNA)));
        List<Integer> kolicine3=new ArrayList<Integer>(Arrays.asList(4,2));
        a.add(new Racun(artikli,kolicine,"izdajatelj", podjetja.get(0).getDavcna_st()));
        a.add(new Racun(artikli2,kolicine2,"izdajatelj2", podjetja.get(1).getDavcna_st()));
        a.add(new Racun(artikli3,kolicine3,"izdajatelj3", podjetja.get(2).getDavcna_st()));

        for(var podjetje:podjetja)
        if(a.get(2).getDavcna_st_podjetja()==podjetje.davcna_st)
        {
            if(podjetje.je_davcni_zavezanec)
                System.out.println("Podjetje je davcni zavezanec");
            else
                System.out.println("Podjetje ni davcni zavezanec");
            break;
        }
        System.out.println("Check digit za: 629104150021   4");
        System.out.println(Artikel.checkDigit("629104150021",4));
        System.out.println("Check digit za: 629104150021   3");
        System.out.println(Artikel.checkDigit("629104150021",3));

        System.out.println("Racun 1 toString()");
        System.out.println(a.get(0).toString());

    }
}
