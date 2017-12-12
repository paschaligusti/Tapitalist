package com.example.paschal.imageswitch;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private ImageSwitcher sw;
    TextView sw2;
    TextView sw3;
    TextView sw4;
    TextView sw5;
    TextView sw6;
    private Button nx, prv;
    Button s1, s2, s3, s4;
    Button menu1;
    private TextView money, levelshow;
    Dialog myDialog, readme, purchases;
    Timer timer_olivia = new Timer();
    Timer timer_steven = new Timer();
    Timer timer_abby = new Timer();
    Timer timer_vijay = new Timer();
    Timer timer_doug = new Timer();
    ImageView bg;
    String lvl = "Lvl: ";

    int bg1 = 0, bg2 = 0, bg3 = 0;

    Button b1,b2,b3,b4,b5;
    TextView txtclose, levelper, levelwis, levelcou, levelpat, levelluc;

    int olcount = 0;
    int stevcount = 0;
    int abcount = 0;
    int vijcount = 0;
    int dougcount = 0;

    int imgCount = 0;
    double baseIncCost = 5.00;
    double incCostMultiplier = 1.2;
    double init = 0.00;
    double incrementer = 0.1;
    double incMultiplier = 0.2;
    double levelupcost = 4.99;
    double level = 0.00;
    double levelinc = 1.00;

    double olivia = 0.7;
    double steven = 4.0;
    double abby = 10.0;
    double vijay = 40.0;
    double doug = 400.0;

    int pers = 1, luck = 1, wisd = 1, pat = 1, cour = 1, level2 = 0;

    double perscost = 100;
    double wisdcost = 500;
    double courcost = 2999.99;
    double patcost = 9999.99;
    double luckcost = 249999.99;

    double mansion = 3000000;
    double beach = 1000;
    double ski = 10000;
    double paris = 150000;
    double home = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sw = (ImageSwitcher) findViewById(R.id.imgsw);
        sw2 = (TextView) findViewById(R.id.imgsw2);
        sw3 = (TextView) findViewById(R.id.imgsw3);
        sw4 = (TextView) findViewById(R.id.imgsw4);
        sw5 = (TextView) findViewById(R.id.imgsw5);
        sw6 =(TextView) findViewById(R.id.imgsw6);

        sw2.setVisibility(View.INVISIBLE);
        sw3.setVisibility(View.INVISIBLE);
        sw4.setVisibility(View.INVISIBLE);
        sw5.setVisibility(View.INVISIBLE);
        sw6.setVisibility(View.INVISIBLE);

        prv = (Button) findViewById(R.id.get_money);
        nx = (Button) findViewById(R.id.lvlup);
        money = (TextView) findViewById(R.id.moneycount);
        levelshow = (TextView) findViewById(R.id.Level);
        myDialog = new Dialog(this);
        readme = new Dialog(this);
        purchases = new Dialog (this);
        menu1 = (Button) findViewById(R.id.menu);
        money.setText("$" + init);
        nx.setText("Level Up ($" + (String.format("%.2f", levelupcost)) + ")");
        levelshow.setText("Level " + level2);





        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                return imageView;
            }
        });

        sw.setImageResource(R.drawable.p1);

        prv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgCount == 0) {
                    sw.setImageResource(R.drawable.p2);
                    imgCount++;
                    init = init + incrementer;
                    money.setText("$" + (String.format("%.2f", init)));
                } else {
                    sw.setImageResource(R.drawable.p1);
                    imgCount--;
                    init = init + incrementer;
                    money.setText("$" + (String.format("%.2f", init)));
                }
            }
        });

        nx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (init == levelupcost || init > levelupcost) {
                    if (init - (levelupcost) >= 0.00) {
                        init = init - levelupcost;
                        money.setText("$" + (String.format("%.2f", init)));
                        level = level + (levelinc);
                        level2++;
                        levelshow.setText("Level " + level2);
                        levelupcost = baseIncCost * (Math.pow(incCostMultiplier, level2));
                        incrementer = incMultiplier * level;
                        nx.setText("Level Up ($" + (String.format("%.2f", levelupcost)) + ")");
                    }
                }

            }

        });
    }

    public void ShowPopup1 (View v) {
        money = (TextView) findViewById(R.id.moneycount);
        myDialog.setContentView(R.layout.custompopup);

        levelper = (TextView) myDialog.findViewById(R.id.level_Pers);
        levelwis = (TextView) myDialog.findViewById(R.id.level_Widsom);
        levelcou = (TextView) myDialog.findViewById(R.id.level_Courage);
        levelpat = (TextView) myDialog.findViewById(R.id.level_Patience);
        levelluc = (TextView) myDialog.findViewById(R.id.level_Luck);

        levelper.setText(lvl + pers);
        levelwis.setText(lvl + wisd);
        levelcou.setText(lvl + cour);
        levelpat.setText(lvl + pat);
        levelluc.setText(lvl + luck);

        b1 = (Button) myDialog.findViewById(R.id.button2);
        b2 = (Button) myDialog.findViewById(R.id.button3);
        b3 = (Button) myDialog.findViewById(R.id.button4);
        b4 = (Button) myDialog.findViewById(R.id.button5);
        b5 = (Button) myDialog.findViewById(R.id.button6);

        b1.setText("$" + perscost);
        b2.setText("$" + wisdcost);
        b3.setText("$" + courcost);
        b4.setText("$" + patcost);
        b5.setText("$" + luckcost);

        txtclose = (TextView) myDialog.findViewById(R.id.exit);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

        class Abby extends TimerTask {
            public void run() {
                init = init + abby;
                money.setText("$" + (String.format("%.2f", init)));

            }
        }

        class Olivia extends TimerTask {
            public void run() {
                init = init + olivia;
                money.setText("$" + (String.format("%.2f", init)));

            }
        }

        class Doug extends TimerTask {
            public void run() {
                init = init + doug;
                money.setText("$" + (String.format("%.2f", init)));

            }
        }

        class Vijay extends TimerTask {
            public void run() {
                init = init + vijay;
                money.setText("$" + (String.format("%.2f", init)));

            }
        }

        class Steven extends TimerTask {
            public void run() {
                init = init + steven;
                money.setText("$" + (String.format("%.2f", init)));

            }
        }

        final Handler handler = new Handler();
        final Timer timer2 = new Timer();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= perscost) {
                    sw2.setVisibility(View.VISIBLE);
                    init = init - perscost;
                    money.setText("$" + (String.format("%.2f", init)));

                    if (olcount == 0) {
                        olcount = olcount + 1;

                        olivia = 0.7 * pers;
                        pers++;
                        TimerTask testing = new TimerTask() {
                            @Override
                            public void run() {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        init = init + olivia;
                                        money.setText("$" + (String.format("%.2f", init)));

                                    }
                                });
                            }
                        };
                        timer2.schedule(testing, 5000, 5000);

                        perscost = 100 * (Math.pow(1.15, pers));
                        b1.setText("$" + (String.format("%.2f", perscost)));
                        levelper.setText(lvl + pers);
                    }

                    else {
                        olcount = olcount + 1;
                        timer_olivia.purge();

                        olivia = 0.7 * pers;
                        pers++;
                        timer_olivia.schedule(new Olivia(), 5000, 5000);
                        perscost = 100 * (Math.pow(1.15, pers));
                        b1.setText("$" + (String.format("%.2f", perscost)));
                        levelper.setText(lvl + pers);
                    }

                  }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= wisdcost) {

                    init = init - wisdcost;
                    steven = 4.0 * wisd;
                    wisd++;
                    money.setText("$" + (String.format("%.2f", init)));
                    sw3.setVisibility(View.VISIBLE);

                    if (stevcount < 1) {
                        stevcount = stevcount + 2;
                        timer_steven.schedule(new Steven(), 0, 5000);
                        wisdcost = 500 * (Math.pow(1.15, level));
                        b2.setText("$" + (String.format("%.2f", wisdcost)));
                        levelwis.setText(lvl + wisd);
                    }

                    else {
                        timer_steven.cancel();
                        timer_steven.purge();
                        Timer timer_steven = new Timer();
                        timer_steven.schedule(new Steven(), 0, 5000);
                        wisdcost = 500 * (Math.pow(1.15, level));
                        b2.setText("$" + (String.format("%.2f", wisdcost)));
                        levelwis.setText(lvl + wisd);
                    }
                }


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= courcost) {
                    init = init - courcost;
                    abby = 10 * cour;
                    cour++;
                    money.setText("$" + (String.format("%.2f", init)));
                    sw4.setVisibility(View.VISIBLE);

                    if (abcount < 1) {
                        abcount = abcount + 2;
                        timer_abby.schedule(new Abby(), 0, 5000);
                        courcost = 3000 * (Math.pow(1.15, cour));
                        b3.setText("$" + (String.format("%.2f", courcost)));
                        levelcou.setText(lvl + cour);
                    }

                    else {
                        timer_abby.cancel();
                        timer_abby.purge();
                        Timer timer_abby = new Timer();
                        timer_abby.schedule(new Abby(), 0, 5000);
                        courcost = 3000 * (Math.pow(1.15, cour));
                        b3.setText("$" + (String.format("%.2f", courcost)));
                        levelcou.setText(lvl + cour);

                    }
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= patcost) {
                    sw5.setVisibility(View.VISIBLE);
                    init = init - patcost;
                    vijay = 40 * pat;
                    pat++;
                    money.setText("$" + (String.format("%.2f", init)));
                    if (vijcount < 1) {
                        vijcount = vijcount + 2;
                        timer_vijay.schedule(new Vijay(), 0, 5000);
                        patcost = 10000 * (Math.pow(1.15, pat));
                        b4.setText("$" + (String.format("%.2f", patcost)));
                        levelpat.setText(lvl + pat);
                    }

                    else {
                        timer_vijay.cancel();
                        timer_vijay.purge();
                        Timer timer_vijay = new Timer();
                        timer_vijay.schedule(new Vijay(), 0, 5000);
                        patcost = 10000 * (Math.pow(1.15, pat));
                        b4.setText("$" + (String.format("%.2f", patcost)));
                        levelpat.setText(lvl + pat);
                    }
                }

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= luckcost) {
                    init = init - (luckcost);
                    doug = 400 * luck;
                    luck++;
                    sw6.setVisibility(View.VISIBLE);
                    money.setText("$" + (String.format("%.2f", init)));
                    if (dougcount < 1) {
                        dougcount = dougcount + 2;
                        timer_doug.schedule(new Doug(), 0, 5000);
                        luckcost = 250000 * (Math.pow(1.15, luck));
                        b5.setText("$" + (String.format("%.2f", luckcost)));
                        levelluc.setText(lvl + luck);
                    }
                    else {
                        timer_doug.cancel();
                        timer_doug.purge();
                        Timer timer_doug = new Timer();
                        timer_doug.schedule(new Doug(), 0, 5000);
                        luckcost = 250000 * (Math.pow(1.15, luck));
                        b5.setText("$" + (String.format("%.2f", luckcost)));
                        levelluc.setText(lvl + luck);
                    }
                }

            }
        });

    }

    public void ShowPopup2 (View v) {

        readme.setContentView(R.layout.tutorial);
        TextView title = (TextView) readme.findViewById(R.id.tutorial2);
        TextView step1 = (TextView) readme.findViewById(R.id.tutorial3);
        TextView step2 = (TextView) readme.findViewById(R.id.tutorial4);
        TextView step3 = (TextView) readme.findViewById(R.id.tutorial5);
        TextView step4 = (TextView) readme.findViewById(R.id.tutorial6);
        TextView step5 = (TextView) readme.findViewById(R.id.tutorial7);

        txtclose = (TextView) readme.findViewById(R.id.exit);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readme.dismiss();
            }
        });
        readme.show();
    }

    public void ShowPopup3 (View v) {
        bg = (ImageView) findViewById(R.id.background);
        purchases.setContentView(R.layout.purchasespopup);

        TextView title, store1, store2, store3, store4;

        title = (TextView) purchases.findViewById(R.id.store2);
        store1 = (TextView) purchases.findViewById(R.id.store3);
        store2 = (TextView) purchases.findViewById(R.id.store4);
        store3 = (TextView) purchases.findViewById(R.id.store5);
        store4 = (TextView) purchases.findViewById(R.id.store6);

        txtclose = (TextView) purchases.findViewById(R.id.exit);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchases.dismiss();
            }
        });
        purchases.show();

        s1 = (Button) purchases.findViewById(R.id.storebutton2);
        s2 = (Button) purchases.findViewById(R.id.storebutton3);
        s3 = (Button) purchases.findViewById(R.id.storebutton4);
        s4 = (Button) purchases.findViewById(R.id.storebutton5);

        s1.setText("$" + beach);
        s2.setText("$" + ski);
        s3.setText("$" + paris);




        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= beach && bg1 == 0) {
                    init = init - beach;

                    bg1++;
                    bg.setBackgroundResource(R.drawable.beach_background);
                    beach = 0;
                    s1.setText("$" + beach);
                }

                else if (bg1 == 1) {
                    bg.setBackgroundResource(R.drawable.beach_background);
                }
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= ski && bg2 == 0) {
                    init = init - ski;
                    money.setText("$" + (String.format("%.2f", init)));
                    bg2++;
                    bg.setBackgroundResource(R.drawable.snow_background);
                    ski = 0;
                    s2.setText("$" + ski);
                }

                else if (bg2 == 1) {
                    bg.setBackgroundResource(R.drawable.beach_background);
                }

            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (init >= paris && bg3 == 0) {
                    init = init - paris;
                    money.setText("$" + (String.format("%.2f", init)));
                    bg3++;
                    bg.setBackgroundResource(R.drawable.paris_background);
                    paris = 0;
                    s3.setText("$" + 0);
                }

                else if (bg3 == 1) {
                    bg.setBackgroundResource(R.drawable.beach_background);
                }

            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setBackgroundResource(R.drawable.home_background);

            }
        });

    }

}

