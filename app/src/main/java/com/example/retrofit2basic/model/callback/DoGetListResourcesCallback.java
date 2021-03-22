package com.example.retrofit2basic.model.callback;

import android.util.Log;

import com.example.retrofit2basic.MainActivity;
import com.example.retrofit2basic.model.MultipleResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoGetListResourcesCallback implements Callback<MultipleResource> {

    private MainActivity context;

    public DoGetListResourcesCallback(MainActivity context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
        Log.d("TAG:GET List onResponse",response.code() + "");

        String displayResponse = "";

        MultipleResource resource = response.body();
        Integer text = resource.page;
        Integer total = resource.total;
        Integer totalPages = resource.totalPages;
        List<MultipleResource.Datum> datumList = resource.data;

        displayResponse += text + " Page\n"
                + total + " Total\n"
                + totalPages + " Total Pages\n";

        for (MultipleResource.Datum datum : datumList) {
            displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
        }
        context.getResponseText().setText(displayResponse);
    }

    @Override
    public void onFailure(Call<MultipleResource> call, Throwable t) {
        call.cancel();
    }
}
