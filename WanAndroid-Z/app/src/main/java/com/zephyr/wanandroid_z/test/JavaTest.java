package com.zephyr.wanandroid_z.test;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zephyr.wanandroid_z.common.App;
import com.zephyr.wanandroid_z.ui.search.SearchActivity;

import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zephyr on 2020/12/8 10 : 10
 */
class JavaTest {

    public void test1() {
        List<? extends TextView> list1 = new ArrayList<>();
        TextView textView = list1.get(0);// success
//        TextView textView1 = new TextView(App.Companion.getAppContext());
//        list1.add(textView1); // error > extends TextView不能确定是什么具体类型，所以不能往里添加
        // 只能往外拿数据，称为生产者-extends


        List<? super Button> list2 = new ArrayList<>();
        Object object = list2.get(0); // success 可以拿出来，但是只能是Object类型，可以自己强转，但是不安全,所以一般不是这种用途

//        TextView tv = new TextView(App.Companion.getAppContext());
//        list2.add(tv);// error 只能方下界确定的类型

        RadioButton rb = new RadioButton(App.Companion.getAppContext());
        list2.add(rb);

        Button btn = new Button(App.Companion.getAppContext());
        list2.add(btn); // success 下界是确定的为button，所以只能往里放button
        // 一般只用于把数据add进去，成为消费者-super

        Class<SearchActivity> aClass = SearchActivity.class;
    }
}
