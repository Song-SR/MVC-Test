CREATE TABLE tblMember(
num NUMBER NOT NULL PRIMARY KEY,
id VARCHAR2(30) NOT NULL,
pass VARCHAR2(30) NOT NULL,
name VARCHAR2(30) NOT NULL,
tel VARCHAR2(30) NOT NULL,
email VARCHAR2(30) NOT NULL
)

SELECT * FROM tblMember;

CREATE SEQUENCE num_seq;

INSERT INTO TBLMEMBER
VALUES(
num_seq.NEXTVAL, 'admin', 'admin', '관리자', '010-0000-0000', 'admin@naver.com'
);

INSERT INTO TBLMEMBER
VALUES(
num_seq.NEXTVAL, 'song', '1234', '송승룡', '010-1111-1111', 'song@naver.com'
);

delete from tblmember where num = 21;
