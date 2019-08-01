CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE forum_user
(
    id         UUID PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name  TEXT NOT NULL,
    role       TEXT NOT NULL,
    email      TEXT NOT NULL UNIQUE,
    password   TEXT NOT NULL,
    icon_url   TEXT,
    created_at TIMESTAMPTZ,
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);
CREATE TABLE post
(
    id         UUID PRIMARY KEY,
    content    TEXT,
    title      TEXT,
    image_url  TEXT,
    created_at TIMESTAMPTZ,
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);