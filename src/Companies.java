import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Companies implements JsonSupport {
    List<Podjetje> podjetja;

    public Companies() {
        this.podjetja = new ArrayList<Podjetje>();
    }
    public Companies(List<Podjetje> podjetja) {
        this.podjetja = podjetja;
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
        Companies i= gson.fromJson(str, Companies.class);
        podjetja=i.podjetja;
    }

    public int size()
    {
        return podjetja.size();
    }
    public Podjetje get(int i)
    {
        return podjetja.get(i);
    }
    public void add(Podjetje a)
    {
        podjetja.add(a);
    }
    public void remove(int i)
    {
        podjetja.remove(i);
    }
}
