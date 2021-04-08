package com.paymaya.kalupi.parser.converter;

import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiStateRecord;
import com.paymaya.kalupi.parser.domain.State;
import org.jooq.DSLContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.paymaya.kalupi.parser.data.jooq.Tables.MOCHI_STATE;

public class StateRecordConverter implements Converter<State, MochiStateRecord> {

    private DSLContext dslContext;

    public StateRecordConverter(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    @Override
    public MochiStateRecord convert(State source) {
        MochiStateRecord record = dslContext.newRecord(MOCHI_STATE);
        record.setTransactionId(source.getTransactionId());
        record.setTransactiondate(toLocalDateTimeNull(source.getTransactionDate()));
        return record;
    }

    private static LocalDateTime toLocalDateTimeNull(Instant instant) {
        return (instant == null) ? null : LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
