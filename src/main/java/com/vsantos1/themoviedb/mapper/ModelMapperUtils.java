package com.vsantos1.themoviedb.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ModelMapperUtils {

    private static final ModelMapper mapper = new org.modelmapper.ModelMapper();

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destinationClass) {
        return mapper.map(origin, destinationClass);
    }


    public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> origin, Class<Destination> destinationClass) {
        List<Destination> destination = new ArrayList<>();

        for (Origin o : origin) {
            mapper.map(o, destination);
        }
        return destination;
    }

    public static <Origin, Destination> void copyProperties(Origin origin, Destination destination) {
        mapper.map(origin, destination);
    }

}
