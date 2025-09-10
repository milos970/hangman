package ponuka;

import java.util.List;

public interface Ulozenie {

    public void ulozSkore(Skore skore);

    public List<Skore> nacitajSkore();
}
