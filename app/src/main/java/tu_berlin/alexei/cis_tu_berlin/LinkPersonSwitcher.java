package tu_berlin.alexei.cis_tu_berlin;

/**
 * Created by Alexei on 04.02.2016.
 */
public class LinkPersonSwitcher {
    private String link;
    private String[] _link = new String[3];
    public LinkPersonSwitcher(String inputLink){
        link = inputLink;
    }

    /* Structure of the _link Array:
    * [0] - LSF ID
    * [1] - Email
    * [2] - Telephone Number */

    public String[] getLink() {
        switch (link) {
            case "Hartmut Lehmann":
                _link[0] = "1807";
                _link[1] = "h.lehmann@tu-berlin.de";
                _link[2] = "+493031427500";
                break;
            case "Javier Herreruela":
                _link[0] = null;
                _link[1] = "javier.herreruela@tu-berlin.de";
                _link[2] = "+493031427501";
                break;
            case "Gerth König":
                _link[0] = "404";
                _link[1] = "gerth.konig@tu-berlin.de";
                _link[2] = "++493031424335";
                break;
            case "Thomas Adolphi":
                _link[0] = "8658";
                _link[1] = "thomas.becker@tu-berlin.de";
                _link[2] = "++493031424332";
                break;
            case "Andreas Wichmann":
                _link[0] = "9876";
                _link[1] = "andreas.wichmann@tu-berlin.de";
                _link[2] = "+493031427503";
                break;
            default:
                _link[0] = null;
                _link[1] = null;
                _link[2] = null;
                break;
        }
        return _link;
    }
}
