--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    transaction_id integer NOT NULL,
    amount_spent double precision NOT NULL,
    reward_points double precision NOT NULL,
    transaction_date timestamp without time zone,
    profile_id integer NOT NULL
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.transaction VALUES (2, 10, 0, '2021-07-03 08:44:34.036', 1);
INSERT INTO public.transaction VALUES (3, 5, 0, '2021-08-03 08:44:34.036', 1);
INSERT INTO public.transaction VALUES (4, 120, 0, '2021-08-01 08:44:34.036', 1);
INSERT INTO public.transaction VALUES (5, 120, 90, '2021-08-01 09:44:34.036', 1);
INSERT INTO public.transaction VALUES (6, 60, 70, '2021-08-01 10:44:34.036', 1);


--
-- Name: transaction transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (transaction_id);


--
-- Name: transaction fk41ttw4iihxjwnjfj4cqmps7xv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fk41ttw4iihxjwnjfj4cqmps7xv FOREIGN KEY (profile_id) REFERENCES public.profile(profile_id);


--
-- PostgreSQL database dump complete
--

