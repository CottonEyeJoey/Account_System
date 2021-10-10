CREATE SCHEMA HR;

CREATE SEQUENCE HR.GENERIC_SEQ
    START WITH 50002
    INCREMENT BY 1;

CREATE SEQUENCE HR.MEMBER_SEQ
    START WITH 10001
    INCREMENT BY 1;

CREATE TABLE HR.ACCOUNT_TYPE (
ACCOUNT_TYPE_ID NUMBER(15) NOT NULL,
MNEMONIC VARCHAR2(50) NOT NULL UNIQUE ,
ACCOUNT_TYPE_NAME VARCHAR2(50) NOT NULL,
CREATION_DATE Date NOT NULL,

CONSTRAINT ACCOUNT_TYPE_PK PRIMARY KEY (ACCOUNT_TYPE_ID));

CREATE TABLE HR.ACCOUNT_TRANSACTION (
TRANSACTION_ID NUMBER(15) NOT NULL,
MEMBER_ID NUMBER(15) NOT NULL,
AMOUNT NUMBER(10) NOT NULL,
TRANSACTION_DATE Date NOT NULL,
ACCOUNT_TYPE_ID NUMBER(15) NOT NULL,

CONSTRAINT ACCOUNT_TRANSACTION_PK PRIMARY KEY (TRANSACTION_ID),
CONSTRAINT ACCOUNT_TYPE_ID_FK  FOREIGN KEY (ACCOUNT_TYPE_ID) REFERENCES ACCOUNT_TYPE (ACCOUNT_TYPE_ID));

CREATE TABLE HR.BALANCE (
MEMBER_ID NUMBER(15) NOT NULL,
ACCOUNT_TYPE_ID NUMBER(15) NOT NULL,
AMOUNT NUMBER(10) NOT NULL,
MNEMONIC VARCHAR2(50) NOT NULL UNIQUE ,

CONSTRAINT BALANCE_PK PRIMARY KEY (MEMBER_ID),
CONSTRAINT ACCOUNT_TYPE_ID_FK_FOR_BALANCE  FOREIGN KEY (ACCOUNT_TYPE_ID) REFERENCES ACCOUNT_TYPE (ACCOUNT_TYPE_ID),
CONSTRAINT MNEMONIC_FK  FOREIGN KEY (MNEMONIC) REFERENCES ACCOUNT_TYPE (MNEMONIC));