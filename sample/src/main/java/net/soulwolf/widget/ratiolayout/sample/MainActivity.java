package net.soulwolf.widget.ratiolayout.sample;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private ImageView mImageView1;

    private ImageView mImageView2;

    private ImageView mImageView3;

    private ImageView mImageView4;

    private ImageView mImageView5;

    private ImageView mImageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.sample_primary);
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setNavigationBarTintResource(R.color.sample_primary);
        }
        mToolbar = (Toolbar) findViewById(R.id.tl_custom);
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);

        mImageView1 = (ImageView) findViewById(R.id.image1);
        mImageView2 = (ImageView) findViewById(R.id.image2);
        mImageView3 = (ImageView) findViewById(R.id.image3);
        mImageView4 = (ImageView) findViewById(R.id.image4);
        mImageView5 = (ImageView) findViewById(R.id.image5);
        mImageView6 = (ImageView) findViewById(R.id.image6);

        display(mImageView1,"http://img.zcool.cn/community/event/d7af5592812200000114fa2913aa.jpg");
        display(mImageView2,"http://img.zcool.cn/community/event/28b3557ac9d40000011d3aaaf42d.jpg");
        display(mImageView3,"http://img.zcool.cn/community/event/bb29557ac9d40000011d3a5bf0f8.jpg");
        display(mImageView4,"http://img.zcool.cn/community/event/a0f1557ac9d20000011d3a84d9d3.jpg");
        display(mImageView5,"http://img.zcool.cn/community/016db455c486596ac7255808750758.jpg@900w_1l");
        display(mImageView6,"http://img.zcool.cn/community/0194c255c4872d32f8755e66639626.jpg@900w_1l");
    }


    private void display(ImageView imageView,String url){
        Picasso.with(this).load(url).into(imageView);
    }
}
