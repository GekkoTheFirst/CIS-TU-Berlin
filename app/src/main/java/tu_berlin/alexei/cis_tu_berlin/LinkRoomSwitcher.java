package tu_berlin.alexei.cis_tu_berlin;

import android.widget.LinearLayout;

/**
 * Created by Alexei on 03.02.2016.
 */
public class LinkRoomSwitcher {
    private String _link;
    public LinkRoomSwitcher(String link){
        _link = link;
    }
    
    public String getLink(){
        switch (_link){
            // H6131
            case "Geoinformation Technology":
                _link = "172632";
                break;
            case "Introduction to Satellite Geodesy":
                _link = "";
                break;
            case "Geo Databases":
                _link = "";
                break;
            case "Adjustment Calculation I":
                _link = "173001";
                break;
            case "Transformation of Geodetic Networks":
                _link = "";
                break;
            case "Selected Topics in Planetary Science":
                _link = "";
                break;
            case "Planetary and Space Science Project":
                _link = "";
                break;
            case "Geodetic Colloquium":
                _link = "";
                break;
            case "Statistic Test Procedures and Analysis of Stochastic Processes":
                _link = "";
                break;
            case "Engineering Geodesy and Adjustment Calculation Project":
                _link = "";
                break;
            case "Geodetic Basics and Monitoring Measurements":
                _link = "";
                break;
            // H6134
            case "GIS Project":
                _link = "";
                break;
            case "Web Cartography":
                _link = "";
                break;
            case "Basics in Engineering Surveys":
                _link = "172941";
                break;
            case "Web":
                _link = "";
                break;
            default:
                _link = null;
                break;
        }
        return _link;
    }
}
