package com.paymaya.kalupi.parser.converter;

import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiCommitsRecord;
import com.paymaya.kalupi.parser.domain.Commits;
import org.jooq.DSLContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class RecordCommitsConverter implements Converter<MochiCommitsRecord, Commits>{

    private DSLContext dslContext;

    public RecordCommitsConverter(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    @Override
    public Commits convert(MochiCommitsRecord source) {
        Commits commits = new Commits();
        commits.setTransactionId(source.getTransactionId());
        commits.setTransactionDate(toInstantOrNull(source.getTransactiondate()));
        return commits;
    }

    private static Instant toInstantOrNull(LocalDateTime localDateTime) {
        return (localDateTime == null) ? null : localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}