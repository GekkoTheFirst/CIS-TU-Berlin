package tu_berlin.alexei.cis_tu_berlin;

/**
 * Created by Alexei on 04.02.2016.
 */
public class LinkEmailSwitcher {
    private String _link;
    public LinkEmailSwitcher(String link){
        _link = link;
    }

    public String getLink() {
        switch (_link) {
            case "Javier Herreruela":
                _link = "javier.herreruela@tu-berlin.de";
                break;
            case "Thomas Adolphi":
                _link = "thomas.becker@tu-berlin.de";
                break;
            case "Andreas Wichmann":
                _link = "andreas.wichmann@tu-berlin.de";
                break;
        }
        return _link;
    }
}
