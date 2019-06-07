-- Table: public.invoice

-- DROP TABLE public.invoice;

CREATE TABLE public.invoice
(
    invoice_id bigint NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone NOT NULL,
    status character varying(255) COLLATE pg_catalog."default" NOT NULL,
    update_date timestamp without time zone,
    payment_id bigint NOT NULL,
    CONSTRAINT invoice_pkey PRIMARY KEY (invoice_id),
    CONSTRAINT uk_5vvlr4mmb6jbwiu4dyqwevd0d UNIQUE (payment_id)
,
    CONSTRAINT uk_7jq4q4t65on0ftpce6rjb17m9 UNIQUE (code)
,
    CONSTRAINT fkbaxa82hce5x7dqj0sotnc1cxf FOREIGN KEY (payment_id)
        REFERENCES public.payment (payment_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.invoice
    OWNER to postgres;