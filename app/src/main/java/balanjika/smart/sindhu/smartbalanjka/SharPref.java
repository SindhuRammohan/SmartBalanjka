package balanjika.smart.sindhu.smartbalanjka;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharPref  {

    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;
    public SharPref(Context context){
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefsEditor = prefs.edit();
        // then you use
    }
    private static SharPref instance;

    public static SharPref getInstance(Context context) {
        if (instance == null) {
            synchronized (SharPref.class) {
                if (instance == null) {
                    instance = new SharPref(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public static SharPref getInstance() {
        if (instance == null) {
            throw new IllegalStateException(
                    "You have to call getInstance with context to init preference first!");
        } else {
            return instance;
        }
    }

    public String getUsername(){
        return prefs.getString("username", null);
    }
    public String getPassword(){
        return prefs.getString("password", null);
    }
    public String getMailUsername(){
        return prefs.getString("mailusername", null);
    }
    public String getMailPassword(){
        return prefs.getString("mailpassword", null);
    }
    public String getTempMailUsername(){
        return prefs.getString("mailusername", null);
    }
    public String getTempMailPassword(){
        return prefs.getString("mailpassword", null);
    }

    public void setUsername(String username){
        prefsEditor.putString("username", username);
        prefsEditor.commit();
    }
    public void setPassword(String password){
        prefsEditor.putString("password", password);
        prefsEditor.commit();
    }
    public void setMailUsername(String mailusername){
        prefsEditor.putString("mailusername", mailusername);
        prefsEditor.commit();
    }
    public void setMailPassword(String mailpassword){
        prefsEditor.putString("mailpassword", mailpassword);
        prefsEditor.commit();
    }

    public void setTempMailUsername(String mailusername){
        prefsEditor.putString("mailusername", mailusername);
        prefsEditor.commit();
    }
    public void setTempMailPassword(String mailpassword){
        prefsEditor.putString("mailpassword", mailpassword);
        prefsEditor.commit();
    }
}
