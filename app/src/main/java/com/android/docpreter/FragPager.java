package com.android.docpreter;

import android.icu.text.Edits;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.parser.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class FragPager extends FragmentStateAdapter {
    public FragPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new InEffect();
            case 1:
                return new ToAdd();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static JSONObject JParser(InputStream it){
        BufferedReader reader = new BufferedReader(new InputStreamReader(it));
        StringBuilder builder = new StringBuilder();
        JSONObject jObj = null;
        String curLine;
        try{
            while((curLine=reader.readLine())!=null){
                builder.append(curLine);

            }
            JSONTokener tokener = new JSONTokener(builder.toString());
            jObj =  new JSONObject(tokener);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jObj;
    }
    public static  void JSolver(JSONArray jRay) throws JSONException {
        ArrayList<JSONObject> jObs = new ArrayList<>();
        for(int i=0; i<jRay.length();i++){
            jObs.add((JSONObject) jRay.get(i));
        }
        for(int j=0; j<jObs.size(); j++){
            System.out.println("medName"+jObs.get(j).get("mname"));
        }
    }
}
