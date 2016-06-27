package box.dialog.rsantosh.com.emnuanddialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import box.dialog.rsantosh.com.emnuanddialog.Adapter.ContactAdapter;
import box.dialog.rsantosh.com.emnuanddialog.Model.ContactModel;

public class MenuAndDialog extends AppCompatActivity {

    private ArrayList<ContactModel> mContacts;
    private ListView mListView;
    private ContactAdapter mContactAdapter;
    private Button mAdd;
    private Button mCancel;
    private EditText mName;
    private EditText mPhone;
    private EditText mDob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_and_dialog);

        mContacts = new ArrayList<ContactModel>();

        mContacts = getdata();

        mContactAdapter = new ContactAdapter(this, R.layout.item_list_view ,mContacts);

        mListView = (ListView) findViewById(R.id.contact_list);
        mListView.setAdapter(mContactAdapter);

    }

    private ArrayList<ContactModel> getdata() {

        mContacts.add( new ContactModel("Acadgild","6546546","29/08/1982"));

        return mContacts;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater main_menu = getMenuInflater();

        main_menu.inflate(R.menu.menu_items,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.add:

                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                LayoutInflater layoutInflater = LayoutInflater.from(this);

                final View dialog = layoutInflater.inflate(R.layout.itme_dialog_layout,null,false);
                alertDialog.setView(dialog);
                alertDialog.setTitle("Enter the details");
                alertDialog.show();

                mDob = (EditText) dialog.findViewById(R.id.dob);
                mName = (EditText) dialog.findViewById(R.id.name);
                mPhone = (EditText) dialog.findViewById(R.id.phone_number);


                mAdd = (Button) dialog.findViewById(R.id.save);

                mAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mContacts.add(new ContactModel(mName.getText().toString(),mPhone.getText().toString(),mDob.getText().toString()));
                        mContactAdapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(),"Added to Lsit.",Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                mCancel = (Button) dialog.findViewById(R.id.cancel);

                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alertDialog.dismiss();

                    }
                });

                break;

        }

        return true;
    }
}
