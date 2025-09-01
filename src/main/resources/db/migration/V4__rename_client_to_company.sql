ALTER TABLE clients RENAME TO companies;
ALTER TABLE sales RENAME CONSTRAINT fk_sale_on_client TO fk_sale_on_company;
ALTER TABLE sales RENAME COLUMN client_id TO company_id;
