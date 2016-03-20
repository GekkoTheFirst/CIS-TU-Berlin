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
    private String oneList = getString(R.string.visit_web);
    private String twoList = getString(R.string.write_email);
    private String threeList = getString(R.string.make_call);
    final private String[] list = {oneList, twoList, threeList};

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
                                if(PersonExtendAdapter.webPersonPAGE != null) {
                                    Intent webPage = new Intent(context, WebPersonPageActivity.class);
                                    context.startActivity(webPage);
                                } else {
                                    dismiss();
                                    Toast.makeText(getActivity().getApplication(),  R.string.no_info, Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 1:
                                String eMail =  PersonExtendAdapter.EMAIL;
                                if(eMail != null){
                                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", eMail, null));
                                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body");
                                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                                } else {
                                    dismiss();
                                    Toast.makeText(getActivity().getApplication(),  R.string.no_info, Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 2:
                                String number = PersonExtendAdapter.PHONE;
                                if(number != null) {
                                    PackageManager packageManager = context.getPackageManager();
                                    if (packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                                        //call phone
                                        Intent intent = new Intent(Intent.ACTION_CALL);
                                        intent.setData(Uri.parse("tel:" + number));
                                        startActivity(intent);
                                    }
                                } else {
                                    dismiss();
                                    Toast.makeText(getActivity().getApplication(),  R.string.no_info, Toast.LENGTH_SHORT).show();
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
