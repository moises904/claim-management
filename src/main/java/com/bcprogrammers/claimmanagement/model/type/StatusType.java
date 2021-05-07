package com.bcprogrammers.claimmanagement.model.type;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.google.common.collect.ImmutableMap;

import java.util.Arrays;


@Getter
@RequiredArgsConstructor
public enum StatusType {
    STARTED(1, "Iniciado");

    private final Integer code;
    private final String description;

    private static ImmutableMap<Integer, StatusType> reverseLookupCode =
            Maps.uniqueIndex(Arrays.asList(StatusType.values()), StatusType::getCode);

    public static StatusType fromCode(Integer code) {
        StatusType statusType = reverseLookupCode.get(code);
        if (statusType != null) {
            return statusType;
        }
        throw new IllegalArgumentException("Invalid Status Type");
    }


}
