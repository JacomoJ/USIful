package com.example.digitalprototype;

import android.content.ClipData;
import android.media.Image;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Toast;

public class PriorityList extends AppCompatActivity {

    private int posCounter;

    // define activity icon here
    private ImageView clicked;

    // retrieve activity icons from Resources by their own ID
    private ImageView study;
    private ImageView bicycle;
    private ImageView movie;
    private ImageView billiard;
    private ImageView dance;
    private ImageView restaurant;
    private ImageView gym;
    private ImageView videogame;
    private ImageView yoga;

    // define position hole icon here
    private ImageView position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_priority_list);

        posCounter = 1;

        study = (ImageView) findViewById(R.id.study);
        bicycle = (ImageView) findViewById(R.id.bicycle);
        movie = (ImageView) findViewById(R.id.movie);
        billiard = (ImageView) findViewById(R.id.billiard);
        dance = (ImageView) findViewById(R.id.dance);
        restaurant = (ImageView) findViewById(R.id.restaurant);
        gym = (ImageView) findViewById(R.id.gym);
        videogame = (ImageView) findViewById(R.id.videogame);
        yoga = (ImageView) findViewById(R.id.yoga);

        // activate the first priority to listen the drag
        activatePosition();

        // set onClickListener for each activity icon clicked here
        study.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = study;
                return true;
            }
        });
        bicycle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = bicycle;
                return true;
            }
        });
        movie.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = movie;
                return true;
            }
        });
        billiard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = billiard;
                return true;
            }
        });
        dance.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = dance;
                return true;
            }
        });
        restaurant.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = restaurant;
                return true;
            }
        });
        gym.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = gym;
                return true;
            }
        });
        videogame.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = videogame;
                return true;
            }
        });
        yoga.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                clicked = yoga;
                return true;
            }
        });
    }

    private class TargetDragListener implements View.OnDragListener {

        private boolean hit;
        private int emptyShape;

        public TargetDragListener(int emptyShape) {
            this.emptyShape = emptyShape;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            final ImageView containerView = (ImageView) v;
            final ImageView draggedView = (ImageView) event.getLocalState();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    hit = false;
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // for the time being it is a replica of default case
                    // Log.d(TAG, "onDrag: ACTION_DRAG_ENTERED");
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    // for the time being it is a replica of default case
                    // Log.d(TAG, "onDrag: ACTION_DRAG_EXITED");
                    return true;
                case DragEvent.ACTION_DROP:
                    draggedView.setVisibility(View.VISIBLE);
                    rearrangeIcons(draggedView, containerView);
                    containerView.setImageResource(emptyShape);
                    incrementPosition();
                    activatePosition();
                    hit = true;
                    /*
                    draggedView.post(new Runnable() {
                        @Override
                        public void run() {
                            draggedView.setVisibility(View.GONE);
                        }
                    });
                    */
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setVisibility(View.VISIBLE);
                    if (!hit) {
                        draggedView.post(new Runnable() {
                            @Override
                            public void run() {
                                draggedView.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    return true;
                default:
                    return true;
            }
        }
    }

    private void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void rearrangeIcons(ImageView dragged, ImageView target) {
        LayoutParams params = (LayoutParams) target.getLayoutParams();
        params.height = 150;
        params.width = 150;
        dragged.setLayoutParams(params);

    }

    private void incrementPosition() {
        if (posCounter < 7) {
            posCounter++;
        } else {
            posCounter = 0;
        }
    }

    private void activatePosition() {
        switch (posCounter) {
            case 1:
                position = (ImageView) findViewById(R.id.position1);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case 2:
                position = (ImageView) findViewById(R.id.position2);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case 3:
                position = (ImageView) findViewById(R.id.position3);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case 4:
                position = (ImageView) findViewById(R.id.position4);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case 5:
                position = (ImageView) findViewById(R.id.position5);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case 6:
                position = (ImageView) findViewById(R.id.position6);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            case 7:
                position = (ImageView) findViewById(R.id.position7);
                position.setOnDragListener(new TargetDragListener(R.drawable.empty_shape));
                position.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clicked.setVisibility(View.VISIBLE);
                    }
                });
                break;
            default:
                break;
        }
    }
}
