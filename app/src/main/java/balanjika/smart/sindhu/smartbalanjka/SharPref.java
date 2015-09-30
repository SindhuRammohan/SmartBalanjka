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




    public String getTempgender(){
        return prefs.getString("gender", null);
    }

    public void setgender(String gender){
        prefsEditor.putString("gender", gender);
        prefsEditor.commit();
    }

    public String getTempaddress(){
        return prefs.getString("address", null);
    }

    public void setaddress(String address){
        prefsEditor.putString("address", address);
        prefsEditor.commit();
    }

    public String getTempCity(){
        return prefs.getString("City", null);
    }

    public void setCity(String City){
        prefsEditor.putString("City", City);
        prefsEditor.commit();
    }

    public String getTempDistrict(){
        return prefs.getString("District", null);
    }

    public void setDistrict(String District){
        prefsEditor.putString("District", District);
        prefsEditor.commit();
    }

    public String getTempCountry(){
        return prefs.getString("Country", null);
    }

    public void setCountry(String Country){
        prefsEditor.putString("Country", Country);
        prefsEditor.commit();
    }

    public String getTempphone(){
        return prefs.getString("phone", null);
    }

    public void setphone(String phone){
        prefsEditor.putString("phone", phone);
        prefsEditor.commit();
    }

    public String getTempblood(){
        return prefs.getString("blood", null);
    }

    public void setblood(String blood){
        prefsEditor.putString("blood", blood);
        prefsEditor.commit();
    }



    public String getTempdob(){
        return prefs.getString("dob", null);
    }

    public void setdob(String dob){
        prefsEditor.putString("dob", dob);
        prefsEditor.commit();
    }

    public String getTempstatus(){
        return prefs.getString("status", null);
    }

    public void setstatus(String status){
        prefsEditor.putString("status", status);
        prefsEditor.commit();
    }

    public String getTempstatusdate(){
        return prefs.getString("statusdate", null);
    }

    public void setstatusdate(String statusdate){
        prefsEditor.putString("statusdate", statusdate);
        prefsEditor.commit();
    }

    public String getTempMail(){
        return prefs.getString("Mail", null);
    }

    public void setTempMail(String Mail){
        prefsEditor.putString("Mail", Mail);
        prefsEditor.commit();
    }

    public String getTempAbout(){
        return prefs.getString("About", null);
    }


    public void setAbout(String About){
        prefsEditor.putString("About", About);
        prefsEditor.commit();
    }

    public String getTempquestion(){
        return prefs.getString("question", null);
    }

    public void setquestion(String question){
        prefsEditor.putString("question", question);
        prefsEditor.commit();
    }

    public String getTempanswer(){
        return prefs.getString("answer", null);
    }

    public void setanswer(String answer){
        prefsEditor.putString("answer", answer);
        prefsEditor.commit();
    }


    public String getTempRashi(){
        return prefs.getString("Rashi", null);
    }

    public void setRashi(String Rashi){
        prefsEditor.putString("Rashi", Rashi);
        prefsEditor.commit();
    }

    public String getTempNakthara(){
        return prefs.getString("Nakthara", null);
    }

    public void setNakthara(String Nakthara){
        prefsEditor.putString("Nakthara", Nakthara);
        prefsEditor.commit();
    }

    public String getTempQualification(){
        return prefs.getString("Qualification", null);
    }

    public void setQualification(String Qualification){
        prefsEditor.putString("Qualification", Qualification);
        prefsEditor.commit();
    }

    public String getTempWork(){
        return prefs.getString("Work", null);
    }

    public void setWork(String Work){
        prefsEditor.putString("Work", Work);
        prefsEditor.commit();
    }

    public String getTempHeight(){
        return prefs.getString("Height", null);
    }

    public void setTempHeight(String Height){
        prefsEditor.putString("Height", Height);
        prefsEditor.commit();
    }

    public String getTempWeight(){
        return prefs.getString("Weight", null);
    }

    public void setWeight(String Weight){
        prefsEditor.putString("Weight", Weight);
        prefsEditor.commit();
    }



    public void setNotes(String Notes){
        prefsEditor.putString("Notes", Notes);
        prefsEditor.commit();
    }

    public String getTempNotes(){
        return prefs.getString("Notes", null);
    }

    public void setMatrimonyType(int MatrimonyType){
        prefsEditor.putInt("MatrimonyType", MatrimonyType);
        prefsEditor.commit();
    }

    public int getMatrimonyType(){
        return prefs.getInt("MatrimonyType", 0);
    }
}
