-- Table: public.customer

-- DROP TABLE public.customer;

CREATE TABLE public.customer
(
    customer_id bigint NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    update_date timestamp without time zone,
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
    CONSTRAINT uk_rm1bp9bhtiih5foj17t8l500j UNIQUE (code)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;