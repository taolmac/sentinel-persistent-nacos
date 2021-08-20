package com.taos.extension.sentinelrulepush.converter;

import com.alibaba.cloud.sentinel.datasource.converter.JsonConverter;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * json 转换器
 */
public class FlowParamJsonConverter extends JsonConverter {
    Class ruleClass;

    public FlowParamJsonConverter(ObjectMapper objectMapper, Class ruleClass) {
        super(objectMapper, ruleClass);
        this.ruleClass = ruleClass;
    }

    @Override
    public Collection<Object> convert(String source) {
        List<Object> list = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(source);
        for (int i = 0; i < jsonArray.size(); i++) {
            //解析rule属性
            JSONObject jsonObject = (JSONObject) jsonArray.getJSONObject(i).get("rule");
            Object object = JSON.toJavaObject(jsonObject, ruleClass);
            list.add(object);
        }
        return list;
    }
}
