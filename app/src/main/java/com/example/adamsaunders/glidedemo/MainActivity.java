package com.example.adamsaunders.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    private Button BasicButton;
    private Button OversizeButton;
    private Button RescaleButton;
    private Button PlaceholderButton;
    private Button CropButton;
    private Button GifButton;
    private ImageView ImageViewer;
    private ImageView TinyViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BasicButton = findViewById(R.id.basicButton);
        OversizeButton = findViewById(R.id.oversizeButton);
        RescaleButton = findViewById(R.id.rescaleButton);
        PlaceholderButton = findViewById(R.id.placeholderButton);
        CropButton = findViewById(R.id.cropButton);
        GifButton = findViewById(R.id.gifButton);
        ImageViewer = findViewById(R.id.imageViewer);
        TinyViewer = findViewById(R.id.tinyViewer);

        BasicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearImages();

                // The area you configure your requests for glide
                // in this case I ask it to use its original dimensions
                RequestOptions myOptions = new RequestOptions()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) ;

                // Actual Calls are super simple with 4 main parts
                // .with determines the activity scope
                // .load is the file to get
                // .apply sets the options you declared earlier
                // .into is where you wish to put the image
                Glide.with(MainActivity.this)
                        .load("http://dipwizard.com/wp-content/uploads/DipWizard-Logo.png")
                        .apply(myOptions)
                        .into(ImageViewer);
            }
        });

        OversizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearImages();

                RequestOptions myOptions = new RequestOptions()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) ;

                Glide.with(MainActivity.this)
                        .load("http://www.conceptart.org/forums/attachment.php?s=4465977d31224eac78a0c0a27ae28f99&attachmentid=1925656&d=1394077567")
                        .apply(myOptions)
                        .into(ImageViewer);
            }
        });

        RescaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearImages();

                RequestOptions myOptions = new RequestOptions()
                        .override(900, 900);

                Glide.with(MainActivity.this)
                        .load("http://www.conceptart.org/forums/attachment.php?s=4465977d31224eac78a0c0a27ae28f99&attachmentid=1925656&d=1394077567")
                        .apply(myOptions)
                        .into(ImageViewer);

            }
        });

        PlaceholderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearImages();

                // Placeholders are Drawables that are shown while a request is in progress. When a request completes successfully, the placeholder is replaced with the requested resource.
                RequestOptions myOptions = new RequestOptions()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .placeholder(R.drawable.construction);

                Glide.with(MainActivity.this)
                        .load("http://www.badurlz.org/gibberish")
                        .apply(myOptions)
                        .into(ImageViewer);
            }
        });

        CropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearImages();

                RequestOptions myOptions = new RequestOptions()
                        .centerCrop();

                Glide.with(MainActivity.this)
                        .load("http://www.conceptart.org/forums/attachment.php?s=4465977d31224eac78a0c0a27ae28f99&attachmentid=1925656&d=1394077567")
                        .apply(myOptions)
                        .into(TinyViewer);
            }
        });

        GifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearImages();

                RequestOptions myOptions = new RequestOptions()
                        .override(800, 800) ;

                Glide.with(MainActivity.this)
                        .load("https://media.giphy.com/media/lzGerSGUsyzhC/giphy.gif")
                        .apply(myOptions)
                        .into(ImageViewer);

            }
        });
    }

    private void ClearImages()
    {
        TinyViewer.setImageResource(0);
        ImageViewer.setImageResource(0);
    }
}
