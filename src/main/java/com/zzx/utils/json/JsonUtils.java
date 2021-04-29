package com.zzx.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    public static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }
}
