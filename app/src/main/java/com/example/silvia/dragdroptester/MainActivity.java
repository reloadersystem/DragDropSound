package com.example.silvia.dragdroptester;


import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.target);

        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnLongClickListener(longClickListener);

        txt4.setOnDragListener(dragListener);


    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();


            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:


                    //tomamos un texto lo arrastramos al contenedor y lo soltamos "como es adentro"

                    break;


                case DragEvent.ACTION_DRAG_EXITED:


                    break;
                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.txt1) {

                        view.animate()
                                .x(txt4.getX())
                                .y(txt4.getY())
                                .setDuration(700)
                                .start();
                        MediaPlayer mymedia= MediaPlayer.create(MainActivity.this, R.raw.congrats);
                        mymedia.start();
                        }else
                    {
                        MediaPlayer mymedia= MediaPlayer.create(MainActivity.this, R.raw.aviso);
                        mymedia.start();

                    }

                    break;


            }

            return true;
        }
    };

}
