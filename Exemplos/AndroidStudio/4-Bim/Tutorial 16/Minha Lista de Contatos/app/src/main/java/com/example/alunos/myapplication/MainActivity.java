package com.example.alunos.myapplication;

import android.Manifest;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

    private void showMessageOKCancel (Steing message, DialogInterface.OnClickListener.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancelar", null)
                .create()
                .show();
    }

    public void onActivityResult(int reqCode, int resCode, Intent data){
        super.onActivityResult(reqCode, reqCode, data);
        switch (reqCode){
            case (PICK_CONTACT):
                if(resCode == Activity.RESULT_OK){
                    Uri contactData = data.getData();
                    Cursor c = getContentResolver().query(contactData,null,null,null,null);
                    if(c.moveToFirst()){
                        String id = c.getString(
                                c.getColumnIndexOrThrow(ContactsContract._ID));
                        String hasPhone = c.getString(
                                c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                        try{
                            if(hasPhone.equalsIgnoreCase("1")){
                                Cursor phones = getContentResolver().query(
                                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                                phones.moveToFirst();
                                String cNumber = phones.getString(phones.getColumnIndex("data1"));
                                Log.d("Number:". cNumber);
                                txtPhone.setText(cNumber);
                            }
                            String name = c.getString(
                                    c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                            txtName.setText(name);
                        }
                        catch (Exception ex){
                            Log.d("Exceção:", ex.getMessage());
                        }
                    }
                }
                break;
        }
    }



    Button btnPickContact;
    TextView txtName, txtPhone;
    static final int PICK_CONTACT = 1;
    final private int REQUEST_MULTIPLE_PERMISSIONS = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccessContact();
        btnPickContact = findViewById(R.id.btnPickContact);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        btnview.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
            }
        });

    }

    private void AccessContact() {
        List<String> permissionNeeded = new ArrayList<>();
        final List<String> permissionList = new ArrayList<>();
        if(!addPermission(permissionList, Manifest.permission.READ_CONTACTS))
            permissionNeeded.add("Ler contatos");
        if(!addPermission(permissionList, Manifest.permission.WRITE_CONTACTS))
            permissionNeeded.add("Criar contatos");
        if(permissionList.size() > 0){
            if(permissionNeeded.size() > 0){
                String msg = "São necessárias permissões para:" +
                        permissionNeeded.get(0);
                for(int i=l; i<permissionNeeded.size(); i++)
                    msg = msg + "," + permissionNeeded.get(i);
                showMessageOKCancel(
                        msg,
                        new DialogInterface.OnCancelListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int whitch) {
                                requestPermissions(permissionList.toArray(
                                        new String[permissionList.size()]),
                                        REQUEST_MULTIPLE_PERMISSIONS);
                            }
                        });
                return;
            }
            RequestPermissions(
                    permissionList.toArray(
                            new String[permissionList.size()]),
                    REQUEST_MULTIPLE_PERMISSIONS);
            return;
            }
        }
    }

