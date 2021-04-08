package com.paymaya.kalupi.parser.data;

import com.paymaya.kalupi.parser.converter.CommitsRecordConverter;
import com.paymaya.kalupi.parser.converter.Converter;
import com.paymaya.kalupi.parser.converter.StateRecordConverter;
import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiCommitsRecord;
import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiStateRecord;
import com.paymaya.kalupi.parser.domain.Commits;
import com.paymaya.kalupi.parser.domain.State;
import org.jooq.DSLContext;

public class JooqParserRepository implements ParserRepository {

    private DSLContext dslContext;
    private Converter<Commits, MochiCommitsRecord> mochiCommitsRecordConverter;
    private Converter<MochiCommitsRecord, Commits> recordMochiCommitsConverter;
    private Converter<State, MochiStateRecord> mochiStateRecordConverter;
    private Converter<MochiStateRecord, State> recordMochiStateConverter;

    public JooqParserRepository(DSLContext dslContext,
                                Converter<Commits, MochiCommitsRecord> mochiCommitsRecordConverter,
                                Converter<MochiCommitsRecord, Commits> recordMochiCommitsConverter,
                                Converter<State, MochiStateRecord> mochiStateRecordConverter,
                                Converter<MochiStateRecord, State> recordMochiStateConverter){
        this.dslContext = dslContext;
        this.mochiCommitsRecordConverter = mochiCommitsRecordConverter;
        this.recordMochiCommitsConverter = recordMochiCommitsConverter;
        this.mochiStateRecordConverter = mochiStateRecordConverter;
        this.recordMochiStateConverter = recordMochiStateConverter;
    }

    @Override
    public void saveBadConfirm(Commits commits) {

    }

    @Override
    public void saveBadReversal(Commits commits) {

    }

    @Override
    public void saveBadCancel(Commits commits) {

    }

    @Override
    public void saveBadConfirm(State state) {

    }

    @Override
    public void saveBadReversal(State state) {

    }

    @Override
    public void saveBadCancel(State state) {

    }
}
