package com.android.example.wordlistsql;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditWordView;
    private WordListOpenHelper mDB;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mEditWordView = (EditText) findViewById(R.id.search_word);
        mTextView = (TextView) findViewById(R.id.search_result);
        mDB = new WordListOpenHelper(this);
    }

    public void showResult(View view){
        String word = mEditWordView.getText().toString();
        mTextView.setText("Result for " + word + ":\n\n");
// Search for the word in the database.
        Cursor cursor = mDB.search(word);
// Only process a non-null cursor with rows.
        if (cursor != null & cursor.getCount() > 0) {
// You must move the cursor to the first item.
            cursor.moveToFirst();
            int index;
            String result;
// Iterate over the cursor, while there are entries.
            do {
// Don't guess at the column index.
// Get the index for the named column.
                index = cursor.getColumnIndex(WordListOpenHelper.KEY_WORD);
                // Get the value from the column for the current cursor.
                result = cursor.getString(index);
                // Add result to what's already in the text view.
                mTextView.append(result + "\n");
            } while (cursor.moveToNext()); // Returns true or false
            cursor.close();
        }else if (cursor.getCount()==0){
            mTextView.append("We have no results for this search");
        }

    }
}
