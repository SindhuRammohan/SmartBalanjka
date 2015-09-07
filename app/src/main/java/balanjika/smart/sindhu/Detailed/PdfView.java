package balanjika.smart.sindhu.Detailed;

import android.os.Bundle;

import com.flurry.android.FlurryAgent;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;

import balanjika.smart.sindhu.smartbalanjka.R;

public class PdfView extends PdfViewerActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		FlurryAgent.onStartSession(this, "CBNKCKVQDKCC4ZMGVJM8");
	}
	@Override
	protected void onStop() {
		super.onStop();
		FlurryAgent.onEndSession(this);
	}
	public int getPreviousPageImageResource() { return R.drawable.left_arrow; }
    public int getNextPageImageResource() { return R.drawable.right_arrow; }
    public int getZoomInImageResource() { return R.drawable.zoom_in; }
    public int getZoomOutImageResource() { return R.drawable.zoom_out; }
    public int getPdfPasswordLayoutResource() { return R.layout.pdf_file_password; }
    public int getPdfPageNumberResource() { return R.layout.dialog_pagenumber; }
    public int getPdfPasswordEditField() { return R.id.etPassword; }
    public int getPdfPasswordOkButton() { return R.id.btOK; }
    public int getPdfPasswordExitButton() { return R.id.btExit; }
    public int getPdfPageNumberEditField() { return R.id.pagenum_edit; }
}
