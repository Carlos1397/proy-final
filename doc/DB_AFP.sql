SET check_function_bodies = false;

CREATE TYPE "type" AS ENUM('PRIMA','INTEGRA','PROFUTURO','HABITAT');

COMMENT ON TYPE "type" IS 'Enum tipos de AFP';

CREATE TABLE client(
  id integer NOT NULL,
  "name" character varying(50) NOT NULL,
  lastname character varying(50) NOT NULL,
  dni character varying(8) NOT NULL,
  email character varying(50) NOT NULL,
  phone character varying(9) NOT NULL,
  CONSTRAINT client_pkey PRIMARY KEY(id)
);

COMMENT ON TABLE client IS 'Clients';

CREATE TABLE afp(
id integer NOT NULL, "type" "type" NOT NULL DEFAULT 'PRIMA',
  CONSTRAINT afp_pkey PRIMARY KEY(id)
);

COMMENT ON TABLE afp IS 'AFP';

CREATE TABLE association(
  id integer NOT NULL,
  accountnumber character varying(30) NOT NULL,
  availableamount double precision NOT NULL,
  datewithdrawal date NOT NULL,
  afp_id integer NOT NULL,
  client_id integer NOT NULL,
  CONSTRAINT association_pkey PRIMARY KEY(id)
);

COMMENT ON TABLE association IS 'Vinculación AFP y CLIENT';

CREATE TABLE removal(
  id integer NOT NULL,
  withdrawalamount double precision NOT NULL,
  association_id integer NOT NULL,
  CONSTRAINT removal_pkey PRIMARY KEY(id)
);

COMMENT ON TABLE removal IS 'Request Removal AFP';

ALTER TABLE association
  ADD CONSTRAINT association_afp_id_fkey FOREIGN KEY (afp_id) REFERENCES afp (id)
  ;

ALTER TABLE association
  ADD CONSTRAINT association_client_id_fkey
    FOREIGN KEY (client_id) REFERENCES client (id);

ALTER TABLE removal
  ADD CONSTRAINT removal_association_id_fkey
    FOREIGN KEY (association_id) REFERENCES association (id);
