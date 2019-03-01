/*
 Navicat Premium Data Transfer

 Source Server         : 10.10.103.61
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : 10.10.103.61:33008
 Source Schema         : USERROLE

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 01/03/2019 10:50:51
*/


-- ----------------------------
-- Table structure for access_right
-- ----------------------------
create user USERROLE identified by USERROLE
ALTER USER USERROLE quota unlimited on SYSTEM

DROP TABLE "USERROLE"."access_right";
CREATE TABLE "USERROLE"."access_right" (
  "access_right_id" NUMBER(10) NOT NULL ,
  "access_right_name" VARCHAR2(255 CHAR) ,
  "access_right_type" VARCHAR2(255 CHAR) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for cims_user
-- ----------------------------
DROP TABLE "USERROLE"."cims_user";
CREATE TABLE "USERROLE"."cims_user" (
  "user_id" NUMBER(10) NOT NULL ,
  "english_given_name" VARCHAR2(255 CHAR) ,
  "english_surname" VARCHAR2(255 CHAR) ,
  "login_name" VARCHAR2(255 CHAR) ,
  "pword" VARCHAR2(255 CHAR) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for clinic
-- ----------------------------
DROP TABLE "USERROLE"."clinic";
CREATE TABLE "USERROLE"."clinic" (
  "clinic_id" NUMBER NOT NULL ,
  "clinic_name" VARCHAR2(255 BYTE) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "USERROLE"."clinic"."clinic_name" IS 'Clinic name';

-- ----------------------------
-- Table structure for clinic_encounter_type
-- ----------------------------
DROP TABLE "USERROLE"."clinic_encounter_type";
CREATE TABLE "USERROLE"."clinic_encounter_type" (
  "clinic_id" NUMBER NOT NULL ,
  "encounter_type_id" NUMBER NOT NULL ,
  "CLINIC_ENCOUNTER_TYPE_ID" NUMBER NOT NULL 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "USERROLE"."clinic_encounter_type"."clinic_id" IS '（combined primary key）（foreign key）';
COMMENT ON COLUMN "USERROLE"."clinic_encounter_type"."encounter_type_id" IS '（combined primary key）（foreign key）';

-- ----------------------------
-- Table structure for encounter_type
-- ----------------------------
DROP TABLE "USERROLE"."encounter_type";
CREATE TABLE "USERROLE"."encounter_type" (
  "encounter_type_id" NUMBER NOT NULL ,
  "encounter_type" VARCHAR2(255 BYTE) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "USERROLE"."encounter_type"."encounter_type" IS 'Encounter type';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE "USERROLE"."role";
CREATE TABLE "USERROLE"."role" (
  "role_id" NUMBER(10) NOT NULL ,
  "role_desc" VARCHAR2(255 CHAR) ,
  "role_name" VARCHAR2(255 CHAR) ,
  "role_status" VARCHAR2(255 CHAR) ,
  "clinic_id" NUMBER(10) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for role_accessright
-- ----------------------------
DROP TABLE "USERROLE"."role_accessright";
CREATE TABLE "USERROLE"."role_accessright" (
  "role_access_right_id" NUMBER(10) NOT NULL ,
  "access_right_id" NUMBER(10) ,
  "role_id" NUMBER(10) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE "USERROLE"."room";
CREATE TABLE "USERROLE"."room" (
  "room_id" NUMBER NOT NULL ,
  "room_name" VARCHAR2(255 BYTE) ,
  "clinic_id" NUMBER 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;
COMMENT ON COLUMN "USERROLE"."room"."room_name" IS 'Room name';
COMMENT ON COLUMN "USERROLE"."room"."clinic_id" IS 'Clinic id（foreign key）';

-- ----------------------------
-- Table structure for room_encounter_type
-- ----------------------------
DROP TABLE "USERROLE"."room_encounter_type";
CREATE TABLE "USERROLE"."room_encounter_type" (
  "room_type_id" NUMBER(10) NOT NULL ,
  "encounter_type_id" NUMBER(10) ,
  "room_id" NUMBER(10) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE "USERROLE"."user_role";
CREATE TABLE "USERROLE"."user_role" (
  "user_role_id" NUMBER NOT NULL ,
  "user_id" NUMBER(10) ,
  "role_id" NUMBER(10) 
)
TABLESPACE "SYSTEM"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  FREELISTS 1
  FREELIST GROUPS 1
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Primary Key structure for table access_right
-- ----------------------------
ALTER TABLE "USERROLE"."access_right" ADD CONSTRAINT "SYS_C007353" PRIMARY KEY ("access_right_id");

-- ----------------------------
-- Checks structure for table access_right
-- ----------------------------
ALTER TABLE "USERROLE"."access_right" ADD CONSTRAINT "SYS_C007352" CHECK ("access_right_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table cims_user
-- ----------------------------
ALTER TABLE "USERROLE"."cims_user" ADD CONSTRAINT "SYS_C007233" PRIMARY KEY ("user_id");

-- ----------------------------
-- Checks structure for table cims_user
-- ----------------------------
ALTER TABLE "USERROLE"."cims_user" ADD CONSTRAINT "SYS_C007232" CHECK ("user_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table clinic
-- ----------------------------
ALTER TABLE "USERROLE"."clinic" ADD CONSTRAINT "SYS_C007050" PRIMARY KEY ("clinic_id");

-- ----------------------------
-- Checks structure for table clinic
-- ----------------------------
ALTER TABLE "USERROLE"."clinic" ADD CONSTRAINT "SYS_C007049" CHECK ("clinic_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table clinic_encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."clinic_encounter_type" ADD CONSTRAINT "CLINIC_ENCOUNTER_TYPE_PK" PRIMARY KEY ("CLINIC_ENCOUNTER_TYPE_ID");

-- ----------------------------
-- Uniques structure for table clinic_encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."clinic_encounter_type" ADD CONSTRAINT "SYS_C007277" UNIQUE ("clinic_id", "encounter_type_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table clinic_encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."clinic_encounter_type" ADD CONSTRAINT "SYS_C007053" CHECK ("clinic_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "USERROLE"."clinic_encounter_type" ADD CONSTRAINT "SYS_C007054" CHECK ("encounter_type_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."encounter_type" ADD CONSTRAINT "SYS_C007057" PRIMARY KEY ("encounter_type_id");

-- ----------------------------
-- Checks structure for table encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."encounter_type" ADD CONSTRAINT "SYS_C007056" CHECK ("encounter_type_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "USERROLE"."role" ADD CONSTRAINT "SYS_C007231" PRIMARY KEY ("role_id");

-- ----------------------------
-- Checks structure for table role
-- ----------------------------
ALTER TABLE "USERROLE"."role" ADD CONSTRAINT "SYS_C007230" CHECK ("role_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table role_accessright
-- ----------------------------
ALTER TABLE "USERROLE"."role_accessright" ADD CONSTRAINT "SYS_C007355" PRIMARY KEY ("role_access_right_id");

-- ----------------------------
-- Checks structure for table role_accessright
-- ----------------------------
ALTER TABLE "USERROLE"."role_accessright" ADD CONSTRAINT "SYS_C007354" CHECK ("role_access_right_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table room
-- ----------------------------
ALTER TABLE "USERROLE"."room" ADD CONSTRAINT "SYS_C007052" PRIMARY KEY ("room_id");

-- ----------------------------
-- Checks structure for table room
-- ----------------------------
ALTER TABLE "USERROLE"."room" ADD CONSTRAINT "SYS_C007051" CHECK ("room_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table room_encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."room_encounter_type" ADD CONSTRAINT "SYS_C007349" PRIMARY KEY ("room_type_id");

-- ----------------------------
-- Checks structure for table room_encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."room_encounter_type" ADD CONSTRAINT "SYS_C007348" CHECK ("room_type_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table user_role
-- ----------------------------
ALTER TABLE "USERROLE"."user_role" ADD CONSTRAINT "SYS_C007048" PRIMARY KEY ("user_role_id");

-- ----------------------------
-- Checks structure for table user_role
-- ----------------------------
ALTER TABLE "USERROLE"."user_role" ADD CONSTRAINT "SYS_C007047" CHECK ("user_role_id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table clinic_encounter_type
-- ----------------------------
ALTER TABLE "USERROLE"."clinic_encounter_type" ADD CONSTRAINT "CET_CLINIC_ID___FK" FOREIGN KEY ("clinic_id") REFERENCES "USERROLE"."clinic" ("clinic_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "USERROLE"."clinic_encounter_type" ADD CONSTRAINT "CET_ENCOUNTER_TYPE_ID___FK" FOREIGN KEY ("encounter_type_id") REFERENCES "USERROLE"."encounter_type" ("encounter_type_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table role
-- ----------------------------
ALTER TABLE "USERROLE"."role" ADD CONSTRAINT "ROLE___CLINIC_ID_FK" FOREIGN KEY ("clinic_id") REFERENCES "USERROLE"."clinic" ("clinic_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table room
-- ----------------------------
ALTER TABLE "USERROLE"."room" ADD CONSTRAINT "ROOM_CLINIC_ID___FK" FOREIGN KEY ("clinic_id") REFERENCES "USERROLE"."clinic" ("clinic_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table user_role
-- ----------------------------
ALTER TABLE "USERROLE"."user_role" ADD CONSTRAINT "USER_ROLE___ROLE_ID_FK" FOREIGN KEY ("role_id") REFERENCES "USERROLE"."role" ("role_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "USERROLE"."user_role" ADD CONSTRAINT "USER_ROLE___USER_ID_FK" FOREIGN KEY ("user_id") REFERENCES "USERROLE"."cims_user" ("user_id") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
