package com.example.shoab.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by Shoab on 10/28/2015.
 */
public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
