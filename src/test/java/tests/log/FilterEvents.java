package tests.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"content", "pageable", "empty", "first", "last", "number", "size", "sort", "totalElements", "totalPages"})
public class FilterEvents {
    public Integer numberOfElements;
}
