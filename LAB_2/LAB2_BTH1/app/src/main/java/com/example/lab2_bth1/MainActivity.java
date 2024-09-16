package com.example.lab2_bth1;
import java.util.Random;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.main_layout);
        ImageView imageView = findViewById(R.id.icon_image);

        int[] colors = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5)
        };
        int[] icons = {R.drawable.icon_penguin, R.drawable.icon_cat, R.drawable.icon_dog};
        Random random = new Random();
        int randomColor = colors[random.nextInt(colors.length)];
        int randomIcon = icons[random.nextInt(icons.length)];
        layout.setBackgroundColor(randomColor);
        imageView.setImageResource(randomIcon);
    }

}