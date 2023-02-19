package com.ndroid.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ndroid.musicplayerapp.sounds.MainActivity0;
import com.ndroid.musicplayerapp.sounds.MainActivity1;
import com.ndroid.musicplayerapp.sounds.MainActivity2;
import com.ndroid.musicplayerapp.sounds.MainActivity3;
import com.ndroid.musicplayerapp.sounds.MainActivity4;

import java.util.ArrayList;

public class ListViewForAllSound extends AppCompatActivity {

    String []files = {"sound1", "sound2", "sound3", "sound4", "sound5", "sound6","sound7", "sound8","sound9"}; //1

    ListView listView;                      //1
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_view_for_all_sound );

        listView = (ListView)findViewById( R.id.listviewAllSound ); //1

        final ArrayList<String>arrayList = new ArrayList<>(  );
        ArrayAdapter arrayAdapter = new ArrayAdapter( this,android.R.layout.simple_list_item_1,files );
        listView.setAdapter( arrayAdapter );


      //  listView.setAdapter( adapter10 );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent( getApplicationContext(), MainActivity0.class);
                        startActivity( intent );
                        break;
                    case 1:
                        Intent intent1 = new Intent( getApplicationContext(), MainActivity1.class);
                        startActivity( intent1 );


                        break;
                    case 2:

                        Intent intent2 = new Intent( getApplicationContext(), MainActivity2.class);
                        startActivity( intent2 );

                        break;
                    case 3:

                        Intent intent3 = new Intent( getApplicationContext(), MainActivity3.class);
                        startActivity( intent3 );

                        break;
                    case 4:
                        Intent intent4 = new Intent( getApplicationContext(), MainActivity4.class);
                        startActivity( intent4 );

                        break;
                    case 5:


                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:

                        break;
                    case 12:

                        break;
                    case 13:

                        break;
                    case 14:


                        break;
                    case 15:

                        break;
                    case 16:

                        break;
                    case 17:

                        break;
                    case 18:

                        break;
                    case 19:

                        break;
                    case 20:

                        break;
                    case 21:

                        break;
                    case 22:


                        break;
                    case 23:


                        break;
                    case 24:

                        break;
                    case 25:

                        break;
                    case 26:

                        break;
                    case 27:

                        break;
                    case 28:

                        break;
                    case 29:

                        break;
                    case 30:

                        break;
                    case 31:

                        break;
                    case 32:

                        break;
                    case 33:

                        break;
                    case 34:

                        break;
                    case 35:

                        break;
                    case 36:

                        break;
                    case 37:

                        break;
                    case 38:

                        break;
                    case 39:

                        break;
                    case 40:

                        break;
                    case 41:

                        break;
                    case 42:

                        break;
                    case 43:

                        break;
                    case 44:

                        break;
                    case 45:

                        break;
                    case 46:

                        break;
                    case 47:

                        break;
                    case 48:

                        break;
                    case 49:

                        break;
                    case 50:

                        break;
                    case 51:

                        break;
                    case 52:

                        break;
                    case 53:

                        break;
                    case 54:

                        break;
                    case 55:

                        break;
                    case 56:

                        break;
                    case 57:

                        break;
                    case 58:

                        break;
                    case 59:

                        break;
                    case 60:

                        break;
                    case 61:

                        break;
                    case 62:

                        break;
                    case 63:

                        break;
                    case 64:

                        break;
                    case 65:

                        break;
                    case 66:

                        break;
                    case 67:

                        break;
                    case 68:

                        break;
                    case 69:

                        break;
                    case 70:

                        break;
                    case 71:

                        break;
                    case 72:

                        break;
                    case 73:

                        break;
                    case 74:

                        break;
                    case 75:

                        break;
                    case 76:

                        break;
                    case 77:

                        break;
                    case 78:

                        break;
                    case 79:

                        break;
                    case 80:

                        break;
                    case 81:

                        break;
                    case 82:

                        break;
                    case 83:

                        break;
                    case 84:

                        break;
                    case 85:

                        break;
                    case 86:

                        break;
                    case 87:

                        break;
                    case 88:

                        break;
                    case 89:

                        break;
                    case 90:
                        break;
                    default:

                }

            }
        } );


    }

    }