ALTER TABLE users
DROP primary key,
ADD PRIMARY KEY (id, username);