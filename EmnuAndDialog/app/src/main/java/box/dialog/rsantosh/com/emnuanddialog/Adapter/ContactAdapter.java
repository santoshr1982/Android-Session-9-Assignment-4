package box.dialog.rsantosh.com.emnuanddialog.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import box.dialog.rsantosh.com.emnuanddialog.Model.ContactModel;
import box.dialog.rsantosh.com.emnuanddialog.R;

/**
 * Created by R.Santosh on 27-06-2016.
 */
public class ContactAdapter extends ArrayAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<ContactModel> mContact;


    public ContactAdapter(Context context, int resource, ArrayList<ContactModel> mContact) {
        super(context, resource);
        this.mContext = context;
        this.mLayoutInflater = mLayoutInflater.from(context);
        this.mContact = mContact;
    }

    @Override
    public int getCount() {
        return mContact.size();
    }

    @Override
    public Object getItem(int position) {
        return mContact.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            convertView = mLayoutInflater.inflate(R.layout.item_list_view,parent,false);

        }

        TextView mTextName = (TextView) convertView.findViewById(R.id.name);
        TextView mTextNumber = (TextView) convertView.findViewById(R.id.phone_number);
        TextView mTextDob = (TextView) convertView.findViewById(R.id.dob);

        ContactModel contactModel = (ContactModel) getItem(position);

        mTextName.setText(contactModel.strName);
        mTextNumber.setText(contactModel.strPhone);
        mTextDob.setText(contactModel.strDob);

        return convertView;
    }
}
