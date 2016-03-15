package tu_berlin.alexei.cis_tu_berlin;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.nfc.tech.NfcA;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Alexei on 04.02.2016.
 */
public class PersonExtendAdapter extends BaseExpandableListAdapter {

    public static String webPersonPAGE, EMAIL, PHONE, IMAGE;
    private Activity activity;
    private ArrayList<Object> childtems, childtems2, childtems3, childtems4;
    private LayoutInflater inflater;
    private ArrayList<String> parentItems, child, child2, child3, child4;

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    public PersonExtendAdapter(ArrayList<String> parents, ArrayList<Object> children, ArrayList<Object> children2, ArrayList<Object> children3, ArrayList<Object> children4) {
        this.parentItems = parents;
        this.childtems = children;
        this.childtems2 = children2;
        this.childtems3 = children3;
        this.childtems4 = children4;
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
        child4 = (ArrayList<String>) childtems4.get(groupPosition);
        
        TextView textView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.person_group_row, null);
        }
        textView = (TextView) convertView.findViewById(R.id.textContactName);
        textView.setText(child.get(childPosition));
        textView = (TextView) convertView.findViewById(R.id.textContactEmail);
        textView.setText(child2.get(childPosition));
        textView = (TextView) convertView.findViewById(R.id.textContactNumber);
        textView.setText(child3.get(childPosition));
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageContactView);
        // Checks if there is no img link, it loads default png. Otherwise it loads img from the Internet
        if(child4.get(childPosition).equals("")) {
            imageView.setImageResource(R.drawable.account_box_outline48);
        } else {
            new DownloadImageTask(imageView).execute(child4.get(childPosition));
        }
        final Context context = parent.getContext();
        final FragmentManager fm = ((Activity) context).getFragmentManager();

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get information from the click on the ExtendedList
                LinkPersonSwitcher linkPersonSwitcher = new LinkPersonSwitcher(child.get(childPosition));
                String linkPerson = linkPersonSwitcher.getLink();
                if (linkPerson != null)
                    webPersonPAGE = "http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&moduleCall=webInfo&publishConfFile=webInfoPerson&publishSubDir=personal&keep=y&personal.pid=" + linkPerson;
                EMAIL = new LinkEmailSwitcher(child.get(childPosition)).getLink();
                PHONE = new LinkPhoneSwitcher(child.get(childPosition)).getLink();

                // Launch DialogFragment
                DialogFragment popup = new ThreeActivityDialogFragment();
                popup.show(fm, "PopUP");
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