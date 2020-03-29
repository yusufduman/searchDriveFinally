package com.example.searchdrivefinally;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class DokumanAdapter extends BaseAdapter {
    private Activity activity;
    private List<Map<String, String>> dokumanListesi;

    public DokumanAdapter(Activity activity, List<Map<String, String>> dokumanListesi) {
        this.activity = activity;
        this.dokumanListesi = dokumanListesi;
    }

    @Override
    public int getCount() {
        return dokumanListesi.size();
    }

    @Override
    public Map<String, String> getItem(int position) {
        return dokumanListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.dokuman_item, parent, false);
        }

        Map<String, String> stringStringMap = dokumanListesi.get(position);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringStringMap.get("DokumanTipi"));
        stringBuilder.append("-");
        stringBuilder.append(stringStringMap.get("DokumanSevkTarihi"));
        stringBuilder.append("-");
        stringBuilder.append(stringStringMap.get("DokumanKayitEden"));

        ((TextView) convertView.findViewById(R.id.dokuman_id)).setText(stringBuilder.toString());

        return convertView;
    }
}
