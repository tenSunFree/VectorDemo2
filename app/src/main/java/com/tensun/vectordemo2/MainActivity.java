package com.tensun.vectordemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Q: 如何把圖片格式, 轉成SVG?
 * A: 可以透過VMDE, 簡單將圖片格式轉成SVG
 *
 * Q: 如何把svg格式的圖片, 在AS中呈現?
 * A: 1. 先取得該圖片的相關訊息, 直接把圖片丟到 http://inloop.github.io/svg2android/, 以取得相關訊息
 *      2. 在drawable 創建一個xml, 貼上相關訊息即可
 *
 * Q: 如何讓圖片呈現動畫?
 * A: 1. 首先 你需要一組svg相關訊息, 來呈現你想要的向量圖
 *      2. 然後在xml 新增RichPathView, 把向量圖放上面
 *      3. 最後在class 設定相關動畫參數, 可以參考 https://github.com/tarek360/RichPath
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.egg_brother)
    RichPathView eggBrother;                                                                                            // 實體化 RichPathView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void animatePhoneGirl(View view) {                                                                           // 對應xml的onClick, 方法參數記得添加View

        final RichPath heart = eggBrother.findRichPathByName("heart");                                                  // 取得想要做成動畫的path部分

        heart.setPivotToCenter(true);                                                                                   // 讓動畫的呈現位置 保持在中間

        RichPathAnimator
                .animate(heart)                                                                                          // 對heart 設置動畫
                .interpolator(new DecelerateInterpolator())                                                             // 設置插值器
                .duration(900)                                                                                          // 每一次的耗時
                .repeatMode(RichPathAnimator.RESTART)
                .repeatCount(2)                                                                                         // 重複運行的次數
                .scale(1f, 1.07f, 1f)                                                                                   // 縮放
                .start();
    }
}
