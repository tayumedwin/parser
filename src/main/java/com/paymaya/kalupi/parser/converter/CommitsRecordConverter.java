package com.paymaya.kalupi.parser.converter;

import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiCommitsRecord;
import com.paymaya.kalupi.parser.domain.Commits;
import org.jooq.DSLContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.paymaya.kalupi.parser.data.jooq.Tables.MOCHI_COMMITS;

public class CommitsRecordConverter implements Converter<Commits, MochiCommitsRecord> {

    private DSLContext dslContext;

    public CommitsRecordConverter(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    @Override
    public MochiCommitsRecord convert(Commits source) {
        MochiCommitsRecord record = dslContext.newRecord(MOCHI_COMMITS);
        record.setTransactionId(source.getTransactionId());
        record.setTransactiondate(toLocalDateTimeNull(source.getTransactionDate()));
        return record;
    }

    private static LocalDateTime toLocalDateTimeNull(Instant instant) {
        return (instant == null) ? null : LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
