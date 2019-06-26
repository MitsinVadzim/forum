CREATE TABLE post (
    id UUID PRIMARY KEY,
    text TEXT,
    title TEXT,
    image_url TEXT,
    created_at TIMESTAMPTZ,
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);