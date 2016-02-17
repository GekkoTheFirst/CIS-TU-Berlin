package tu_berlin.alexei.cis_tu_berlin;

/**
 * Created by Alexei on 04.02.2016.
 */
public class LinkPersonSwitcher {
    private String _link;
    public LinkPersonSwitcher(String link){
        _link = link;
    }

    public String getLink() {
        switch (_link) {
            case "Javier Herreruela":
                _link = "1807";
                break;
            case "Gerth König":
                _link = "404";
                break;
            case "Thomas Adolphi":
                _link = "8658";
                break;
            case "Andreas Wichmann":
                _link = "8658";
                break;
        }
        return _link;
    }
}
