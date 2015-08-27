package DBHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private Context mycontext;
    public static final String DATABASE_NAME = "SmartBalanjika.sqlite";
    public static final String CONTACTS_TABLE_NAME = "Profile";
    public static final String CONTACTS_COLUMN_ID = "ID";
    public static final String CONTACTS_COLUMN_NAME = "mail_id";
    public static final String CONTACTS_COLUMN_EMAIL = "mail_password";
    //private String DB_PATH = mycontext.getApplicationContext().getPackageName()+"/databases/";
    private static String DB_NAME = "SmartBalanjika.sqlite";//the extension may be .sqlite or .db
    public SQLiteDatabase myDataBase;

    private String DB_PATH = "/data/data/"
            + "balanjika.smart.sindhu.smartbalanjka"
            + "/databases/";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
//        db.execSQL(
//                "create table Profile " +
//                        "(id integer primary key, name text,phone text,email text, street text,place text)"

        db.execSQL(


                "create table Profile " +
                        "(ID INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , mail_id TEXT NOT NULL , mail_password TEXT NOT NULL , username TEXT NOT NULL , password TEXT NOT NULL )"




        );




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS Profile");
        onCreate(db);
    }
    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Profile where ID="+id+"", null );
        return res;
    }

    public DBHelper(Context context) {
        super(context,DB_NAME,null,1);
        this.mycontext=context;
        boolean dbexist = checkdatabase();
        if (dbexist) {
            //System.out.println("Database exists");
            opendatabase();
            Log.d("DB_PATH", "DB_PATH" + DB_PATH);
        } else {
            Log.d("DB_PATH","DB_PATH" +DB_PATH );
            System.out.println("Database doesn't exist");
            createdatabase();
        }
    }

    public void createdatabase() {
        boolean dbexist = checkdatabase();
        if(dbexist) {
            //System.out.println(" Database exists.");
        } else {
            this.getReadableDatabase();
            try {
                copydatabase();
            } catch(IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkdatabase() {
        //SQLiteDatabase checkdb = null;
        boolean checkdb = false;
        try {
            String myPath = DB_PATH + DB_NAME;
            File dbfile = new File(myPath);
            //checkdb = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
            checkdb = dbfile.exists();
        } catch(SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    private void copydatabase() throws IOException {
        //Open your local db as the input stream
        InputStream myinput = mycontext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outfilename = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myoutput = new FileOutputStream("/data/data/(packagename)/databases   /(datbasename).sqlite");

        // transfer byte to inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer))>0) {
            myoutput.write(buffer,0,length);
        }

        //Close the streams
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    public void opendatabase() throws SQLException {
        //Open the database
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if(myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }

}