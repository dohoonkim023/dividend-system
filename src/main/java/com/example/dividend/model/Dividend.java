package com.example.dividend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dividend {

    @JsonSerialize(using = LocalDateTimeSerializer.class) //직렬화 방법 지정
    @JsonDeserialize(using = LocalDateDeserializer.class) //역직렬화 방법 지정
    private LocalDateTime date;



    private String dividend;
}
