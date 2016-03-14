package tu_berlin.alexei.cis_tu_berlin;

/**
 * Created by Alexei on 04.02.2016.
 */
public class LinkPhoneSwitcher {
    private String _link;
    public LinkPhoneSwitcher(String link){
        _link = link;
    }

    public String getLink() {
        switch (_link) {
            case "Javier Herreruela":
                _link = "+493031427501";
                break;
            case "Thomas Adolphi":
                _link = "+493031424332";
                break;
            case "Andreas Wichmann":
                _link = "+493031429498";
                break;
            case "Hartmut Lehmann":
                _link = "+493031427500";
                break;
            default:
                _link = null;
                break;
        }
        return _link;
    }
}
