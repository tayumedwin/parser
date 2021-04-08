package com.paymaya.kalupi.parser.config;

import com.paymaya.kalupi.parser.converter.CommitsRecordConverter;
import com.paymaya.kalupi.parser.converter.Converter;
import com.paymaya.kalupi.parser.converter.RecordCommitsConverter;
import com.paymaya.kalupi.parser.converter.RecordStateConverter;
import com.paymaya.kalupi.parser.converter.StateRecordConverter;
import com.paymaya.kalupi.parser.core.DefaultParserService;
import com.paymaya.kalupi.parser.core.ParserService;
import com.paymaya.kalupi.parser.data.JooqParserRepository;
import com.paymaya.kalupi.parser.data.ParserRepository;
import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiCommitsRecord;
import com.paymaya.kalupi.parser.data.jooq.tables.records.MochiStateRecord;
import com.paymaya.kalupi.parser.domain.Commits;
import com.paymaya.kalupi.parser.domain.State;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserConfig {
    private final DSLContext dslContext;

    public ParserConfig(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    @Bean
    public Converter<Commits, MochiCommitsRecord> mochiCommitsRecordConverter(){
        return new CommitsRecordConverter(dslContext);
    }

    @Bean
    public Converter<MochiCommitsRecord, Commits> recordMochiCommitsConverter(){
        return new RecordCommitsConverter(dslContext);
    }

    @Bean
    public Converter<State, MochiStateRecord> mochiStateRecordConverter(){
        return new StateRecordConverter(dslContext);
    }

    @Bean
    public Converter<MochiStateRecord, State> recordMochiStateConverter(){
        return new RecordStateConverter(dslContext);
    }

    @Bean
    public ParserRepository parserRepository(){
        return new JooqParserRepository(dslContext,
                mochiCommitsRecordConverter(),
                recordMochiCommitsConverter(),
                mochiStateRecordConverter(),
                recordMochiStateConverter()
        );
    }

    @Bean
    public ParserService parserService(){
        return new DefaultParserService(parserRepository());
    }
}
