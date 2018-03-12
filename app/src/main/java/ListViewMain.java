import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.smart.farmersreminder.R;
import com.example.smart.farmersreminder.Word;
import com.example.smart.farmersreminder.WordAdapter;

import java.util.ArrayList;

/**
 * Created by Smart on 22-Feb-18.
 */

public class ListViewMain extends AppCompatActivity{


    protected ListViewMain(View view) {

        setContentView(R.layout.description);
        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("10th Day","Watering"));
        words.add(new Word("12th Day","Fertilizing"));
        words.add(new Word("15th Day","Pesticides"));
        words.add(new Word("17th Day","Watering"));
        words.add(new Word("20th Day","Pesticides"));
        words.add(new Word("10th Day","Watering"));
        words.add(new Word("12th Day","Fertilizing"));
        words.add(new Word("15th Day","Pesticides"));
        words.add(new Word("17th Day","Watering"));
        words.add(new Word("20th Day","Pesticides"));
        WordAdapter desc=new WordAdapter(this,words);
        ListView listView= (ListView)findViewById(R.id.listview);
        listView.setAdapter(desc);
    }
}
