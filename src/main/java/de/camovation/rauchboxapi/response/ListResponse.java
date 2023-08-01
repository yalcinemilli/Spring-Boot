package de.camovation.rauchboxapi.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListResponse<T> {

    private List<T> list;
    private long count;

}
