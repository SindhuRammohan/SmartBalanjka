package dbhelper;

import android.app.Application;


import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import balanjika.smart.sindhu.smartbalanjka.R;

@ReportsCrashes(
        formKey = "",
        formUri = "http://somewhere.com",
        	mailTo = "sindhusargunam@gmail.com",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_report // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds

)
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();
    }

}
