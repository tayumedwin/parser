CREATE TABLE mochi_state
(
    log_id              int(6)         AUTO_INCREMENT,
    transaction_id      VARCHAR(50)    DEFAULT '',
    transactionDate     DATETIME       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT mochi_state_pk PRIMARY KEY (log_id)
);

CREATE TABLE mochi_commits
(
    log_id              int(6)         AUTO_INCREMENT,
    transaction_id      VARCHAR(50)    DEFAULT '',
    transactionDate     DATETIME       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT mochi_commits_pk PRIMARY KEY (log_id)
);