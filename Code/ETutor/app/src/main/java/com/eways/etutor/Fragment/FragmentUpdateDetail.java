package com.eways.etutor.Fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.eways.etutor.Adapter.DialogImageAdapter;
import com.eways.etutor.Model.ImageDialogPlus;
import com.eways.etutor.R;
import com.eways.etutor.views.DialogPlus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUpdateDetail extends Fragment implements View.OnClickListener {
    /* VIEWS */
    DialogPlus dialogPlus;
    EditText datePicker;
    ImageView imgAvarta;

    public FragmentUpdateDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_update_detail, container, false);
        declare_views(root);
        handle_views();

        return root;
    }

    public void declare_views(View root){
        datePicker = root.findViewById(R.id.date_picker);
        imgAvarta = root.findViewById(R.id.avarta);
    }

    public void handle_views(){
        setUpDatePicker();

        imgAvarta.setOnClickListener(this);

    }

    public void setUpDatePicker(){
        datePicker.setSelected(false);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalendar.set(Calendar.YEAR, i);
                myCalendar.set(Calendar.MONTH, i1);
                myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                updateDate(myCalendar);
            }
        };

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void updateDate(Calendar calendar){
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        datePicker.setText(sdf.format(calendar.getTime()));
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.avarta:

                ArrayList<ImageDialogPlus> listChoose = new ArrayList<>();
                listChoose.add(new ImageDialogPlus(0, R.drawable.icn_camera, "Máy ảnh"));
                listChoose.add(new ImageDialogPlus(1, R.drawable.icn_gallery, "Bộ sưu tập"));
                DialogImageAdapter dialogImageAdapter = new DialogImageAdapter(getActivity(), R.layout.item_select_image, listChoose );
                DialogPlus dialogPlus = new DialogPlus(getActivity(), dialogImageAdapter, this);
                dialogPlus.showDialog();
                break;
        }
    }
}
