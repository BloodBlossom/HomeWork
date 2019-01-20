package chapter.android.aweme.ss.com.homework;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

import static chapter.android.aweme.ss.com.homework.R.layout.activity_exercise3;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    private RecyclerView NumberListView;
    private myAdapter adapter;
    public Exercises3() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        NumberListView = findViewById(R.id.rc_1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        NumberListView.setLayoutManager(layoutManager);


        List<Message> messages = null;
        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter = new myAdapter(messages);
        NumberListView.setAdapter(adapter);

    }

}
