package com.paymaya.kalupi.parser.core;

import java.io.IOException;

public interface ParserService {
    //type can be BadCommit, BadConfirm, BadCancel
    void parseMochiState(String strDate, String mochiStateLogName, String type);
    void parseMochiCommit(String strDate, String mochiCommitLogName, String type);
    void parseMochiLedger(String strDate, String mochiLedgerLogName, String type);
}
