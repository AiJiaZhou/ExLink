package com.xloger.exlink.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.xloger.exlink.app.R;
import com.xloger.exlink.app.entity.App;

import java.util.List;

/**
 * Created by xloger on 1月3日.
 * Author:xloger
 * Email:phoenix@xloger.com
 */
public class AppAdapter extends BaseAdapter {
    private Context context;
    private List<App> appList;

    public AppAdapter(Context context, List<App> appList) {
        this.context = context;
        this.appList = appList;
    }

    @Override
    public int getCount() {
        if (appList != null) {
            return appList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;
        if (convertView == null) {
            ret = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        }else {
            ret=convertView;
        }

        ViewHolder viewHolder= (ViewHolder) ret.getTag();
        if (viewHolder == null) {
            viewHolder=new ViewHolder();
            viewHolder.use= (CheckBox) ret.findViewById(R.id.app_use);
            viewHolder.name= (TextView) ret.findViewById(R.id.app_name);
            viewHolder.packageName= (TextView) ret.findViewById(R.id.app_package_name);
            ret.setTag(viewHolder);
        }

        viewHolder.use.setChecked(appList.get(position).isUse());
        viewHolder.name.setText(appList.get(position).getAppName());
        viewHolder.packageName.setText(appList.get(position).getPackageName());

        return ret;
    }

    private class ViewHolder{
        public CheckBox use;
        public TextView name;
        public TextView packageName;
    }
}
