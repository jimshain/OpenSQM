drop table if exists QUIZ_QUESTION_TB;
create table QUIZ_QUESTION_TB (
  QUESTION_ID varchar(36) not null,
  QUESTION_TEXT varchar(100) not null,
  ACTIVE boolean default false,
  ADD_DT timestamp
);

drop table if exists QUIZ_CHOICE_TB;
create table QUIZ_CHOICE_TB (
  QUESTION_ID varchar(36) not null,
  CHOICE_ID decimal(2) not null,
  CHOICE_TEXT varchar(100) not null,
  ANSWER boolean default false
);

drop table if exists QUIZ_CATEGORY_TB;
create table QUIZ_CATEGORY_TB (
  CATEGORY_ID varchar(36) not null,
  CATEGORY_TEXT varchar(100) not null,
  WEIGHT decimal(2) default 0,
  ADD_DT timestamp
);

drop table if exists QUIZ_QUESTION_CATEGORY_TB;
create table QUIZ_QUESTION_CATEGORY_TB (
  QUESTION_ID varchar(36) not null,
  CATEGORY_ID varchar(36) not null
);

drop table if exists QUIZ_RESPONSE_TB;
create table QUIZ_RESPONSE_TB (
  RESPONSE_ID varchar(36) not null,
  USER_ID varchar(36) not null,
  QUESTION_ID varchar(36) not null,
  CORRECT_ANSWER boolean default false,
  SENT_TIME timestamp,
  RESPONSE_TIME timestamp
);

drop table if exists QUIZ_RESPONSE_ANSWER_TB;
create table QUIZ_RESPONSE_ANSWER_TB (
  RESPONSE_ID varchar(36) not null,
  CHOICE_ID decimal(2) not null
);

drop table if exists QUIZ_EXCLUSION_TB;
create table QUIZ_EXCLUSION_TB (
  EXCLUSION_ID varchar(36) not null,
  EXCLUSION_TYPE varchar(2) not null,
  EXCLUSION_VALUE varchar(10),
  START_TIME varchar(5) not null,
  END_TIME varchar(5) not null,
  ADD_DT timestamp
);