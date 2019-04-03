import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Invoices implements JsonSupport {
    List<Racun> racuni;

    public Invoices() {
        this.racuni = new ArrayList<Racun>();
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
        Invoices i= gson.fromJson(str, Invoices.class);
        racuni=i.racuni;
    }

    public Racun get(int i)
    {
        return racuni.get(i);
    }
    public void add(Racun a)
    {
        racuni.add(a);
    }
    public void remove(int i)
    {
        racuni.remove(i);
    }


}
