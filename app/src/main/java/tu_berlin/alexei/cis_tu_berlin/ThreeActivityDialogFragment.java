package tu_berlin.alexei.cis_tu_berlin;

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
    final private String[] list = {"Visit web page", "Write e-mail", "Make call"};


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.choose_activity)
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichCase) {
                        //Toast.makeText(getActivity(), String.valueOf(which), Toast.LENGTH_LONG).show();

                        Context context = (InfoDisplayActivity) getActivity();
                        //Context context = PersonExtendAdapter.CNTXT;
                        switch (whichCase) {
                            case 0:
                                Intent webPage = new Intent(context, WebPersonPageActivity.class);
                                context.startActivity(webPage);
                                break;
                            case 1:
                                String eMail =  PersonExtendAdapter.EMAIL;
                                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", eMail, null));
                                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                                emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body");
                                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                                break;
                            case 2:
                                String number =  PersonExtendAdapter.PHONE;
                                PackageManager packageManager = context.getPackageManager();
                                if (packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                                    //call phone
                                    Intent intent = new Intent(Intent.ACTION_CALL);
                                    intent.setData(Uri.parse("tel:" + number));
                                    startActivity(intent);
                                }
                                /*Intent makeCall = new Intent(Intent.ACTION_CALL, Uri.fromParts("telephone", PersonExtendAdapter.PHONE, null));
                                startActivity(makeCall);*/
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
