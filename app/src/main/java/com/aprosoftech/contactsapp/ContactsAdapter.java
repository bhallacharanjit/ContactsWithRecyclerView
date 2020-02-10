package com.aprosoftech.contactsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private JSONArray contactsArray;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView contact_name, contact_number;

        public MyViewHolder(View view) {
            super(view);
            contact_name = (TextView) view.findViewById(R.id.contact_name);
            contact_number = (TextView) view.findViewById(R.id.contact_number);
        }
    }



    public ContactsAdapter(JSONArray contactsArray) {
        this.contactsArray = contactsArray;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_contact, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        try {
            JSONObject tempContactObject = this.contactsArray.getJSONObject(position);
            holder.contact_name.setText(tempContactObject.getString("name"));
            holder.contact_number.setText(tempContactObject.getString("number"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return this.contactsArray.length();
    }



    public void notifyChanged(JSONArray contactsArray) {
        this.contactsArray = contactsArray;
        this.notifyDataSetChanged();
    }


}
