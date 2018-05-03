package com.eduboooks.test.controllers.mapper;

/**
 * Created by Admin on 01-12-2017.
 */
import com.eduboooks.test.controllers.serializer.NullSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;


public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper(){

        super();
        DefaultSerializerProvider.Impl sp = new DefaultSerializerProvider.Impl();
        sp.setNullValueSerializer(new NullSerializer());
        this.setSerializerProvider(sp);
    }

}
