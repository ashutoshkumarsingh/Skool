package education.skool.nsit.skool.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import education.skool.nsit.skool.Models.CheckboxModel;
import education.skool.nsit.skool.R;

/**
 * Created by ashu on 11/2/18.
 */

public class CheckboxAdapter extends ArrayAdapter {

    CheckboxModel[] modelItems = null;
    Context context;

    public CheckboxAdapter(Context context, CheckboxModel[] resource) {
        super(context, R.layout.abc_checkbox_layout,resource);

        this.context = context;
        this.modelItems = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.abc_checkbox_layout, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView_module);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox_module);
        name.setText(modelItems[position].getName());
        if(modelItems[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        return convertView;
    }
}