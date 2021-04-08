package com.paymaya.kalupi.parser.data;

import com.paymaya.kalupi.parser.domain.Commits;
import com.paymaya.kalupi.parser.domain.State;

public interface ParserRepository {
    void saveBadConfirm(Commits commits);
    void saveBadReversal(Commits commits);
    void saveBadCancel(Commits commits);
    void saveBadConfirm(State state);
    void saveBadReversal(State state);
    void saveBadCancel(State state);
}
