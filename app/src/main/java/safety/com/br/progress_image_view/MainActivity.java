package safety.com.br.progress_image_view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import safety.com.br.progressimageview.ProgressImageView;
import safety.com.br.progressimageview.animations.CircleTransform;

public class MainActivity extends AppCompatActivity {

    private ProgressImageView progressImageViewAutoHide;
    private ProgressImageView hideFromAEvent;
    private ProgressImageView progressImageOffSet;
    private ProgressImageView progressImageColorAndSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressImageViewAutoHide();

        progressImageViewFromAEvent();

        progressImageViewOffSet();

        progressImageColorAndSize();
    }

    private void progressImageColorAndSize() {
        progressImageColorAndSize = (ProgressImageView) findViewById(R.id.progress_image_view_color_and_size);

        progressImageColorAndSize.showLoading().withAutoHide(false).withBorderColor(Color.RED).withBorderSize(10);

        Picasso picasso = Picasso.with(MainActivity.this);
        picasso.invalidate("https://randomuser.me/api/portraits/men/83.jpg");
        picasso.load("https://randomuser.me/api/portraits/men/83.jpg")
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(progressImageColorAndSize);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                progressImageColorAndSize.hideLoading();

            }
        }, 5000);
    }

    private void progressImageViewOffSet() {
        progressImageOffSet = (ProgressImageView) findViewById(R.id.progress_image_view_offset);

        progressImageOffSet.showLoading().withAutoHide(false).withBorderColor(Color.BLUE).withOffset(10);

        Picasso picasso = Picasso.with(MainActivity.this);
        picasso.invalidate("https://randomuser.me/api/portraits/men/83.jpg");
        picasso.load("https://randomuser.me/api/portraits/men/83.jpg")
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(progressImageOffSet);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                progressImageOffSet.hideLoading();

            }
        }, 5000);

    }

    private void progressImageViewFromAEvent() {
        hideFromAEvent = (ProgressImageView) findViewById(R.id.progress_image_view_hide);

        hideFromAEvent.showLoading().withAutoHide(false).withBorderColor(Color.BLUE);

        Picasso picasso = Picasso.with(MainActivity.this);
        picasso.invalidate("https://randomuser.me/api/portraits/men/83.jpg");
        picasso.load("https://randomuser.me/api/portraits/men/83.jpg")
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(hideFromAEvent);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                hideFromAEvent.hideLoading();

            }
        }, 5000);

    }

    private void progressImageViewAutoHide() {
        progressImageViewAutoHide = (ProgressImageView) findViewById(R.id.progress_image_view);
        progressImageViewAutoHide.showLoading();

        Picasso picasso = Picasso.with(MainActivity.this);
        picasso.invalidate("http://blog.alura.com.br/wp-content/uploads/2016/06/java_capa.jpg");
        picasso.load("http://blog.alura.com.br/wp-content/uploads/2016/06/java_capa.jpg")
                .transform(new CircleTransform())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(progressImageViewAutoHide);
    }

}
