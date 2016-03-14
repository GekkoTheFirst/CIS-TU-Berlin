package tu_berlin.alexei.cis_tu_berlin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Alexei on 26.01.2016.
 */
public class LectureExtendAdapter extends BaseExpandableListAdapter {

    public static String webLecturePAGE;
    private Activity activity;
    private ArrayList<Object> childtems, childtems2, childtems3;
    private LayoutInflater inflater;
    private ArrayList<String> parentItems, child, child2, child3;


    public LectureExtendAdapter(ArrayList<String> parents, ArrayList<Object> childern, ArrayList<Object> childern2, ArrayList<Object> childern3) {
        this.parentItems = parents;
        this.childtems = childern;
        this.childtems2 = childern2;
        this.childtems3 = childern3;
    }
    public void setInflater(LayoutInflater inflater, Activity activity) {
        this.inflater = inflater;
        this.activity = activity;
    }

    @Override
    public View getChildView(int groupPosition,final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        child = (ArrayList<String>) childtems.get(groupPosition);
        child2 = (ArrayList<String>) childtems2.get(groupPosition);
        child3 = (ArrayList<String>) childtems3.get(groupPosition);
        TextView textView = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.room_group_row, null);
        }
        textView = (TextView) convertView.findViewById(R.id.textLecture);
        textView.setText(child.get(childPosition));
        textView = (TextView) convertView.findViewById(R.id.textLectureSemester);
        textView.setText(child2.get(childPosition));
        textView = (TextView) convertView.findViewById(R.id.textProfessor);
        textView.setText(child3.get(childPosition));


        /*final Context context = parent.getContext();
        final FragmentManager fm = ((Activity) context).getFragmentManager();
*/
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*DialogFragment popup = new ThreeActivityDialogFragment();
                popup.show(fm, "PopUP");
                Toast.makeText(activity, child.get(childPosition), Toast.LENGTH_SHORT).show();*/
                LinkRoomSwitcher linkRoomSwitcher = new LinkRoomSwitcher(child.get(childPosition));
                String link = linkRoomSwitcher.getLink();

                // Check data. If it's not available - pushes Toaster
                if(link != null) {
                    webLecturePAGE = "http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&publishid=" + link + "&moduleCall=webInfo&publishConfFile=webInfo&publishSubDir=veranstaltung";
                    //http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&publishid=173001&moduleCall=webInfo&publishConfFile=webInfo&publishSubDir=veranstaltung
                    //Uri uri = Uri.parse(webLecturePAGE);
                    //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    //view.getContext().startActivity(intent);

                    Intent intent = new Intent(view.getContext(), WebLecturePageActivity.class);
                    view.getContext().startActivity(intent);
                } else{
                    Toast.makeText(activity.getApplication(), R.string.no_info, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        //if (convertView == null) {
            convertView = inflater.inflate(R.layout.room_row_layout, null);
        //}

        ((CheckedTextView) convertView).setText(parentItems.get(groupPosition));
        ((CheckedTextView) convertView).setTypeface(null, Typeface.BOLD);
        ((CheckedTextView) convertView).setChecked(isExpanded);

        return convertView;

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((ArrayList<String>) childtems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }

}
