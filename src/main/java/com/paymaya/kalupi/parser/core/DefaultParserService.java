package com.paymaya.kalupi.parser.core;

import com.paymaya.kalupi.parser.data.ParserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;

public class DefaultParserService implements ParserService{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultParserService.class);
    private String MOCHI_STATE = "mochi-state";
    private String MOCHI_COMMITS = "mochi-commits";
    private String MOCHI_LEDGER = "mochi-ledger";

    private final ParserRepository parserRepository;
    private Clock clock;

    public DefaultParserService(ParserRepository parserRepository){
        this.parserRepository = parserRepository;
        this.clock = Clock.systemDefaultZone();
        LOG.info("DefaultParserService start");
    }

    @Override
    public void parseMochiState(String strDate, String mochiStateLogName, String type) {
        String logType = ((containsIgnoreCase(type, "commit")) ? "BadConfirm"
                : (containsIgnoreCase(type, "cancel"))? "BadCancel"
                : "BadReversal");
        String fileName = strDate + "_" + MOCHI_STATE + "_" + logType;
        LOG.info("fileName:"+fileName);
    }

    @Override
    public void parseMochiCommit(String strDate, String mochiCommitLogName, String type) {
        String logType = ((containsIgnoreCase(type, "confirm")) ? "BadConfirm"
                : (containsIgnoreCase(type, "cancel"))? "BadCancel"
                : "BadReversal");
        String fileName = strDate + "_" + MOCHI_COMMITS + "_" + logType;
        LOG.info("fileName:"+fileName);
    }

    @Override
    public void parseMochiLedger(String strDate, String mochiLedgerLogName, String type) {
        String logType = ((containsIgnoreCase(type, "confirm")) ? "BadConfirm"
                : (containsIgnoreCase(type, "cancel"))? "BadCancel"
                : "BadReversal");
        String fileName = strDate + "_" + MOCHI_LEDGER + "_" + logType;
        LOG.info("fileName:"+fileName);
    }

    public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
}
