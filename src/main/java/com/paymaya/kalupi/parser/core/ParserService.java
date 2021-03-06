package com.paymaya.kalupi.parser.core;

public interface ParserService {
    //type can be BadCommit, BadConfirm, BadCancel
    void parseMochiState(String strDate, String mochiStateLogName, String type);
    void parseMochiCommit(String strDate, String mochiCommitLogName, String type);
}
