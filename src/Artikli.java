import com.google.gson.Gson;

import java.util.List;

public class Artikli implements JsonSupport {


    private List<Artikel> artikli;
    private List<Integer> kolicine;



    public Artikli(List<Artikel> artikli, List<Integer> kolicine) {
        this.artikli = artikli;
        this.kolicine = kolicine;
    }

    @Override
    public String toJson()
    {
        Gson gson=new Gson();
        return gson.toJson(this);
    }

    @Override
    public void fromJson(String str)
    {
        Gson gson=new Gson();
        Artikli i= gson.fromJson(str, Artikli.class);
        artikli=i.artikli;
        kolicine=i.kolicine;
    }

    public int size() {
        return artikli.size();
    }

    public boolean add(Integer integer) {
        return kolicine.add(integer);
    }

    public boolean add(Artikel artikel) {
        return artikli.add(artikel);
    }

    public Artikel get(int index) {
        return artikli.get(index);
    }
    public int getKolicine(int index) {
        return kolicine.get(index);
    }

    public Artikel remove(int index) {
        return artikli.remove(index);
    }

    public List<Artikel> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikel> artikli) {
        this.artikli = artikli;
    }

    public List<Integer> getKolicine() {
        return kolicine;
    }

    public void setKolicine(List<Integer> kolicine) {
        this.kolicine = kolicine;
    }
}
