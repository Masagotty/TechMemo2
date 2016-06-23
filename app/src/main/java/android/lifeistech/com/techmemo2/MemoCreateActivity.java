package android.lifeistech.com.techmemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoCreateActivity extends AppCompatActivity {

    MemoDB mMemoDB;
    EditText mTitle;
    EditText mMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_create);
        Toolbar memoCreateToolbar = (Toolbar) findViewById(R.id.memoCreate_toolbar);
        setSupportActionBar(memoCreateToolbar);

        mTitle = (EditText) findViewById(R.id.create_title);
        mMemo = (EditText) findViewById(R.id.create_memo);
        mMemoDB = new MemoDB();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (R.id.create_save == id) {
            saveMemo();
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void saveMemo(){
        mMemoDB.title = mTitle.getText().toString();
        mMemoDB.memo = mMemo.getText().toString();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ", Locale.JAPANESE);
        mMemoDB.date = sdf.format(date);
        mMemoDB.save();
    }

}
