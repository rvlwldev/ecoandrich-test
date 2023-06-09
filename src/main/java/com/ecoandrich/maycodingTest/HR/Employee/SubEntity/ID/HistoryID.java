package com.ecoandrich.maycodingTest.HR.Employee.SubEntity.ID;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class HistoryID implements Serializable {
    private long employee;
    private LocalDate start_date;
}
