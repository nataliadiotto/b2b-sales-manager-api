-- Step 1: Add the columns without the NOT NULL constraint
ALTER TABLE products
    ADD COLUMN created_at TIMESTAMP WITHOUT TIME ZONE,
    ADD COLUMN updated_at TIMESTAMP WITHOUT TIME ZONE;

-- Step 2: Populate the columns for existing rows with a non-null value
-- This is crucial for the NOT NULL constraint. We use the current timestamp.
UPDATE products
SET created_at = NOW(),
    updated_at = NOW();

-- Step 3: Add the NOT NULL constraint to the created_at column
ALTER TABLE products
    ALTER COLUMN created_at SET NOT NULL;