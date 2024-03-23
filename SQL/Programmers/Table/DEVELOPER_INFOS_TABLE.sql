USE programmers_db;

CREATE TABLE DEVELOPER_INFOS
(
	ID			VARCHAR(50) UNIQUE NOT NULL,
    FIRST_NAME 	VARCHAR(50),
    LAST_NAME   VARCHAR(50),
    EMAIL 		VARCHAR(100) UNIQUE NOT NULL,
    SKILL_1		VARCHAR(50),
    SKILL_2		VARCHAR(50),
    SKILL_3		VARCHAR(50)
);


INSERT INTO DEVELOPER_INFOS(ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3) VALUES ("D165", "Jerami", "Edwards", "jerami_edwards@grepp.co", "Java", "JavaScript", "Python");
INSERT INTO DEVELOPER_INFOS(ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3) VALUES ("D161", "Carsen", "Garza", "carsen_garza@grepp.co", "React", "null", "null");
INSERT INTO DEVELOPER_INFOS(ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3) VALUES ("D164", "Kelly", "Grant", "kelly_grant@grepp.co", "C#", "null", "null");
INSERT INTO DEVELOPER_INFOS(ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3) VALUES ("D163", "Luka", "Cory", "luka_cory@grepp.co", "Node.js", "null", "null");
INSERT INTO DEVELOPER_INFOS(ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3) VALUES ("D162", "Cade", "Cunningham", "cade_cunningham@grepp.co", "Vue", "C++", "Python");