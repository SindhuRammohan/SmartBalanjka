package balanjika.smart.sindhu.Detailed;

/**
 * Created by rajesh on 08-09-2015.
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import balanjika.smart.sindhu.smartbalanjka.R;

public class BookPdf extends Activity {
    private PDFView pdfView;
    private Handler handler;
    private RelativeLayout relativeDivi;
    private RelativeLayout relativenoFile;
    private InterceptionRL interceptionRl;
    private TextView tvPage;
    private Animation anim;
    private int pageMax;
    private ProgressDialog progressDialog;
    private String fileName;
    @Override
    protected void onResume() {
        super.onResume();
        BookPdf.this.activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        BookPdf.this.activityPaused();
    }
    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfview);
        handler = new Handler();
        pdfView = (PDFView) findViewById(R.id.pdfView);
        relativeDivi = (RelativeLayout) findViewById(R.id.divi);
        relativenoFile = (RelativeLayout) findViewById(R.id.llmessage);
        tvPage = (TextView) findViewById(R.id.page);
        interceptionRl = (InterceptionRL) findViewById(R.id.out);
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            fileName = extras.getString("KEY");
        }
        fileName = fileName + ".pdf";
        interceptionRl.r = new Runnable() {
            public void run() {
                if (tvPage.getVisibility() == View.INVISIBLE) {
                    tvPage.setVisibility(View.VISIBLE);
                }
                if (tvPage.getVisibility() == View.VISIBLE) {
                    tvPage.clearAnimation();
                    tvPage.startAnimation(anim);
                }
            }
        };
        anim = AnimationUtils.loadAnimation(BookPdf.this, R.anim.fadeout);
        anim.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                tvPage.setVisibility(View.INVISIBLE);
            }
        });
        update();
    }



    class Pdf extends Thread {
        boolean loaddone = false;
        File f;

        public void run() {
            if (BookPdf.this == null)
                return;
            BookPdf.this.runOnUiThread(new Runnable() {
                public void run() {
                    tvPage.setVisibility(View.GONE);
                    pdfView.setVisibility(View.GONE);
                    relativeDivi.setVisibility(View.GONE);
                    relativenoFile.setVisibility(View.GONE);
                    progressDialog = ProgressDialog.show(BookPdf.this, "",
                            getString(R.string.please_wait));
                }
            });
            try {
                AssetManager assetManager = getAssets();

                InputStream in = null;
                OutputStream out = null;
                File file = new File(getFilesDir(), fileName);
                try
                {
                    in = assetManager.open(fileName);
                    out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

                    copyFile(in, out);
                    in.close();
                    in = null;
                    out.flush();
                    out.close();
                    out = null;
                } catch (Exception e)
                {
                    Log.e("tag", e.getMessage());
                }

                File path = Environment.getExternalStorageDirectory();
                path.mkdirs();
                f = new File(getFilesDir(), fileName);
                // Demo Offline
                if ( true) {
                    f = new File(getFilesDir(), fileName);
                    handler.post(new Runnable() {
                        public void run() {
                            loaddone = true;
                            progressDialog.dismiss();

                            pdfView.fromFile(f).enableSwipe(true)
                                    .onLoad(new OnLoadCompleteListener() {
                                        public void loadComplete(int nbPages) {
                                            pageMax = nbPages;
                                            tvPage.setText(""+getString(R.string.one_of)+ " " + pageMax);
                                            tvPage.setVisibility(View.VISIBLE);
                                            tvPage.startAnimation(anim);
                                            pdfView.setVisibility(View.VISIBLE);

                                            relativeDivi
                                                    .setVisibility(View.GONE);
                                            relativenoFile
                                                    .setVisibility(View.GONE);
                                        }
                                    }).onPageChange(new OnPageChangeListener() {
                                public void onPageChanged(int page,
                                                          int pageCount) {
                                    BookPdf.this.pageMax = page;
                                    pageMax = pageCount;
                                    tvPage.setVisibility(View.VISIBLE);
                                    tvPage.setText( page +" " + getString(R.string.of)+" "
                                            + pageMax);
                                    tvPage.startAnimation(anim);
                                }
                            }).load();
                        }
                    });
                    return;
                }

            } catch (Exception e) {
            }
            File path = Environment.getExternalStorageDirectory();
            path.mkdirs();
            f = new File(path + "/"+fileName);
            f.delete();
            handler.post(new Runnable() {
                public void run() {
                    try {
                        loaddone = true;
                        progressDialog.dismiss();
                        if (isActivityVisible()) {
                            pdfView.setVisibility(View.GONE);
                            tvPage.setVisibility(View.GONE);
                            relativeDivi.setVisibility(View.VISIBLE);
                            relativenoFile.setVisibility(View.VISIBLE);
                        }
                    } catch (Exception e) {

                    }
                }
            });
        }

        private void copyFile(InputStream in, OutputStream out) throws IOException
        {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1)
            {
                out.write(buffer, 0, read);
            }
        }
    }

    public void update() {
        new Pdf().start();
    }
}
