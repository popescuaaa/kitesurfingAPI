
CREATE TABLE spots(
  id               INTEGER AUTO_INCREMENT
  ,name            VARCHAR(33) NOT NULL PRIMARY KEY
  ,longitude       NUMERIC(9,4) NOT NULL
  ,latitude        NUMERIC(8,4) NOT NULL
  ,windProbability NUMERIC(9,4)  NOT NULL
  ,country         VARCHAR(20) NOT NULL
  ,whenToGo        VARCHAR(7) NOT NULL
);