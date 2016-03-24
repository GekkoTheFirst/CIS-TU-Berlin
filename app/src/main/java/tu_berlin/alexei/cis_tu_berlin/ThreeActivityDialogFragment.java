package tu_berlin.alexei.cis_tu_berlin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Alexei on 27.01.2016.
 */
public class ThreeActivityDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String[] listActivities = {getString(R.string.visit_web), getString(R.string.write_email), getString(R.string.make_call)};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.choose_activity)
                .setItems(listActivities, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichCase) {
                        switch (whichCase) {
                            case 0:
                                if(PersonExtendAdapter.webPersonPAGE != null) {
                                    Intent webPage = new Intent(getActivity(), WebPersonPageActivity.class);
                                    getActivity().startActivity(webPage);
                                } else {
                                    dismiss();
                                    Toast.makeText(getActivity().getApplication(),  R.string.no_info, Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 1:
                                String eMail =  PersonExtendAdapter.EMAIL;
                                if(eMail != null){
                                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", eMail, null));
                                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                                    emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body));
                                    startActivity(Intent.createChooser(emailIntent, "Complete action using"));
                                } else {
                                    dismiss();
                                    Toast.makeText(getActivity().getApplication(),  R.string.no_info, Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 2:
                                String number = PersonExtendAdapter.PHONE;
                                if(number != null) {
                                    PackageManager packageManager = getActivity().getPackageManager();
                                    if (packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                                        //call phone
                                        Intent intent = new Intent(Intent.ACTION_DIAL);
                                        intent.setData(Uri.parse("tel:" + number));
                                        startActivity(intent);
                                    }
                                } else {
                                    dismiss();
                                    Toast.makeText(getActivity().getApplication(),  R.string.no_info, Toast.LENGTH_SHORT).show();
                                }
                                break;
                            default:
                                dismiss();
                                break;
                        }


                    }
                });
        return builder.create();
    }

}
