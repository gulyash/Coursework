package com.example.gulnara.fsbeta;


/**
 * Created by Gulnara on 24.05.2016.
 *  тут всякий кривой код из старого проекта с кривыми названиями классов,
 *  который я пока не прикрутила, но он будет в том или ином виде
 *
 *  суть надо прикрутить во вторую вкладку вьюпейджер с несколькими фрагментами-списками,
 *  которые будут обновляться после диалога на первой вкладке. Вьюпейждер не должен конфликтовать
 *  с тем, который управляет тремя вкладками
 */
public class Dump {
    //////////////////////////////////////////////////////////////////////////////////
    /*
    пыталась перегрузить, чтобы вкладки не свайпили, почему-то прилодение крашилось
    public class NonSwipeableViewPager extends ViewPager {
        public NonSwipeableViewPager(Context context) {
            super(context);
        }

        public NonSwipeableViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
            // Never allow swiping to switch between pages
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // Never allow swiping to switch between pages
            return false;
        }
    }
     */

   ///////////////////////////////////////////////////////////////////////////////////////////////////////



    //Это адаптер для одного списка, которых должно выводиться несколько на второй вкладке

  //  public class SecondTabAdapter extends BaseAdapter {
 /*
        Context context;
        ArrayList<CheckDish> rowItem;

        SecondTabAdapter(Context context, ArrayList<CheckDish> rowItem) {
            this.context = context;
            this.rowItem = rowItem;
        }

        @Override
        public int getCount() {
            return rowItem.size();
        }

        @Override
        public Object getItem(int position) {
            return rowItem.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=convertView;
            if (view == null) {
                LayoutInflater mInflater = (LayoutInflater) context
                        .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                view = mInflater.inflate(R.layout.second_tab_box, null);
            }

            TextView txtDishName = (TextView) view.findViewById(R.id.dishName);
            //TextView txtAmount = (TextView) view.findViewById(R.id.dishAmount);
            TextView txtPrice = (TextView) view.findViewById(R.id.dishPrice);
            CheckBox cbBuy = (CheckBox) view.findViewById(R.id.checkBox);
            // присваиваем чекбоксу обработчик
            cbBuy.setOnCheckedChangeListener(myCheckChangList);
            // пишем позицию
            cbBuy.setTag(position);
            // заполняем данными из товаров: в корзине или нет


            CheckDish row_pos = rowItem.get(position);

            cbBuy.setChecked(row_pos.box);


            txtDishName.setText(row_pos.getName());
            txtPrice.setText(row_pos.getPrice());

            return view;
        }

        // обработчик для чекбоксов
        CompoundButton.OnCheckedChangeListener myCheckChangList = new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // меняем данные товара (в корзине или нет)
                Dishes.guestchoice.get((Integer) buttonView.getTag()).box = isChecked;
            }
        };
          */
   // }


    ///////////////////////////////////////////////////////////
//Это класс для отображения одного из списков второй вкладки, его точно надо переименовать
/*

    public class SecondTab  extends ListFragment {

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            ((MainActivity)getActivity()).secondTabAdapter = new SecondTabAdapter(getActivity(), Dishes.guestchoice);
            getListView().setAdapter(((MainActivity)getActivity()).secondTabAdapter);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.second_tab_layout, null);
        }


    }
*/
    ////////////////////////////////////////////////////////////////////////

    //хмл для отображения списков из второй вкладки
/*
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingLeft="8dp"
    android:paddingRight="8dp" >

    <ListView
        android:id="@id/android:list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:choiceMode="multipleChoice"
        android:drawSelectorOnTop="false" />

    <TextView
        android:id="@id/android:empty"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="No data" />

</LinearLayout>

 */
/////////////////////////////////////////////////////////////////////////////////////
    /*
    хмл для пункта списка

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:weightSum="1">

    <LinearLayout
        android:orientation="vertical"
        android:layout_width="218dp"
        android:layout_height="64dp"
        android:layout_weight="0.88">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="New Text"
            android:id="@+id/dishPrice"
            android:gravity="top|right"
            android:layout_alignParentStart="true"
            android:layout_alignParentTop="true"
            android:layout_gravity="right" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="New Text"
            android:id="@+id/dishName"
            android:gravity="left|center_vertical" />

    </LinearLayout>

    <CheckBox
        android:layout_width="wrap_content"
        android:layout_height="74dp"
        android:id="@+id/checkBox" />
</LinearLayout>
     */



}
