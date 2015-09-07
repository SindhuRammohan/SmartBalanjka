package balanjika.smart.sindhu.Detailed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import balanjika.smart.sindhu.smartbalanjka.R;

/**
 * Created by rajesh on 07-09-2015.
 */
public class book extends Activity {

    private ListView mListView;
    private BookListAdapter adapter;
    public String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);
        mListView = (ListView) findViewById(android.R.id.list);
        String[] values = getResources().getStringArray(R.array.bookArray);
        adapter = new BookListAdapter(book.this, values);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(book.this,BookPdf.class);
//based on item add info to intent
                fileName = mListView.getItemAtPosition(position).toString();
                intent.putExtra("KEY",fileName);
                startActivity(intent);

            }
        });
    }
}