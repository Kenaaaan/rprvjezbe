BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "grad" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"broj_stanovnika"	TEXT,
	"drzava"	INTEGER,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "drzava" (
	"id"	INTEGER,
	"naziv"	TEXT,
	"glavni_grad"	INTEGER COLLATE UTF16CI,
	PRIMARY KEY("id")
);
INSERT INTO "grad" VALUES (1,'Pariz','2200000',1);
INSERT INTO "grad" VALUES (2,'London
','8136000',2);
INSERT INTO "grad" VALUES (3,'Bec','1868000',3);
INSERT INTO "grad" VALUES (4,'Manchester','510000',2);
INSERT INTO "grad" VALUES (5,'Graz','283000',3);
INSERT INTO "drzava" VALUES (1,'Francuska',1);
INSERT INTO "drzava" VALUES (2,'Velika Britanija',2);
INSERT INTO "drzava" VALUES (3,'Austrija',3);
COMMIT;
