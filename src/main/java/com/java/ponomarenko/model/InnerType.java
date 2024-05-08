package com.java.ponomarenko.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InnerType {
    CHECKS("Чеки"),
    WRITTEN_AGREEMENTS("Письменные соглашения"),
    CONTRACTS_CUSTOMERS("Договора с клиентами"),
    AGENCY_AGREEMENTS("Агентские договора "),

    TABLE_BY_CITY("Таблицы учета договоров по городу"),
    TABLE_BY_AGE("Таблицы учета договоров с клиентами по возрасту обучающихся "),
    TABLE_BY_END_DATE("Таблицы учета договоров по дате окончания действия"),
    REPORTS("Отчеты");

    private final String russianType;
}
