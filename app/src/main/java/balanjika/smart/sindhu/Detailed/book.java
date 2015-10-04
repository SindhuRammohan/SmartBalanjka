package balanjika.smart.sindhu.Detailed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import balanjika.smart.sindhu.smartbalanjka.R;

public class book extends ActionBarActivity {

    private ListView mListView;
    private BookListAdapter adapter;
    public String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mListView = (ListView) findViewById(android.R.id.list);
        String[] values = getResources().getStringArray(R.array.bookArray);
        adapter = new BookListAdapter(book.this, values);
        mListView.setAdapter(adapter);
        FloatingActionButton fab_addkd = (FloatingActionButton) findViewById(R.id.fab_addbook);
        fab_addkd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                urllinks();
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(book.this,BookPdf.class);
                fileName = mListView.getItemAtPosition(position).toString();
                intent.putExtra("KEY",fileName);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    public void urllinks(){
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse(getResources().getString(R.string.bookwebsite)));
        startActivity(myWebLink);
    }
}