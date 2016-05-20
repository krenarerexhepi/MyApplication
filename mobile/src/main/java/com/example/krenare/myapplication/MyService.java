package com.example.krenare.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

public class MyService extends WearableListenerService {
   @Override
    public void onDataChanged(DataEventBuffer dataEvents){
       for (DataEvent dataEvent : dataEvents){
           if(dataEvent.getType() == DataEvent.TYPE_CHANGED){
               DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
               String path = dataEvent.getDataItem().getUri().getPath();
               if(path.equals("/step-counter")){
                   int step = dataMap.getInt("step-count");
                   long time = dataMap.getLong("timestamp");
               }
           }
       }
   }
}
