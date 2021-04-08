package com.paymaya.kalupi.parser.converter;

import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiStateRecord;
import com.paymaya.kalupi.parser.domain.State;
import org.jooq.DSLContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class RecordStateConverter implements Converter<MochiStateRecord, State> {
    private DSLContext dslContext;

    public RecordStateConverter(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    @Override
    public State convert(MochiStateRecord source) {
        State state = new State();
        state.setTransactionId(source.getTransactionId());
        state.setTransactionDate(toInstantOrNull(source.getTransactiondate()));
        return state;
    }

    private static Instant toInstantOrNull(LocalDateTime localDateTime) {
        return (localDateTime == null) ? null : localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}
